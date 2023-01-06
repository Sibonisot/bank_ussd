import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class TransactionHistory {
    private String transactionDate;
    private String transactionAction;
    private String accountType;
    private Double amount;
    private Double beforeTransaction;
    private Double afterTransaction;
    private String userAccount;

    public TransactionHistory(){}
    public TransactionHistory(String accNumber, String transactionDate, String transactionAction, String accountType, Double amount, Double beforeTransaction, Double afterTransaction) {
        this.transactionDate = transactionDate;
        this.transactionAction = transactionAction;
        this.accountType = accountType;
        this.amount = amount;
        this.beforeTransaction = beforeTransaction;
        this.afterTransaction = afterTransaction;
        this.userAccount= accNumber;
    }

    static String homeDir = System.getProperty("user.dir");
    static String dbTransactionsPath = homeDir + "/src/database/transhistory.txt";

    public String getUserAccount() {
        return userAccount;
    }

    public String getTransactionRecord(){

        return this.getUserAccount() + "," + this.getTransactionDate() + "," + this.getTransactionAction() + "," +
                this.getAccountType()+ "," + this.getAmount() + "," + this.getBeforeTransaction() +
                "," + this.getAfterTransaction();
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionAction() {
        return transactionAction;
    }

    public String getAccountType() {
        return accountType;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getBeforeTransaction() {
        return beforeTransaction;
    }

    public Double getAfterTransaction() {
        return afterTransaction;
    }

        public static void displayTransactionHistory() {
        try {
            java.io.File file = new java.io.File(dbTransactionsPath);    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line=br.readLine())!= null) {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resource
            System.out.println(sb.toString());   //returns a string that textually represents the object
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
