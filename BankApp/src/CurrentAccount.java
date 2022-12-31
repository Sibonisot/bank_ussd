import java.util.Scanner;

public class CurrentAccount extends Account{
    public CurrentAccount(String accountNum, String accountType, double balance) {
        super(accountNum, accountType, balance);
    }

    static double cBalance = getBalance();
    static Scanner scanner = new Scanner(System.in);

    public static void deposit() {

        // Check amount
        double amount = 0;
        System.out.print("Enter amount to deposit: ");
        amount = scanner.nextLong();

        if (amount > 0){
            // Check amount

            balance += amount;

            System.out.printf("Amount %.2f deposited%n ", amount);
            System.out.printf("Your current balance is: %.2f%n", getBalance());
        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }
    public static void sendCash() {
        long amt;

        //String amount = sc.nextLine();
        System.out.print("Enter cellphone number: ");
        String bName = scanner.nextLine();

        System.out.print("Enter the amount you want to send: ");
        amt = scanner.nextLong();
        if (getBalance() >= amt){
            System.out.println("Sent R" + amt + " to " +  bName );
        }
        if (getBalance() >= amt) {
            cBalance = getBalance() - amt;
            System.out.println("Balance after sending cash: " + cBalance);
            Account.selectTransaction();

        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }

    public static void makePayments() {
        long amt;

        //String amount = sc.nextLine();
        System.out.print("Enter beneficiary name: ");
        String bName = scanner.nextLine();

        System.out.print("Enter the amount you want to pay: ");
        amt = scanner.nextLong();
        if (getBalance() >= amt){
            System.out.println("Paid R" + amt + " to " +  bName );
        }
        if (getBalance() >= amt) {
            cBalance = getBalance() - amt;
            System.out.println("Balance after payment: " + cBalance);
            Account.selectTransaction();

        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }

    public static void buyAirtime() {
        long amt;

        //String amount = sc.nextLine();
        System.out.print("Enter cellphone number: ");
        String cNum = scanner.nextLine();

        System.out.print("Enter the airtime amount you need to buy: ");
        amt = scanner.nextLong();
        if (getBalance() >= amt){
            System.out.println("R" + amt + " sent to " +  cNum );
        }
        if (getBalance() >= amt) {
            cBalance = getBalance() - amt;
            System.out.println("Balance after buying airtime: " + cBalance);
            Account.selectTransaction();

        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed!" );
        }
    }

    public static void buyElectricity() {
        long amt;

        //String amount = sc.nextLine();
        System.out.print("Enter meter number: ");
        String mNum = scanner.nextLine();

        System.out.print("Enter the amount you want to buy: ");
        amt = scanner.nextLong();
        if (getBalance() >= amt){
            System.out.println("Bought R " + amt + " for " +  mNum );
        }
        if (getBalance() >= amt) {
            cBalance = getBalance() - amt;
            System.out.println("Balance after buying electricity: " + cBalance);
            Account.selectTransaction();

        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed!" );
        }
    }
}
