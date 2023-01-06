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

    public String getPassword(){
        return this.password;
    }

    public int getUserId() {
        return userId;
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

    public String getUserRecord(){
        return this.getUserId() + "," + this.getName() + "," + this.getSurname() +
                "," + this.getEmail() + "," + this.getPhoneNum() + "," + this.getPassword();
    }
}
