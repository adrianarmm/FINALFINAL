package TWITTER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    private List<CuentaUsuario> users = new ArrayList<>();
    private CuentaUsuario currentUser;

    public UserManager() {
        // Constructor que inicializa la lista vacía.
    }

    public void addUser(String alias, String email) {
        if (Utils.isValidAlias(alias) && Utils.isValidEmail(email)) {
            CuentaUsuario newUser = new CuentaUsuario(alias, email);
            users.add(newUser);
        } else {
            throw new IllegalArgumentException("Alias o email no válido.");
        }
    }

    public CuentaUsuario findUserByEmail(String email) {
        for (CuentaUsuario user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void setCurrentUser(CuentaUsuario user) {
        this.currentUser = user;
    }

    public CuentaUsuario getCurrentUser() {
        return currentUser;
    }

    public void sortUsersByEmail() {
        Collections.sort(users, Comparator.comparing(cuentaUsuario -> cuentaUsuario.getEmail()));
    }
}
