
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
        return new PasswordManager();
    }

    public void addPasswordEntry(Password password) {
        passwordEntries.add(password);
    }

    public void removePasswordEntry(Password password) {
        passwordEntries.remove(password);
    }
    public void removePasswordEntry(String platform, String userName) {
        passwordEntries.removeIf(entry -> entry.getPlatform().equals(platform) && entry.getUserName().equals(userName));
    }

    public void readFileToList() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/passwordEntries.ser"))) {
            Object obj;
            while((obj = in.readObject()) != null) {
                passwordEntries.add((Password) obj);
            }
        } catch (IOException e) {
            System.out.println("File not found...");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found...");
        }
    }

    public void writeListToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/passwordEntries.ser"))) {
            for (Password entry : passwordEntries) {
                out.writeObject(entry);
            }
        } catch (IOException e) {
            System.out.println("File not found...");
        }
    }

    public List<Password> getPasswordEntries() {
        return passwordEntries;
    }
}
