package View;

import Model.Password;
import Model.PasswordManager;

import javax.swing.*;
import java.awt.*;

public class ScrollableGridLayout extends JPanel {
    private final PasswordManager passwordManager;
    JPanel gridPanel;
    public ScrollableGridLayout() {
        this.passwordManager = PasswordManager.getInstance();
        gridPanel = new JPanel(new GridLayout(100, 1));
        gridPanel.setBorder(BorderFactory.createEmptyBorder());

        for (Password entry : passwordManager.getPasswordEntries()) {
            gridPanel.add(new ListPanel(entry.getPlatform(), entry.getUserName(), entry.getPassword()));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
        setVisible(true);
    }

    public void refresh() {
        gridPanel.removeAll();
        for (Password entry : passwordManager.getPasswordEntries()) {
            gridPanel.add(new ListPanel(entry.getPlatform(), entry.getUserName(), entry.getPassword()));
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void filter(String filter) {
        gridPanel.removeAll();
        filter = filter.toLowerCase();
        for (Password entry : passwordManager.getPasswordEntries()) {
            if(entry.getPlatform().toLowerCase().contains(filter) || entry.getUserName().toLowerCase().contains(filter)) {
                gridPanel.add(new ListPanel(entry.getPlatform(), entry.getUserName(), entry.getPassword()));
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }


}