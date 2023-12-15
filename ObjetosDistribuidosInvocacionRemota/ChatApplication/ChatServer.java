import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements ChatService{
    private List<String> messages;

    public ChatServer() throws RemoteException{
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, String sender) throws RemoteException {
        String formattedMessage = "[" + sender + "]: " + message;
        messages.add(formattedMessage);

        System.out.println(formattedMessage);
    }

    public String receiveMessage() throws RemoteException {
        StringBuilder chatHistory = new StringBuilder();
        for (String message : messages) {
            chatHistory.append(message).append("\n");
        }
        return chatHistory.toString();
    }

    public void notifyClientConnected(String clientName) throws RemoteException {
        System.out.println(clientName + " is connected.");
    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            Naming.rebind("rmi://localhost/ChatService", server);
            System.out.println("Chat server is running.");
        } catch (Exception e) {
            System.err.println("Chat server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}