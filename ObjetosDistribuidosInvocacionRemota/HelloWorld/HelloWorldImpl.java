import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorldInterface {
    public HelloWorldImpl() throws RemoteException {
        // Constructor
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, World!";
    }
}
