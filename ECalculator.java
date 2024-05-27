import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigDecimal;

public interface ECalculator extends Remote {
    BigDecimal calculateE(int digits) throws RemoteException;
}