import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppRunner {
    static Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println();
        System.out.println("Welcome to Bank USSD App.");

        //AccountUser accountUser = getUserId();
        //AccountUser accountUser = null;
        //AccountUser.userLogin(scanner, accountUser);
        new File().displayText();

        try {
            System.out.println("=============================");
            System.out.println("BANK USSD APP");
            System.out.println();
            System.out.println("1. Create user account");
            System.out.println("2. Login");
            System.out.println("=============================");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                AppRunner.inputAccountUserDetails();
            } else if (choice.equals("2")) {
                userLogin();

            } else {
                System.out.println("Please enter the valid choice");
                //new UserAccount();
            }
        } catch (Exception ex) {
        }

    }

    /**
     * User creates new account
     * @return new account user
     */


    static AccountUser inputAccountUserDetails() {
        // user enters name
        System.out.print("CREATE NEW ACCOUNT");
        System.out.println();
        System.out.print("Enter your ID number: ");
        int userId = scanner.nextInt();

        System.out.print("Enter your Name: ");
        String name = scanner.next();

        System.out.print("Enter your Surname: ");
        String surname = scanner.next();

        System.out.print("Enter your Email: ");
        String email = scanner.next();

        // user inputs age
        System.out.print("Enter your Phone Number: ");
        String phoneNum = scanner.next();

        System.out.print("Create password: ");
        String password = scanner.next();


        new File().appendFirstLine(userId + " , " + name + " , " + surname + " , " + email + " , " + phoneNum + " , " + password);
        new File().appendBlankLine();
        System.out.println("New account has been created!");
        scanner.nextLine();

        System.out.println("Press any key to continue...");
        scanner.nextLine();
        userLogin();


        // create a TaxPayer
        return new AccountUser(userId, name, surname, email, phoneNum, password);
    }

    public static void userLogin() {

        try {
            String homeDir = System.getProperty(("user.dir"));
            String filename = homeDir + "/out.txt";
            //String filename = "C:\\Users\\Siboniso Mabuza\\IdeaProjects\\BankApp\\out.txt";
            Path path = Paths.get(filename);
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println("=========== LOGIN ===========");
            System.out.print("Enter your phone number: ");
            String phoneNum = AppRunner.scanner.nextLine();
            System.out.print("Enter password: ");
            String password = AppRunner.scanner.nextLine();
            String _userId;
            String _temp = null;
            String _name = "";
            String _surname = "";
            String _email;
            String _phoneNum;
            String _pass;
            boolean found = false;
            while ((_temp = reader.readLine()) != null) {
                String[] account = _temp.split(" , ");
                _userId = account[0];
                _name += account[1];
                _surname += account[2];
                _email = account[3];
                _phoneNum = account[4];
                _pass = account[5];
                if (_phoneNum.equals(phoneNum) && _pass.equals(password)) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Access granted");
                //System.out.println("Welcome " + _name + "  " + _surname);
                Account.selectTransaction();
            } else {
                System.out.println("Access denied! Invalid username or Password");
            }
            reader.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}