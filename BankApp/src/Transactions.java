import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Transactions extends TransactionHistory implements ITransactions {
    List<Account> accounts;
    List<TransactionHistory> history;
    Scanner input;
    Date date;
    SimpleDateFormat dateFormat;
    String homeDir = System.getProperty("user.dir");
    String dbTransactionsPath = homeDir + "/src/database/transhistory.txt";

    /**
     * Transaction constructor initiator
     */
    Transactions() {
        input = new Scanner(System.in);
        history = new ArrayList<>();
        date = new Date();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    }

    /**
     * Deposit cash method
     * @param session
     * @throws IOException
     */
    @Override
    public void depositCash(Account session) throws IOException {
        Double amount;
        Double beforeDeposit;

        switch (chooseAccountType()) {
            case 1:
                //Cheque
                System.out.print("How much do you want to deposit: R");
                amount = input.nextDouble();

                beforeDeposit = session.getChequeBalance();
                session.setChequeBalance(session.getChequeBalance() + amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Deposit", "Cheque", amount, beforeDeposit, session.getChequeBalance()));
                System.out.println("Deposit successful...");
                System.out.println("Balance : " + session.getChequeBalance());

                break;
            case 2:
                //Savings
                System.out.print("How much do you want to deposit: R");
                amount = input.nextDouble();

                beforeDeposit = session.getSavingsBalance();
                session.setSavingsBalance(session.getSavingsBalance() + amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Deposit", "Savings", amount, beforeDeposit, session.getChequeBalance()));
                System.out.println("Deposit successful...");
                System.out.println("Balance : " + session.getSavingsBalance());
                break;
        }

    }

    /**
     * Send cash method
     * @param session
     * @throws IOException
     */
    @Override
    public void sendCash(Account session) throws IOException {
        Double amount;
        Double beforeSend;
        String phoneNumber;

        switch (chooseAccountType()) {
            case 1:
                //Cheque
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("How much do you want to send: R");
                amount = input.nextDouble();

                beforeSend = session.getChequeBalance();
                session.setChequeBalance(session.getChequeBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Cash Send", "Cheque", amount, beforeSend, session.getChequeBalance()));
                System.out.println("Sent R" + amount + " to " +  phoneNumber);
                break;
            case 2:
                //Savings
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("How much do you want to send: R");
                amount = input.nextDouble();

                beforeSend = session.getSavingsBalance();
                session.setSavingsBalance(session.getSavingsBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Cash Send", "Savings", amount, beforeSend, session.getChequeBalance()));
                System.out.println("Sent R" + amount + " to " +  phoneNumber);
                break;
        }

    }

    /**
     * Buy airtime method
     * @param session
     * @throws IOException
     */
    @Override
    public void buyAirtime(Account session) throws IOException {
        Double amount;
        String phoneNumber;
        Double beforePurchase;

        switch (chooseAccountType()) {
            case 1:
                //Cheque
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("How much airtime you want to buy: R");
                amount = input.nextDouble();

                beforePurchase = session.getChequeBalance();
                session.setChequeBalance(session.getChequeBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Prepaid", "Cheque", amount, beforePurchase, session.getChequeBalance()));
                System.out.println("R" + amount + " airtime sent to " +  phoneNumber + " successfully" );
                break;
            case 2:
                //Savings
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("How much airtime do you want to buy: R");
                amount = input.nextDouble();

                beforePurchase = session.getSavingsBalance();
                session.setSavingsBalance(session.getSavingsBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Prepaid", "Savings", amount, beforePurchase, session.getChequeBalance()));
                System.out.println("R" + amount + " airtime sent to " +  phoneNumber + " successfully" );
                break;
        }

    }

    /**
     * Buy electricity method
     * @param session
     * @throws IOException
     */
    @Override
    public void buyElectricity(Account session) throws IOException {
        Double amount;
        String phoneNumber;
        String meterNumber;
        Double beforePurchase;

        switch (chooseAccountType()) {
            case 1:
                //Cheque
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("Enter meter number: ");
                meterNumber = input.next();



                System.out.print("How much airtime you want to buy: R");
                amount = input.nextDouble();

                beforePurchase = session.getChequeBalance();
                session.setChequeBalance(session.getChequeBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Prepaid", "Cheque", amount, beforePurchase, session.getChequeBalance()));
                System.out.println("R" + amount + "electricity sent to " +  phoneNumber + " for " + meterNumber + "successfully" );
                break;
            case 2:
                //Savings
                System.out.print("Enter phone number: ");
                phoneNumber = input.next();

                System.out.print("Enter meter number: ");
                meterNumber = input.next();

                System.out.print("How much airtime do you want to buy: R");
                amount = input.nextDouble();

                beforePurchase = session.getSavingsBalance();
                session.setSavingsBalance(session.getSavingsBalance() - amount);

                this.addTransactionHistory(new TransactionHistory(session.getAccountNum(), dateFormat.format(date), "Prepaid", "Savings", amount, beforePurchase, session.getChequeBalance()));
                System.out.println("R" + amount + "electricity sent to " +  phoneNumber + " for " + meterNumber + "successfully" );
                break;
        }


    }

    // Helper functions
    public void setData(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int chooseAccountType() {
        System.out.println("Choose Account");
        System.out.println("1. Cheque Account");
        System.out.println("2. Savings Account");
        return input.nextInt();
    }

    /**
     * Method to retrieve the transaction history
     * @throws IOException
     */
    public void selectAllHistory() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dbTransactionsPath));
        String record;
        this.history.clear();

        while ((record = reader.readLine()) != null) {
                String[] item = record.split(",");
                this.history.add(new TransactionHistory(item[0], item[1], item[2], item[3], Double.valueOf(item[4]), Double.valueOf(item[5]), Double.valueOf(item[6])));
        }

        reader.close();
    }

    /**
     * Append transaction history to text file
     * @param record
     * @throws IOException
     */
    public void addTransactionHistory(TransactionHistory record) throws IOException {
        FileWriter w = new FileWriter(dbTransactionsPath);
        String records = "";

        for (TransactionHistory acc : this.history) {
            records += acc.getTransactionRecord() + "\n";
        }

        // Adding our new account record
        records += record.getTransactionRecord();
        // Storing the records in the db
        w.write(records);

        // Closing the writer stream
        w.close();

        this.selectAllHistory();
    }
}
