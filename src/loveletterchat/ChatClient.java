package loveletterchat;


    import java.io.*;
import java.net.*;

    public class ChatClient {
        private static final String SERVER = "localhost";
        private static final int PORT = 12345;

        public static void main(String[] args) {
            try (
                    Socket socket = new Socket(SERVER, PORT);
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Thread zum Empfangen von Nachrichten
                new Thread(() -> {
                    try {
                        String msg;
                        while ((msg = in.readLine()) != null) {
                            System.out.println(msg);
                        }
                    } catch (IOException ignored) {}
                }).start();

                // Nickname senden
                System.out.print(in.readLine()); // "Enter your nickname: "
                String nickname = console.readLine();
                out.println(nickname);

                // Nachrichten senden
                String input;
                while ((input = console.readLine()) != null) {
                    out.println(input);
                    if (input.equalsIgnoreCase("bye")) break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


