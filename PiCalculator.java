import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PiCalculator extends Remote {
    double calculatePi(int terms) throws RemoteException;
}
