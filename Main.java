package main;

import dao.ScoreDAO;
import model.User;
import service.AuthService;
import service.GameService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();

        GameService gameService = new GameService();

        ScoreDAO scoreDAO = new ScoreDAO();

        while (true) {

            System.out.println("\n========================");
            System.out.println("🎮 WORDMASTER PRO");
            System.out.println("========================");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Leaderboard");
            System.out.println("4. Exit");

            System.out.print("Choose Option: ");

            int choice;

            try {

                choice = Integer.parseInt(
                        sc.nextLine());

            } catch (Exception e) {

                System.out.println(
                        "Invalid Input!");

                continue;
            }

            switch (choice) {

                case 1:

                    authService.register();
                    break;

                case 2:

                    User loggedInUser = authService.login();

                    if (loggedInUser != null) {

                        gameService.startGame(
                                loggedInUser);
                    }

                    break;

                case 3:

                    scoreDAO.showLeaderboard();
                    break;

                case 4:

                    System.out.println(
                            "Thank You For Playing!");

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice!");
            }
        }
    }
}