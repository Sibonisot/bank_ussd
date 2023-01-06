import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Account extends AccountUser{
    private String accountNum;
    private Map<String, Double> accountType = new HashMap<>();;

    public Account(
            int userId, String name,
            String surname, String email,
            String phoneNum, String password,
            String accountNumber,
            double chequeBalance,
            double savingsBalance) throws IOException {
        super(userId, name, surname, email, phoneNum, password);
        this.accountNum = accountNumber;
        this.accountType.put("cheque", chequeBalance);
        this.accountType.put("savings", savingsBalance);
    }

    public Double getChequeBalance(){
        return this.accountType.get("cheque");
    }

    public Double getSavingsBalance(){
        return this.accountType.get("savings");
    }

    public void setChequeBalance(Double balance){
        this.accountType.put("cheque", balance);
    }

    public void setSavingsBalance(Double balance){
        this.accountType.put("savings", balance);
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountRecord(){
        return this.getUserRecord() + "," + this.getAccountNum() + "," +
                this.getChequeBalance() + "," + this.getSavingsBalance();
    }
}
