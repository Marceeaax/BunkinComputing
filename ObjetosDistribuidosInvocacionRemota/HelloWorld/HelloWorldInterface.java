import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorldInterface extends Remote {
    public String sayHello() throws RemoteException;
}