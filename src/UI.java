import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    private final PasswordManager passwordManager;
    public UI() {
        this.passwordManager = PasswordManager.getInstance();
    }

    public void loginPage() {
        //TODO: Create the login page
    }

    public void mainPage() {
        //TODO: Create the main page
    }

    public void addOrEditPage() {
        //TODO: Create the add or edit page
    }

    public void registrationPage() {

    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
}