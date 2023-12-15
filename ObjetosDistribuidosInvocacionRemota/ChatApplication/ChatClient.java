import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            ChatService chatService = (ChatService) Naming.lookup("rmi://localhost/ChatService");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String sender = scanner.nextLine();

            // Print a "connected" message on the server side
            chatService.notifyClientConnected(sender);

            while (true) {
                System.out.print("Enter your message (or 'exit' to quit): ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                chatService.sendMessage(message, sender);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Chat client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
