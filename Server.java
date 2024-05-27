import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            PiCalculator piCalculator = new PiCalculatorImpl();
            ECalculator eCalculator = new ECalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("PiCalculator", piCalculator);
            registry.bind("ECalculator", eCalculator);
            System.out.println("Server is running");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

