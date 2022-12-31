import java.util.Scanner;

public class AccountUser {
    private String password;
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String phoneNum;

    public AccountUser(int userId, String name, String surname, String email, String phoneNum, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public static void userLogin(Scanner scanner, AccountUser accountUser) {
        //inputAccountUserDetails(scanner, accountUser);
        int menu = scanner.nextInt();

        //inputLoginDetails(scanner, accountUser);

        // determining the nett taxable income
        //taxPayer.setNettTaxableIncome(taxPayer.getTotalIncome().subtract(taxPayer.getTotalExpenses()));

        // if nettTaxableIncome is negative, then prompt user to enter values again
        while (menu < 0){
            System.out.println("Menu:");
            System.out.println("1. Register new account");
            System.out.println("2. Login");

            if (menu == 1){
                AppRunner.inputAccountUserDetails();
            }
            else if(menu == 2){
                //inputLoginDetails(scanner, taxPayer);
            }
            // determining the nett taxable income
            //taxPayer.setNettTaxableIncome(taxPayer.getTotalIncome().subtract(taxPayer.getTotalExpenses()));
        }

    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
