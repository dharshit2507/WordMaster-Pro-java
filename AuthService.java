package service;

import dao.UserDAO;
import model.User;

import java.util.Scanner;

public class AuthService {

    private final UserDAO userDAO = new UserDAO();

    // REGISTER
    public void register() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== REGISTER =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(username, password);

        boolean success = userDAO.registerUser(user);

        if (success) {
            System.out.println("Registration Successful!");
        } else {
            System.out.println("Registration Failed!");
        }
    }

    // LOGIN
    public User login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = userDAO.loginUser(username, password);

        if (user != null) {

            System.out.println(
                    "Welcome, " + user.getUsername());

            return user;
        }

        System.out.println("Invalid Credentials!");

        return null;
    }
}