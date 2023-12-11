import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloWorldServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            HelloWorldInterface helloWorld = new HelloWorldImpl();
            
            // Start the RMI registry on port 1099 (default)
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to a name in the RMI registry
            Naming.rebind("HelloWorld", helloWorld);

            System.out.println("Server is ready. Waiting for client requests...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
