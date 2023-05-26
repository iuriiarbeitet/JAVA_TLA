import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame implements Runnable {
    private final String serverHost;
    private final int serverPort;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    JTextArea serverMsgElement;
    JTextField clientMsgElement;

    public ClientWindow(String host, int port) {
        serverHost = host;
        serverPort = port;
    }

    @Override
    public void run() {
        initConnection();
        initGui();
        initServerListener();
    }

    private void initConnection() {
        try {
            socket = new Socket(serverHost, serverPort);
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGui() {
        setBounds(600, 300, 500, 500);
        setTitle("Chat Client");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        serverMsgElement = new JTextArea();
        serverMsgElement.setEditable(false);
        serverMsgElement.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(serverMsgElement);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("SEND");
        bottomPanel.add(sendButton, BorderLayout.EAST);
        clientMsgElement = new JTextField();
        bottomPanel.add(clientMsgElement, BorderLayout.CENTER);

        // Отправка сообщения по нажатию кнопки
        sendButton.addActionListener(e -> {
            String message = clientMsgElement.getText();
            sendMessage(message);
            clientMsgElement.grabFocus();
        });

        // Отправка по Enter
        clientMsgElement.addActionListener(e -> {
            String message = clientMsgElement.getText();
            sendMessage(message);
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeConnection();
            }
        });

        setVisible(true);
    }

    private void sendMessage(String message) {
        if (!message.isEmpty()) {
            out.println(message);
            out.flush();
            clientMsgElement.setText("");
        }
    }

    private void closeConnection() {
        out.println("end");
        out.flush();
        try {
            socket.close();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServerListener() {
        new Thread(() -> {
            try {
                while (true) {
                    if (in.hasNext()) {
                        String message = in.nextLine();
                        serverMsgElement.append(message + "\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}
