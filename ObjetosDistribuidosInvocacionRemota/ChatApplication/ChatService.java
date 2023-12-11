import java.rmi.Remote;
import java.rmi.RemoteException;

public  interface ChatService extends Remote{
    void sendMessage(String message, String sender) throws RemoteException;
    String receiveMessage() throws RemoteException;
    void notifyClientConnected(String clientName) throws RemoteException;
}