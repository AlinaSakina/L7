import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.math.BigDecimal;

public class ECalculatorImpl extends UnicastRemoteObject implements ECalculator {

    private static final BigDecimal ONE = BigDecimal.ONE;

    protected ECalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public BigDecimal calculateE(int digits) {
        return computeE(digits);
    }

    private BigDecimal computeE(int digits) {
        int scale = digits + 5;
        BigDecimal result = ONE;
        BigDecimal term = ONE;
        int i = 1;

        while (term.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal factorial = factorial(i);
            term = ONE.divide(factorial, scale, BigDecimal.ROUND_HALF_UP);
            result = result.add(term);
            i++;
        }

        return result.setScale(digits, BigDecimal.ROUND_DOWN);
    }

    private BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}