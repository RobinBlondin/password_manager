package View;

import Controller.ActionListener;
import Model.PasswordManager;
import View.StyleSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ListPanel extends JPanel {
    private StyleSettings styleSettings = StyleSettings.getInstance();
    private final PasswordManager passwordManager = PasswordManager.getInstance();
    private final JLabel platformLabel;
    private final JLabel usernameLabel;
    private final JButton passwordLabel;
    private final JComboBox dropButton;

    public ListPanel(String platform, String username, String password, HomePage homePage) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(700, 50));
        this.setMaximumSize(new Dimension(700, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));

        String [] options = {"Copy password", "Copy username", "Remove", "Edit"};
        platformLabel = new JLabel(platform);
        platformLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        usernameLabel = new JLabel(username);
        passwordLabel = new JButton("***************");
        JButton copyButton = new JButton();
        JPanel centerPanel = new JPanel();
        JLabel emptyLabel = new JLabel();
        dropButton = new JComboBox(options);

        centerPanel.setBackground(Color.WHITE);

        platformLabel.setFont(styleSettings.getSmallFont());
        usernameLabel.setFont(styleSettings.getSmallFont());
        passwordLabel.setFont(styleSettings.getSmallFont());
        copyButton.setFont(styleSettings.getSmallFont());

        platformLabel.setPreferredSize(new Dimension(150, 50));
        usernameLabel.setPreferredSize(new Dimension(150, 50));
        passwordLabel.setPreferredSize(new Dimension(200, 50));
        dropButton.setPreferredSize(new Dimension(150, 50));
        //copyButton.setPreferredSize(new Dimension(50, 50));
        //emptyLabel.setPreferredSize(new Dimension(25, 50));

        passwordLabel.setFocusPainted(false);
        passwordLabel.setBackground(styleSettings.getTextColor_WHITE());
        passwordLabel.setBorder(BorderFactory.createEmptyBorder());
        passwordLabel.addActionListener(e -> {
            if(passwordLabel.getText().equals("***************")) {
                passwordLabel.setText(password);
            } else {
                passwordLabel.setText("***************");
            }
        });

        dropButton.setFocusable(true);
        dropButton.setEditable(false);
        dropButton.setBackground(styleSettings.getTextColor_WHITE());
        dropButton.setBorder(BorderFactory.createEmptyBorder());
        dropButton.addActionListener(e -> {
            if(Objects.equals(dropButton.getSelectedItem(), "Remove")) {
                passwordManager.removePasswordEntry(platform, username);
                homePage.remove(platform, username);
            } else if (Objects.equals(dropButton.getSelectedItem(), "Edit")) {
                String newPassword = JOptionPane.showInputDialog("Password(Leave blank if you want a generated password)");
                passwordManager.changePassword(platform, username, newPassword);
                homePage.refresh();
            } else if(Objects.equals(dropButton.getSelectedItem(), "Copy password")) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(password), null);
            } else if(Objects.equals(dropButton.getSelectedItem(), "Copy username")) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(username), null);
            }
        });
        dropButton.setVisible(true);

        centerPanel.add(platformLabel);
        centerPanel.add(usernameLabel);
        centerPanel.add(passwordLabel);
        centerPanel.add(dropButton);

        add(emptyLabel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(emptyLabel, BorderLayout.EAST);
        this.setVisible(true);
    }

    public String getPlatform() {
        return platformLabel.getText();
    }
    public String getUserName() {
        return usernameLabel.getText();
    }
}
