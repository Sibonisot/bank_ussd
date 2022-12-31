import java.util.Scanner;

public class Account {
    private String accountNum;
    private String accountType;
    protected static double balance = 10000.00;


    public Account(String accountNum, String accountType, double balance) {
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.balance = balance;
    }


    static void selectTransaction() {

        Scanner moneyTime = new Scanner(System.in);

        int dep;
        int with;
        //int balance = 1200;
        int choice;

        while (1 == 1) {
            System.out.println(" ");
            System.out.printf("%s%.2f%n", "Current Balance: R", balance);
            System.out.println(" ");
            System.out.println("Please select options:");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Send Cash");
            System.out.println("3. Make payment");
            System.out.println("4. Buy Airtime");
            System.out.println("5. Buy Electricity");
            System.out.println("6. View transaction history");
            System.out.println("7. Quit");
            choice = moneyTime.nextInt();

            if (choice == 1) {
                CurrentAccount.deposit();
            } else if (choice == 2) {
                CurrentAccount.sendCash();
            } else if (choice == 3) {
                CurrentAccount.makePayments();
            } else if (choice == 4) {
                CurrentAccount.buyAirtime();
            } else if (choice == 5) {
                CurrentAccount.buyElectricity();
            } else if (choice == 6) {
                CurrentAccount.sendCash();
            } else if (choice == 7) {
                CurrentAccount.sendCash();
            } else {
                System.out.println("Select a valid number");
            }
        }


    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
