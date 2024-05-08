package TWITTER;

import TWITTER.CuentaUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    private List<CuentaUsuario> users;
    private CuentaUsuario currentUser;

    public void loadUsersFromFile(String fileName) {
        users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name =parts[0];
                String email = parts[1];

                CuentaUsuario user = new CuentaUsuario(name, email);
                users.add(user);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero de usuarios.");
            e.printStackTrace();
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
        currentUser = user;
    }

    public CuentaUsuario getCurrentUser() {
        return currentUser;
    }

    public void sortUsersByEmail() {
        Collections.sort(users, Comparator.comparing(CuentaUsuario::getEmail));
    }
}

