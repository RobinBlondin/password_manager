package View;

import Controller.ActionListener;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    public SearchPanel(HomePage homePage) {
        StyleSettings styleSettings = StyleSettings.getInstance();

        this.setLayout(new BorderLayout());
        this.setBackground(styleSettings.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(300, 75));

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(50, 75));
        leftPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 0, 0));

        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon("images/searchIcon.png")
                .getImage()
                .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        imageLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        leftPanel.add(imageLabel);


        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 75));
        rightPanel.setBackground(styleSettings.getBackgroundColor_LIGHT());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

        JTextField searchField = new JTextField();
        searchField.addActionListener(new ActionListener(homePage));
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