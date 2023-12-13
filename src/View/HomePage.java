package View;

import Model.Password;
import Model.PasswordManager;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    private final JPanel pages;
    private final JPanel sidePanel;
    private final StyleSettings styleSettings = new StyleSettings();
    private PasswordManager passwordManager;
    private SearchPanel searchPanel;
    private ScrollableGridLayout scrollableGridLayout;
    private CardLayout cardLayout;


    public HomePage() {
        passwordManager = PasswordManager.getInstance();
        cardLayout = new CardLayout();
        scrollableGridLayout = new ScrollableGridLayout();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 800));

        pages = new JPanel();
        pages.setLayout(cardLayout);
        pages.setBackground(Color.WHITE);
        pages.setSize(new Dimension(600, 675));
        pages.setBorder(BorderFactory.createEmptyBorder());

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        emptyPanel.setPreferredSize(new Dimension(200, 50));
        emptyPanel.setVisible(true);
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(8, 1));
        sidePanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        sidePanel.setPreferredSize(new Dimension(200, 800));
        sidePanel.add(new ButtonPanel("ADD"));
        sidePanel.add(new ButtonPanel("EDIT"));
        sidePanel.add(new ButtonPanel("REMOVE"));
        sidePanel.add(emptyPanel);
        sidePanel.add(emptyPanel);
        sidePanel.add(emptyPanel);
        sidePanel.add(emptyPanel);
        sidePanel.add(emptyPanel);
        sidePanel.add(new ButtonPanel("LOGOUT"));
        sidePanel.add(new ButtonPanel("EXIT"));


        searchPanel = new SearchPanel();
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel emptyWestPanel = new JPanel();
        emptyWestPanel.setPreferredSize(new Dimension(175, 75));
        emptyWestPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        JPanel emptyEastPanel = new JPanel();
        emptyEastPanel.setPreferredSize(new Dimension(350, 75));
        emptyEastPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        topPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        topPanel.setPreferredSize(new Dimension(800, 75));;
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        topPanel.add(emptyWestPanel, BorderLayout.WEST);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        topPanel.add(emptyEastPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(styleSettings.getBackgroundColor_DARK());
        bottomPanel.setPreferredSize(new Dimension(800, 50));


        this.add(sidePanel, BorderLayout.WEST);
        this.add(scrollableGridLayout, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private class ButtonPanel extends JPanel {
        private final JButton button;

        public ButtonPanel(String text) {
            this.setLayout(new BorderLayout());

            button = new JButton();
            button.setText(text);
            button.setFont(styleSettings.getSmallFont());
            button.setBackground(styleSettings.getBackgroundColor_LIGHT());
            button.setForeground(styleSettings.getTextColor_DARK());
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.addActionListener(new ActionListener(HomePage.this));
            button.setFocusPainted(false);
            button.setVisible(true);

            this.add(button, BorderLayout.CENTER);
            this.setVisible(true);
        }
    }

    public PasswordManager getPasswordManager() {
        return passwordManager;
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.passwordManager.addPasswordEntry(new Password("Google", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Facebook", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Instagram", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Twitter", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Reddit", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("LinkedIn", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Github", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("StackOverflow", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Youtube", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Netflix", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Spotify", "johndoe", "password"));
        homePage.passwordManager.addPasswordEntry(new Password("Twitch", "johndoe", "password"));

    }
}
