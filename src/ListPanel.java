import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListPanel extends JPanel {
    JLabel platformLabel;
    JLabel usernameLabel;
    JButton passwordLabel;
    JLabel emptyLabel;
    JPanel centerPanel;
    JComboBox dropButton;
    //JButton copyButton;
    StyleSettings styleSettings = StyleSettings.getInstance();
    String password;
    public ListPanel(String platform, String username, String password) {
        this.password = password;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(700, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));


        String [] options = {"Copy", "Remove", "Edit"};
        platformLabel = new JLabel(platform);
        usernameLabel = new JLabel(username);
        passwordLabel = new JButton("***************");
        dropButton = new JComboBox(options);
        //copyButton = new JButton("Copy");
        centerPanel = new JPanel();
        emptyLabel = new JLabel();

        centerPanel.setBackground(Color.WHITE);

        platformLabel.setFont(styleSettings.getSmallFont());
        usernameLabel.setFont(styleSettings.getSmallFont());
        passwordLabel.setFont(styleSettings.getSmallFont());
        //copyButton.setFont(styleSettings.getSmallFont());
        dropButton.setFont(styleSettings.getSmallFont());

        platformLabel.setPreferredSize(new Dimension(150, 50));
        usernameLabel.setPreferredSize(new Dimension(150, 50));
        passwordLabel.setPreferredSize(new Dimension(200, 50));
        dropButton.setPreferredSize(new Dimension(75, 40));
        //copyButton.setPreferredSize(new Dimension(50, 50));
        emptyLabel.setPreferredSize(new Dimension(25, 50));

        passwordLabel.setFocusPainted(false);
        passwordLabel.setBackground(styleSettings.getTextColor_WHITE());
        passwordLabel.setBorder(BorderFactory.createEmptyBorder());
        dropButton.setSelectedIndex(0);
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
            if(dropButton.getSelectedItem().equals("Remove")) {
                // TODO: Remove the entry
            } else if(dropButton.getSelectedItem().equals("Edit")) {
                // TODO: Create the edit page
            } else if(dropButton.getSelectedItem().equals("Copy")) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(password), null);
            }
        });

        /*
        copyButton.setFocusPainted(false);
        copyButton.setBackground(styleSettings.getTextColor_WHITE());
        copyButton.setBorder(BorderFactory.createEmptyBorder());
        copyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(password), null);
            }
        });
        */

        centerPanel.add(platformLabel);
        centerPanel.add(usernameLabel);
        centerPanel.add(passwordLabel);
        centerPanel.add(dropButton);

        add(emptyLabel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(emptyLabel, BorderLayout.EAST);
        this.setVisible(true);
    }
}
