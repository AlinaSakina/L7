import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            PiCalculator piStub = (PiCalculator) registry.lookup("PiCalculator");
            double piResponse = piStub.calculatePi(1000000);
            System.out.println("Value of Pi: " + piResponse);

            ECalculator eStub = (ECalculator) registry.lookup("ECalculator");
            BigDecimal eResponse = eStub.calculateE(20);  
            System.out.println("Value of E: " + eResponse);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}