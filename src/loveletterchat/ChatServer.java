package loveletterchat;



    import java.io.*;
import java.net.*;
import java.util.*;

    public class ChatServer {
        private static final int PORT = 12345;
        private static final Map<String, Socket> clients = new HashMap<>();

        public static void main(String[] args) {
            System.out.println("loveletterchat.ChatServer läuft auf Port " + PORT);
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static synchronized boolean nicknameExists(String name) {
            return clients.containsKey(name);
        }

        private static void handleClient(Socket socket) {
            String nickname = null;
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                out.println("Enter your nickname: ");
                nickname = in.readLine().trim();

                synchronized (clients) {
                    if (nicknameExists(nickname)) {
                        out.println("Nickname already taken. Connection closing.");
                        socket.close();
                        return;
                    }
                    clients.put(nickname, socket);
                }

                out.println("Welcome " + nickname + "!");
                broadcast(nickname + " joined the room.", nickname);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("bye")) {
                        break;
                    }
                    broadcast(nickname + ": " + message, null);
                }
            } catch (IOException e) {
                System.out.println("Verbindung mit " + nickname + " unterbrochen.");
            } finally {
                if (nickname != null) {
                    synchronized (clients) {
                        clients.remove(nickname);
                    }
                    broadcast(nickname + " left the room.", nickname);
                    try {
                        socket.close();
                    } catch (IOException ignored) {}
                }
            }
        }

        private static void broadcast(String message, String excludeNickname) {
            synchronized (clients) {
                for (Map.Entry<String, Socket> entry : clients.entrySet()) {
                    if (entry.getKey().equals(excludeNickname)) continue;
                    try {
                        PrintWriter out = new PrintWriter(entry.getValue().getOutputStream(), true);
                        out.println(message);
                    } catch (IOException ignored) {}
                }
            }
        }
    }


