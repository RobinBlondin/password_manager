package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private static PasswordManager instance;
    private final List<Password> passwordEntries;

    private PasswordManager() {
        passwordEntries = new ArrayList<>();
        readFileToList();
    }

    public static PasswordManager getInstance() {
        if (instance == null) {
            instance = new PasswordManager();
        }
        return instance;

    }

    public void changePassword(String platform, String userName, String password) {
        for (Password passwordEntry : passwordEntries) {
            if (passwordEntry.getPlatform().equalsIgnoreCase(platform) && passwordEntry.getUserName().equals(userName)) {
                if (password.isEmpty()) {
                    passwordEntry.generatePassword(16);
                } else {
                    passwordEntry.setPassword(password);
                }
                System.out.println("Password has changed!");
            }
        }
    }

    public void addPasswordEntry(Password password) {
        passwordEntries.add(password);
        sortList();
    }

    public void removePasswordEntry(Password password) {
        passwordEntries.remove(password);
    }
    public void removePasswordEntry(String platform, String userName) {
        passwordEntries.removeIf(entry -> entry.getPlatform().equalsIgnoreCase(platform) && entry.getUserName().equalsIgnoreCase(userName));
    }

    public void readFileToList() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/passwordEntries.bin"))) {
            while(true) {
                try {
                    Password password = (Password) in.readObject();
                    passwordEntries.add(password);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Reading file error: File not found...");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found...");
        }
        sortList();
    }

    public void writeListToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/passwordEntries.bin"))) {
            for (Password entry : passwordEntries) {
                out.writeObject(entry);
            }
        } catch (IOException e) {
            System.out.println("Writing to file error: File not found...");
        }
    }

    public void sortList() {
        passwordEntries.sort((o1, o2) -> o1.getPlatform().compareToIgnoreCase(o2.getPlatform()));
    }

    public List<Password> getPasswordEntries() {
        return passwordEntries;
    }
}
