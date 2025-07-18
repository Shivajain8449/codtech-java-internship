import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("✅ Connected to server!");

            // Read from server
            new Thread(() -> {
                try (BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String msgFromServer;
                    while ((msgFromServer = serverIn.readLine()) != null) {
                        System.out.println("👥 " + msgFromServer);
                    }
                } catch (IOException e) {
                    System.out.println("❌ Disconnected from server.");
                }
            }).start();

            // Write to server
            try (BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
                 PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true)) {

                String userInput;
                while ((userInput = userIn.readLine()) != null) {
                    serverOut.println(userInput);
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Cannot connect to server: " + e.getMessage());
        }
    }
}

