package Controller;

import Model.PasswordManager;
import View.HomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private HomePage homePage;
    private final PasswordManager passwordManager;

    public ActionListener(HomePage homePage) {
        this.homePage = homePage;
        this.passwordManager = PasswordManager.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button.getText().equals("EXIT")) {
            passwordManager.writeListToFile();
            System.exit(0);
        }
        if(button.getText().equals("EDIT")) {
            String platform = JOptionPane.showInputDialog("Platform");
            String userName = JOptionPane.showInputDialog("User name");
            String newPassword = JOptionPane.showInputDialog("New Password");
            passwordManager.changePassword(platform, userName, newPassword);
            passwordManager.writeListToFile();
            homePage = new HomePage();
        }
    }
}
