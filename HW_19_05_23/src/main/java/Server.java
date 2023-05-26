import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int serverPort;

    private List<ClientHandler> clients = new ArrayList<>();

    public Server(int port) {
        serverPort = port;
        ServerSocket server = null;
        Socket s = null;
        try {
            server = new ServerSocket(serverPort);
            System.out.println("Сервер запущен. Ожидание клиентов...");
            while (true) {
                // Как только клиент подключился, создаем сокет (соединение)
                s = server.accept();
                System.out.println("Клиент подключился");
                ClientHandler client = new ClientHandler(s, this);
                clients.add(client);
                // В отдельном потоке запускаем обработчик этого клиента
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("Сервер закрыт");
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ClientHandler> getClients() {
        return clients;
    }

}
