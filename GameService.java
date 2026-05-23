package service;

import dao.ScoreDAO;
import dao.WordDAO;
import model.Score;
import model.User;
import model.Word;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameService {

    private final WordDAO wordDAO = new WordDAO();
    private final ScoreDAO scoreDAO = new ScoreDAO();

    // START GAME
    public void startGame(User user) {

        Scanner sc = new Scanner(System.in);

        Word randomWord = wordDAO.getRandomWord();

        if (randomWord == null) {
            System.out.println("No words found!");
            return;
        }

        String actualWord = randomWord.getWord().toLowerCase();

        Set<Character> guessedLetters = new HashSet<>();

        int lives = 6;
        int score = 0;

        System.out.println("\n===== WORD GUESS GAME =====");

        System.out.println(
                "Category: " + randomWord.getCategory());

        System.out.println(
                "Difficulty: " + randomWord.getDifficulty());

        while (lives > 0) {

            // DISPLAY WORD
            StringBuilder hiddenWord = new StringBuilder();

            boolean isWordComplete = true;

            for (char ch : actualWord.toCharArray()) {

                if (guessedLetters.contains(ch)) {
                    hiddenWord.append(ch).append(" ");
                } else {
                    hiddenWord.append("_ ");
                    isWordComplete = false;
                }
            }

            System.out.println("\nWord: " + hiddenWord);

            // CHECK WIN
            if (isWordComplete) {

                score = lives * 10;

                System.out.println(
                        "\n🎉 Congratulations! You Won!");

                System.out.println(
                        "Your Score: " + score);

                // SAVE SCORE
                scoreDAO.saveScore(
                        new Score(user.getId(), score));

                return;
            }

            System.out.println("Lives Left: " + lives);

            System.out.print(
                    "Guess a Letter: ");

            String input = sc.nextLine().toLowerCase();

            // VALIDATION
            if (input.length() != 1) {

                System.out.println(
                        "Enter only ONE letter!");

                continue;
            }

            char guess = input.charAt(0);

            // ALREADY GUESSED
            if (guessedLetters.contains(guess)) {

                System.out.println(
                        "You already guessed this letter!");

                continue;
            }

            guessedLetters.add(guess);

            // CORRECT / WRONG
            if (actualWord.indexOf(guess) >= 0) {

                System.out.println(
                        "✅ Correct Guess!");

            } else {

                lives--;

                System.out.println(
                        "❌ Wrong Guess!");
            }
        }

        // GAME OVER
        System.out.println(
                "\n💀 Game Over!");

        System.out.println(
                "Correct Word Was: " + actualWord);
    }
}