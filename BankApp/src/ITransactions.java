import java.io.IOException;

public interface ITransactions {
    public void depositCash(Account session) throws IOException;
    public void sendCash(Account session) throws IOException;
    public void buyElectricity (Account session) throws IOException;
    public void buyAirtime(Account session) throws IOException;
    public void viewTransactionHistory(Account session) throws IOException;
}
