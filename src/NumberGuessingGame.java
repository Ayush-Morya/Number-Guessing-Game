import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("\n-------------------------------------\nWelcome to the Number Guessing Game!\n-------------------------------------");
        int gamesPlayed = 0, gamesWon = 0, gamesLost = 0, totalGuesses = 0, bestGame = 0, easyGames = 0, mediumGames = 0, hardGames = 0;
        String playAgain;
        do {
            String difficultyLevel = inputDifficultyLevel(scanner);
            switch (difficultyLevel) {
                case "easy" -> easyGames++;
                case "medium" -> mediumGames++;
                case "hard" -> hardGames++;
            }
            int numberOfAttempts = noOfAttempts(difficultyLevel);
            System.out.println("\nYou have " + numberOfAttempts + " attempts to guess the number.");
            int maxNumber = maxNo(difficultyLevel);
            int secretNumber = generateSecretNumber(random, maxNumber);
            int[] guesses = new int[numberOfAttempts];
            String[] guessResults = new String[numberOfAttempts];
            boolean[] gameWon = new boolean[1];
            int guessCount = playGame(scanner, numberOfAttempts, maxNumber, secretNumber, guesses, guessResults, gameWon);
            if (gameWon[0]) {
                if (bestGame == 0 || bestGame > guessCount) {
                    bestGame = guessCount;
                }
                gamesWon++;
            }
            else {
                gamesLost++;
            }
            guessHistory(guessCount, guesses, guessResults);
            totalGuesses += guessCount;
            gamesPlayed++;
            playAgain = playAgainChoice(scanner);
        } while (playAgain.equals("yes"));
        double winRate = ((double) gamesWon / gamesPlayed) * 100;
        gameStatistics(gamesPlayed, gamesWon, gamesLost, winRate, totalGuesses, bestGame, easyGames, mediumGames, hardGames);
    }
    static String inputDifficultyLevel(Scanner scanner) {
        String difficultyLevel;
        do {
            System.out.print("\nChoose the difficulty level (Easy/Medium/Hard): ");
            difficultyLevel = scanner.next().toLowerCase();
            if (!difficultyLevel.equals("easy") && !difficultyLevel.equals("medium") && !difficultyLevel.equals("hard")) {
                System.out.println("Invalid difficulty level! Please enter Easy, Medium, or Hard.");
            }
        } while (!difficultyLevel.equals("easy") && !difficultyLevel.equals("medium") && !difficultyLevel.equals("hard"));
        return difficultyLevel;
    }
    static int noOfAttempts(String difficultyLevel) {
        return switch (difficultyLevel) {
            case "easy" -> 10;
            case "medium" -> 7;
            case "hard" -> 5;
            default -> -1;
        };
    }
    static int maxNo(String difficultyLevel) {
        return switch (difficultyLevel) {
            case "easy" -> 50;
            case "medium" -> 100;
            case "hard" -> 200;
            default -> -1;
        };
    }
    static int generateSecretNumber(Random random, int maxNumber) {
        return random.nextInt(maxNumber) + 1;
    }
    static int playGame(Scanner scanner, int numberOfAttempts, int maxNumber, int secretNumber, int[] guesses, String[] guessResults, boolean[] gameWon) {
        int guessCount = 0;
        boolean guessedCorrectly = false;
        while (numberOfAttempts > 0) {
            System.out.print("\nGuess a number (1-" + maxNumber + "): ");
            int guessedNumber = scanner.nextInt();
            if (guessedNumber < 1 || guessedNumber > maxNumber) {
                System.out.println("Invalid guess! Please enter a number from 1 to " + maxNumber + ".");
                continue;
            }
            guesses[guessCount] = guessedNumber;
            if (guessedNumber == secretNumber) {
                System.out.println("Correct! You guessed the number!");
                guessResults[guessCount] = "Correct";
                guessCount++;
                guessedCorrectly = true;
                break;
            }
            if (guessedNumber > secretNumber) {
                System.out.println("Too High! Try a lower number.");
                guessResults[guessCount] = "Too High";
            }
            else {
                System.out.println("Too Low! Try a higher number.");
                guessResults[guessCount] = "Too Low";
            }
            guessCount++;
            numberOfAttempts--;
            System.out.println("You have " + numberOfAttempts + " attempts left to guess the number.");
        }
        if (guessedCorrectly) {
            System.out.println("\nYou won!");
        }
        else {
            System.out.println("\nYou lost!");
            System.out.println("The correct number was " + secretNumber + ".");
        }
        gameWon[0] = guessedCorrectly;
        return guessCount;
    }
    static void guessHistory(int guessCount, int[] guesses, String[] guessResults) {
        System.out.println("\nGuess History:");
        for (int i = 0; i < guessCount; i++) {
            System.out.println(guesses[i] + " -> " + guessResults[i]);
        }
    }
    static String playAgainChoice(Scanner scanner) {
        String playAgain;
        do {
            System.out.print("\nWould you like to play again? (Yes/No): ");
            playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes") && !playAgain.equals("no")) {
                System.out.println("Invalid choice! Please enter Yes or No.");
            }
        } while (!playAgain.equals("yes") && !playAgain.equals("no"));
        return playAgain;
    }
    static void gameStatistics(int gamesPlayed, int gamesWon, int gamesLost, double winRate, int totalGuesses, int bestGame, int easyGames, int mediumGames, int hardGames) {
        System.out.println("\n---------------------------\n\tGAME STATISTICS\n---------------------------");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Games Won: " + gamesWon);
        System.out.println("Games Lost: " + gamesLost);
        System.out.printf("Win Rate: %.2f%%%n", winRate);
        System.out.println("Total Guesses: " + totalGuesses);
        if (bestGame > 0) {
            System.out.println("Best Game: " + bestGame + " guesses");
        }
        else {
            System.out.println("Best Game: No wins yet");
        }
        System.out.println("\nDIFFICULTY STATISTICS");
        System.out.println("Easy Games: " + easyGames);
        System.out.println("Medium Games: " + mediumGames);
        System.out.println("Hard Games: " + hardGames);
        System.out.println("---------------------------");
        System.out.println("\nThanks for playing!");
    }
}