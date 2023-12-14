package Controller;

import Model.Password;
import Model.PasswordManager;
import View.HomePage;
import View.ListPanel;
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
            if (button.getText().equals("QUIT")) {
                passwordManager.writeListToFile();
                System.exit(0);
            }
            if (button.getText().equals("ADD ENTRY")) {
                setSelectedColors(button);
                String platform = JOptionPane.showInputDialog("Platform");
                String userName = JOptionPane.showInputDialog("User name");
                String password = JOptionPane.showInputDialog("Password(Leave blank if you want a generated password)");
                resetColors(button);

                Password newEntry = new Password(platform, userName, password);
                passwordManager.addPasswordEntry(newEntry);

                passwordManager.sortList();
                homePage.addComponent(new ListPanel(newEntry.getPlatform(), newEntry.getUserName(), newEntry.getPassword()));
                homePage.refresh();
            }
            if (button.getText().equals("EDIT ENTRY")) {
                setSelectedColors(button);
                String platform = JOptionPane.showInputDialog("Platform");
                String userName = JOptionPane.showInputDialog("User name");
                String newPassword = JOptionPane.showInputDialog("Password(Leave blank if you want a generated password)");
                resetColors(button);
                passwordManager.changePassword(platform, userName, newPassword);
            }

            if (button.getText().equals("DELETE ENTRY")) {
                setSelectedColors(button);
                String platform = JOptionPane.showInputDialog("Platform");
                String userName = JOptionPane.showInputDialog("User name");
                resetColors(button);
                passwordManager.removePasswordEntry(platform, userName);
                homePage.removeComponent(new ListPanel(platform, userName, ""));
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
