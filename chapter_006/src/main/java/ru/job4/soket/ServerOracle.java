package ru.job4.soket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
/**
 * ServerOracle.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ServerOracle {
    /**
     * Поле - хранит ссылку класса Socket.
     */
    private Socket socket;
    /**
     * Поле - хранит список ответов клиенту.
     */
    private final Map<String, String> map = new HashMap<>();
    /**
     * Конструктор для активации переменых.
     * @param socket ссылка класса Socket
     */
    public ServerOracle(Socket socket) {
        this.socket = socket;
    }
    /**
     * Метод переписки с клиентом через соккет.
     */
    public void connect() throws IOException {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String ask;
            String answer;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("exit".equals(ask)) {
                    break;
                }
                answer = load().get(ask);
                if (answer == null) {
                    answer = "ask me something else.";
                }
                out.println(answer);
                out.println();
            } while (!"exit".equals(ask));
        }
    }
    /**
     * Метод возвращает  список ответов сервера.
     * @return map список ответов сервера клиенту.
     */
    private Map<String, String> load() {
        this.map.put("hello", "Hello, dear friend, I'm a oracle.");
        this.map.put("hi", "Hi, how are you doing");
        this.map.put("what's up", "I'm wise, I can answer everything");
        this.map.put("what do you like?", "eat and sleep");
        return this.map;
    }
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(2030).accept()) {
            new ServerOracle(socket).connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
