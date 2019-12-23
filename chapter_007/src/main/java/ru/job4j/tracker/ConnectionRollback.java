package ru.job4j.tracker;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * ConnectionRollback.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConnectionRollback {
    /**
     * Фабричный метод, который создает Connection, в котором метод close работает с вызовом rollback.
     * @param connection - ссылка на класс Connection.
     * @return Connection - объект класса.
     * @throws SQLException possible exception.
     */
    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[] {Connection.class},
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}

