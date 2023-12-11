
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private static PasswordManager instance;
    private final List<Password> passwordEntries;
    private ObjectOutputStream out;
    private ObjectInputStream in;

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

    public void readFileToList() {
        //TODO: Read the file and add the entries to the list
    }

    public void writeListToFile() {
        //TODO: Write the list to the file
    }

    public List<Password> getPasswordEntries() {
        return passwordEntries;
    }
}
