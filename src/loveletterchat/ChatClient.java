package loveletterchat;


    import java.io.*;
import java.net.*;

    public class ChatClient {
        private static final String SERVER = "localhost";
        private static final int PORT = 12345;

        public static void main(String[] args) {
            try (
                    Socket socket = new Socket(SERVER, PORT); //Verbindung aufbauen
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true) //Nachrichten an den Server schicken, es benutzt die Verbindung (socket) und schickt den Text weiter
            ) {
                // Thread zum Empfangen von Nachrichten
                new Thread(() -> { //Dieser „Thread“ ist wie ein extra Hintergrundprogramm, das immer wieder prüft, ob neue Nachrichten vom Server kommen – und sie auf dem Bildschirm anzeigt, ohne  zu stören
                    try {
                        String msg;
                        while ((msg = in.readLine()) != null) { // solange Nachrichten eingegeben werden, werden die angezeigt
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

            } catch (IOException e) { // Falls etwas schiefläuft (z. B. Server ist offline), wird eine Fehlermeldung ausgegeben, statt dass  Programm abstürzt
                e.printStackTrace();
            }
        }
    }


