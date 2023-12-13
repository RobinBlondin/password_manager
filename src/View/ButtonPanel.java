package View;

import Controller.ActionListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel(String text, HomePage homePage) {
        this.setLayout(new BorderLayout());

        JButton button = new JButton();
        button.setText(text);
        StyleSettings styleSettings = StyleSettings.getInstance();
        button.setFont(styleSettings.getSmallFont());
        button.setBackground(styleSettings.getBackgroundColor_LIGHT());
        button.setForeground(styleSettings.getTextColor_DARK());
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addActionListener(new ActionListener(homePage));
        button.setFocusPainted(false);
        button.setVisible(true);

        this.add(button, BorderLayout.CENTER);
        this.setVisible(true);
    }
}