import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {
    private static UserManager instance = null;
    private final List<User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(String name) {
        int id = users.size() + 1;
        User user = new User(id, name);
        users.add(user);
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Quantos usuários deseja cadastrar?");
        String quantityStr = br.readLine();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida. Encerrando o programa.");
            return;
        }

        UserManager userManager = UserManager.getInstance();

        System.out.println("Informe os nomes dos usuários, um por linha:");
        for (int i = 1; i <= quantity; i++) {
            String name = br.readLine();
            userManager.addUser(name);
        }

        System.out.println("Usuários cadastrados:");
        userManager.listUsers();
    }
}
