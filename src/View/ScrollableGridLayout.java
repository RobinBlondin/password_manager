package View;

import Model.Password;
import Model.PasswordManager;

import javax.swing.*;
import java.awt.*;

public class ScrollableGridLayout extends JPanel {
    private final PasswordManager passwordManager;
    private final JPanel gridPanel;
    public ScrollableGridLayout() {
        this.passwordManager = PasswordManager.getInstance();
        listSize = passwordManager.getPasswordEntries().size();
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        gridPanel = new JPanel(new GridLayout(listSize, 1));
        gridPanel.setBorder(BorderFactory.createEmptyBorder());
        gridPanel.setBackground(Color.WHITE);

        for (Password entry : passwordManager.getPasswordEntries()) {
            gridPanel.add(new ListPanel(entry.getPlatform(), entry.getUserName(), entry.getPassword()));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
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

    public void addToUI(Component component) {
        gridPanel.add(component);
        this.add(component);
        this.revalidate();
        this.repaint();
    }
    public void removeFromUI(String platform, String userName) {
        for (Component component : gridPanel.getComponents()) {
            if (component instanceof ListPanel listPanel) {
                if (listPanel.getPlatform().equalsIgnoreCase(platform) && listPanel.getUserName().equalsIgnoreCase(userName)) {
                    System.out.println("Removing: " + platform + " " + userName);
                    gridPanel.remove(component);
                    this.remove(component);
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }
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