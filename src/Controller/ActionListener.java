package Controller;

import Model.PasswordManager;
import View.HomePage;
import View.StyleSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private final HomePage homePage;
    private final PasswordManager passwordManager;

    public ActionListener(HomePage homePage) {
        this.homePage = homePage;
        this.passwordManager = PasswordManager.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JTextField textField) {
            homePage.filter(textField.getText());
        }

        if (e.getSource() instanceof JButton button) {
            if (button.getText().equals("EXIT")) {
                passwordManager.writeListToFile();
                System.exit(0);
            }
            if (button.getText().equals("EDIT")) {
                //setSelectedColors(button);
                String platform = JOptionPane.showInputDialog("Platform");
                String userName = JOptionPane.showInputDialog("User name");
                String newPassword = JOptionPane.showInputDialog("New Model.Password(Leave blank if you want a generated password)");
                //resetColors(button);
                passwordManager.changePassword(platform, userName, newPassword);
                homePage.refresh();
            }

            if (button.getText().equals("REMOVE")) {
                setSelectedColors(button);
                String platform = JOptionPane.showInputDialog("Platform");
                String userName = JOptionPane.showInputDialog("User name");
                resetColors(button);
                passwordManager.removePasswordEntry(platform, userName);
                homePage.refresh();
            }
        }
    }

    public void setSelectedColors(JButton button) {
        button.setForeground(StyleSettings.getInstance().getTextColor_SELECTED());
        button.setBackground(StyleSettings.getInstance().getBackgroundColor_SELECTED());
    }

    public void resetColors(JButton button) {
        button.setForeground(StyleSettings.getInstance().getTextColor_DARK());
        button.setBackground(StyleSettings.getInstance().getBackgroundColor_LIGHT());
    }
}
