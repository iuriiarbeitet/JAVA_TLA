import javax.swing.*;
import java.util.Scanner;

public class ClientApp {

    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("end")) {
                break;
            }
            if (str.equals("add")) {
                SwingUtilities.invokeLater (new ClientWindow(SERVER_HOST, SERVER_PORT));
            }
        }
    }

}
