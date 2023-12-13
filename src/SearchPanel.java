import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private JTextField searchField;
    private StyleSettings styleSettings;

    public SearchPanel() {
        this.styleSettings = StyleSettings.getInstance();
        this.setLayout(new BorderLayout());
        this.setBackground(styleSettings.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(300, 75));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(50, 75));
        leftPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        leftPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ImageIcon searchIcon = new ImageIcon("images/searchIcon.png");
        Image image = searchIcon.getImage();
        Image newImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(newImage));
        imageLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        leftPanel.add(imageLabel);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 0));

        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 75));
        rightPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchField.setFont(styleSettings.getSmallFont());
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setBackground(styleSettings.getBackgroundColor_SELECTED());
        searchField.setForeground(styleSettings.getTextColor_DARK());
        searchField.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(searchField);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}