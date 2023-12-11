import java.rmi.Naming;

public class HelloWorldClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object by its name
            HelloWorldInterface helloWorld = (HelloWorldInterface) Naming.lookup("rmi://localhost/HelloWorld");

            // Call the remote method and print the result
            String message = helloWorld.sayHello();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
