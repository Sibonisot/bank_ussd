import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class USSD extends Transactions implements IUSSD {
    List<Account> accounts;
    //    User session to keep user logged-in!
    Account session;
    Scanner input;
    String homeDir = System.getProperty("user.dir");
    String dbAccountsPath = homeDir + "/src/database/useraccounts.txt";

    USSD() {
        super();
        this.accounts = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    @Override
    public Account userAuth() throws IOException {
        switch (authMenu()) {
            case 1:
                // Create New Account
                Account newAccount = createNewAccount();

                //Using the created account to automatically login
                return login(newAccount.getPhoneNum(), newAccount.getPassword());
            case 2:
                // Login
                System.out.println("USER LOGIN");
                System.out.println();
                System.out.println("Enter PhoneNumber: ");
                String number = input.next();

                System.out.println("Enter Password: ");
                String password = input.next();

                return login(number, password);
        }
        return null;
    }

    @Override
    public void startApplication() throws IOException {
        //Get all records from the database
        this.selectAllRecords();
        this.selectAllHistory();

        if ((session = userAuth()) != null) {
            System.out.println("Authentication successful");
            System.out.println("--------------------------");

            while (session != null) {
                switch (appMenu()) {
                    case 1:
                        // Deposit
                        this.depositCash(session);
                        break;
                    case 2:
                        // Send cash
                        this.sendCash(session);
                        break;
                    case 3:
                        // Buy Airtime
                        this.buyAirtime(session);
                        break;
                    case 4:
                        // Buy Electricity
                        this.buyElectricity(session);
                        break;

                    case 5:
                        // View History
                        this.viewTransactionHistory(session);
                        break;
                    case 6:
                        exit();
                        break;
                }
                this.updateDatabase();
            }
        } else {
            System.out.println("Authentication Failed!");
        }
    }

    @Override
    public void exit() {
        // Destroying the session
        session = null;
    }

    @Override
    public int appMenu() {
        System.out.println();
        System.out.println("Welcome to Bank USSD App");
        System.out.printf("%s%.2f%n", "Current Balance: R", session.getChequeBalance() + session.getSavingsBalance());
        System.out.println();
        System.out.println("Please select option:");
        System.out.println("1. Deposit Cash");
        System.out.println("2. Send Cash");
        System.out.println("3. Buy Airtime");
        System.out.println("4. Buy Electricity");
        System.out.println("5. View transaction history");
        System.out.println("6. Quit");
        return input.nextInt();
    }

    @Override

    public int authMenu() throws IOException {
        System.out.println("--------------------------");
        System.out.println("BANK USSD APP");
        System.out.println("--------------------------");

        System.out.println("Please select option:");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        return input.nextInt();
    }

    //Helper Functions
    public String generateAccountNumber() {
        String accNum = "62";
        Random rand = new Random();

        for (int i = 0; i < 9; i++) {
            accNum += String.valueOf(rand.nextInt(10));
        }
        return accNum;
    }

    public Account login(String phoneId, String password) throws IOException {
        for (Account acc : this.accounts) {
            if (phoneId.compareTo(acc.getPhoneNum()) == 0 && password.compareTo(acc.getPassword()) == 0) {
                return acc;
            }
        }
        return null;
    }

    public Account createNewAccount() throws IOException {
        System.out.print("CREATE USER ACCOUNT:");
        System.out.println();

        System.out.print("Enter your ID number: ");
        int userId = input.nextInt();

        System.out.print("Enter your Name: ");
        String name = input.next();

        System.out.print("Enter your Surname: ");
        String surname = input.next();

        System.out.print("Enter your Email: ");
        String email = input.next();

        // user inputs age
        System.out.print("Enter your Phone Number: ");
        String phoneNum = input.next();

        System.out.print("Create password: ");
        String password = input.next();

        Account newAccount =
                new Account(userId, name, surname, email, phoneNum, password, generateAccountNumber(), 0.0, 0.0);

        //Add this account to database
        insertRecord(newAccount.getAccountRecord());

        return newAccount;
    }

    public void selectAllRecords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dbAccountsPath));
        String record;
        this.accounts.clear();

        while ((record = reader.readLine()) != null) {
            String[] item = record.split(",");
            this.accounts.add(new Account(Integer.valueOf(item[0]), item[1], item[2],
                    item[3], item[4], item[5], item[6], Double.valueOf(item[7]), Double.valueOf(item[8])));
        }

        reader.close();
        this.setData(this.accounts);
    }

    public void insertRecord(String record) throws IOException {
        FileWriter w = new FileWriter(dbAccountsPath);
        String records = "";

        for (Account acc : this.accounts) {
            records += acc.getAccountRecord() + "\n";
        }

        // Adding our new account record
        records += record;
        // Storing the records in the db
        w.write(records);

        // Closing the writer stream
        w.close();

        selectAllRecords();
    }

    public void updateDatabase() throws IOException {
        FileWriter w = new FileWriter(dbAccountsPath);
        String records = "";

        for (Account acc : this.accounts) {
            records += acc.getAccountRecord() + "\n";
        }

        // Storing the records in the db
        w.write(records);

        // Closing the writer stream
        w.close();
    }

    @Override
    public void viewTransactionHistory(Account session) throws IOException {
        System.out.println("TRANSACTION HISTORY");
        System.out.println();
        System.out.println("ACCOUNT     DATE       TRANSACT TYPE  AMOUNT BEFORE  AFTER");

        displayTransactionHistory();
    }
}
