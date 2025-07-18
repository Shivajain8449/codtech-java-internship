import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("🔌 Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("✅ Client connected: " + clientSocket);
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("❌ Server Error: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                clientWriters.add(out);
                String message;

                while ((message = in.readLine()) != null) {
                    System.out.println("📨 Received: " + message);
                    for (PrintWriter writer : clientWriters) {
                        writer.println(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("⚠️ Connection error with client.");
            } finally {
                try {
                    socket.close();
                    clientWriters.remove(out);
                } catch (IOException e) {
                    System.out.println("Error closing connection");
                }
            }
        }
    }
}
