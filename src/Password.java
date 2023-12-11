import java.io.Serializable;
import java.time.LocalDate;

public class Password implements Serializable {
    private int passwordLength;
    private String platform;
    private String userName;
    private String password;
    private final LocalDate date;

    public Password(String platform, String userName, String password) {
        this.platform = platform;
        this.userName = userName;
        this.password = password;
        this.passwordLength = 16;
        this.date = LocalDate.now();
    }

    public Password(String platform, String userName, int passwordLength) {
        this.platform = platform;
        this.userName = userName;
        this.date = LocalDate.now();
        generatePassword(passwordLength);
    }

    public Password(String platform, String userName) {
        this.passwordLength = 16;
        this.platform = platform;
        this.userName = userName;
        this.date = LocalDate.now();
        generatePassword(this.passwordLength);
    }

    public void generatePassword(int passwordLength) {
        //TODO: Generate a random password
    }

    //Getters and setters
    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }
}
