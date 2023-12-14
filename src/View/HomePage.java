package View;

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
        scrollableGridLayout = new ScrollableGridLayout(this);

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(950, 800));
        this.setTitle("Password Manager");

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
        sidePanel.add(Box.createVerticalStrut(10));
        sidePanel.add(Box.createVerticalStrut(10));
        sidePanel.add(Box.createVerticalStrut(10));
        sidePanel.add(Box.createVerticalStrut(10));

        sidePanel.add(new ButtonPanel("QUIT", this));

        SearchPanel searchPanel = new SearchPanel(this);

        JPanel emptyWestPanel = new JPanel();
        emptyWestPanel.setPreferredSize(new Dimension(175, 75));
        emptyWestPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());

        JPanel emptyEastPanel = new JPanel();
        emptyEastPanel.setPreferredSize(new Dimension(350, 75));
        emptyEastPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());

        JPanel topPanel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon("images/logoIcon.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(icon);
        emptyWestPanel.add(logoLabel);
        topPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        topPanel.setPreferredSize(new Dimension(800, 75));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));

        topPanel.add(emptyWestPanel, BorderLayout.WEST);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        topPanel.add(emptyEastPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        JLabel creatorsLabel = new JLabel("Creators:      Nadia Nazari      William Wisten      Daniel Jägestedt      Robin Blondin");
        creatorsLabel.setForeground(styleSettings.getTextColor_LIGHT());
        creatorsLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        bottomPanel.setBackground(styleSettings.getBackgroundColor_DARK());
        bottomPanel.setPreferredSize(new Dimension(875, 50));
        bottomPanel.add(creatorsLabel);

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
    public void addToUI(Component component) {
        scrollableGridLayout.addToUI(component);
    }
    public void remove(String platform, String userName) {
        scrollableGridLayout.removeFromUI(platform, userName);
    }
    public static void main(String[] args) {
        new HomePage();
    }
}
