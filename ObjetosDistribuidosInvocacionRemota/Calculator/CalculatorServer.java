import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorService {
    public CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double sub(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double mul(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double div(double a, double b) throws RemoteException {
        return a / b;
    }


    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            Naming.rebind("rmi://localhost/CalculatorService", server);
            System.out.println("Calculator server is running.");
        } catch (Exception e) {
            System.err.println("Calculator server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}   