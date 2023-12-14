package View;

import Model.Password;
import Model.PasswordManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomePage extends JFrame {
    private final PasswordManager passwordManager;
    private final ScrollableGridLayout scrollableGridLayout;

    public HomePage() {
        passwordManager = PasswordManager.getInstance();
        CardLayout cardLayout = new CardLayout();
        scrollableGridLayout = new ScrollableGridLayout();

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 800));

        JPanel pages = new JPanel();
        pages.setLayout(cardLayout);
        pages.setBackground(Color.WHITE);
        pages.setSize(new Dimension(600, 675));
        pages.setBorder(BorderFactory.createEmptyBorder());

        JPanel emptyPanel = new JPanel();
        StyleSettings styleSettings = new StyleSettings();
        emptyPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        emptyPanel.setPreferredSize(new Dimension(200, 100));
        emptyPanel.setVisible(true);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(8, 1));
        sidePanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        sidePanel.setPreferredSize(new Dimension(200, 800));
        sidePanel.add(new ButtonPanel("ADD ENTRY", this));
        sidePanel.add(new ButtonPanel("EDIT ENTRY", this));
        sidePanel.add(new ButtonPanel("DELETE ENTRY", this));
        /*sidePanel.add(Box.createVerticalStrut(200));
        sidePanel.add(Box.createVerticalStrut(200));
        sidePanel.add(Box.createVerticalStrut(200));
        sidePanel.add(Box.createVerticalStrut(200));*/

        sidePanel.add(new ButtonPanel("QUIT", this));

        SearchPanel searchPanel = new SearchPanel(this);

        JPanel emptyWestPanel = new JPanel();
        emptyWestPanel.setPreferredSize(new Dimension(175, 75));
        emptyWestPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());

        JPanel emptyEastPanel = new JPanel();
        emptyEastPanel.setPreferredSize(new Dimension(350, 75));
        emptyEastPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        topPanel.setPreferredSize(new Dimension(800, 75));
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

        // This writes the list to the file when the window is closed.
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                passwordManager.writeListToFile();
                System.exit(0);
            }
        });
    }
    public void refresh() {
        scrollableGridLayout.refresh();
    }
    public void filter(String filter) {
        scrollableGridLayout.filter(filter);
    }
    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        /*homePage.passwordManager.addPasswordEntry(new Password("Google", "robin.blondin@email.com"));
        homePage.passwordManager.addPasswordEntry(new Password("Facebook", "Daniel"));
        homePage.passwordManager.addPasswordEntry(new Password("Instagram", "william"));
        homePage.passwordManager.addPasswordEntry(new Password("Twitter", "Nadia"));
        homePage.passwordManager.addPasswordEntry(new Password("Reddit", "robin blondin"));
        homePage.passwordManager.addPasswordEntry(new Password("LinkedIn", "Nisse", "12345678"));
        homePage.passwordManager.addPasswordEntry(new Password("Github", "klasse@telia.net"));
        homePage.passwordManager.addPasswordEntry(new Password("StackOverflow", "kalle anka"));
        homePage.passwordManager.addPasswordEntry(new Password("Youtube", "joakim@vonanka.com"));
        homePage.passwordManager.addPasswordEntry(new Password("Netflix", "Knatte"));
        homePage.passwordManager.addPasswordEntry(new Password("Spotify", "Fnatte"));
        homePage.passwordManager.addPasswordEntry(new Password("Twitch", "Tjatte"));*/


    }
}
