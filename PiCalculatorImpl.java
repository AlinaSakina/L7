import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PiCalculatorImpl extends UnicastRemoteObject implements PiCalculator {
    protected PiCalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double calculatePi(int terms) throws RemoteException {
        double result = 0;
        double sign = 1;
        for (int i = 0; i < terms; i++) {
            result += sign / (2 * i + 1);
            sign = -sign;
        }
        return result * 4;
    }
}