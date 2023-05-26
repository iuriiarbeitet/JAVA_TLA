import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner in;
    private static int CLIENTS_COUNT = 0;
    private String name;

    private Server server;

    public ClientHandler(Socket s, Server server) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            CLIENTS_COUNT++;
            name = "Клиент № " + CLIENTS_COUNT;
            this.server = server;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String w = in.nextLine();
                String s = name + ": " + w;
                System.out.println(s);
                sendMessage(s);
                if (w.equals("end")) {
                    break;
                }
            }
        }
        try {
            System.out.println("Клиент отключился");
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        server.getClients().forEach(client -> {
            client.out.println(message);
            client.out.flush();
        });
    }

}
