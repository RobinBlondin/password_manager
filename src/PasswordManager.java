
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
        sortList();
    }

    public void removePasswordEntry(Password password) {
        passwordEntries.remove(password);
    }
    public void removePasswordEntry(String platform, String userName) {
        passwordEntries.removeIf(entry -> entry.getPlatform().equals(platform) && entry.getUserName().equals(userName));
    }

    public void readFileToList() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/passwordEntries.bin"))) {
            Object obj;
            while((obj = in.readObject()) != null) {
                passwordEntries.add((Password) obj);
            }
        } catch (EOFException e) {
            System.out.println("End of file...");
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
