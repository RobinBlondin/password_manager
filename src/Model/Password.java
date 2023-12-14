package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

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
        if (password.isEmpty()) {
            generatePassword(this.passwordLength);
        }
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
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        password = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(passwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
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
