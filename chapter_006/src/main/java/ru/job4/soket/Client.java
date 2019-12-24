package ru.job4.soket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
/**
 * Client.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Client {
    /**
     * Поле - хранит ссылку класса Socket.
     */
    private Socket socket;
    /**
     * Поле - хранит ссылку класса BufferedReader.
     */
    private BufferedReader reader;
    /**
     * Конструктор для активации переменых.
     * @param socket ссылка класса Socket
     * @param reader ссылка класса BufferedReader.
     */
    public Client(Socket socket, BufferedReader reader) {
        this.socket = socket;
        this.reader = reader;
    }
    /**
     * Метод переписки с сервером через соккет.
     */
    public void start() throws IOException {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String str;
            do {
                str = reader.readLine();
                out.println(str);
                if (!"exit".equals(str)) {
                    while (!in.readLine().isEmpty()) {
                        System.out.println(str);
                    }
                }
            } while (!str.equals("exit"));
        }
    }
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        try (Socket socket = new Socket(InetAddress.getByName(ip), 2030);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            new Client(socket, reader).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


