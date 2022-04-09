import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

    public static void main(String[] args) throws UnknownHostException {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader
                     (new InputStreamReader(clientSocket.getInputStream()))) {
            InetAddress inetAddress = InetAddress.getByName(host);
            out.println(host + " (" + inetAddress.getHostAddress() + ")");

            String serverR = in.readLine();
            System.out.println(serverR);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
