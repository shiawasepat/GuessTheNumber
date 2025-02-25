import java.util.Scanner;

// Class
public class GuessTheNumber {
    public static void main(String[] args) {
        // Variable
        int numberToGuess; // Numbers
        int userGuess; // User input
        int attempts = 0; // Attempts
        int score = 0;
        
        // Clear screen
        // https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        // Welcome message
        System.out.println("\u001b[37m Welcome to Guess The Number!");
        // Set up the scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        
        // Choose a difficulty
        System.out.println("\nPlease choose a difficulty:");
        System.out.println("\u001b[32m 1. Easy");
        System.out.println("\u001b[33m 2. Medium");
        System.out.println("\u001b[31m 3. Hard");
        System.out.print("\u001b[37m Enter your choice: ");
        
        int difficulty = scanner.nextInt(); // User chooses difficulty
        
        // Set the max range based on the difficulty
        int maxRange = switch(difficulty) {
            case 1 -> 50; // Easy
            case 2 -> 100; // Medium
            case 3 -> 200; // Hard
            default -> { // Invalid choice, automatically set to medium
                System.out.println("Invalid choice. Setting difficulty to Medium.");
                yield 100;
            }
        };

            // Clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            // Generate a random number
            numberToGuess = (int) (Math.random() * maxRange) + 1;
            System.out.println("Guess a number between 1 and " + maxRange + ".");

    do {
        System.out.print("\nWhat number am I thinking of? : ");
        userGuess = scanner.nextInt();
        attempts++;

        // Check if user guess is too high or too low
        if (userGuess < numberToGuess) {
            System.out.println("\nToo low, try again");
        } else if (userGuess > numberToGuess) {
            System.out.println("\nToo high, try again");
        } else {
            // Clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("\u001b[37m\nYou got it! It took you " + attempts + " attempt(s).\n"); // Print number of attempts
        }
    } while (userGuess != numberToGuess); // Loop until user guess is correct

    attempts = 0;

    // Track user's score and print message
    if (attempts <= 5) {
        score += 10;
        System.out.println("\u001b[32mYou're a pro!\u001b[0m");
    } else if (attempts <= 10) {
        score += 5;
        System.out.println("\u001b[33mPretty good.\u001b[0m");
    } else {
        score += 1;
        System.out.println("\u001b[31mBetter luck next time.\u001b[0m");
    }

    System.out.println("Your current score is: " + score);

    // If user wants to play again
    System.out.print("\nDo you want to play again? (yes / no): ");
    String playAgain = scanner.next(); // User input
    if (playAgain.equalsIgnoreCase("yes")) {
        main(args); // Run main method again
    } else if (playAgain.equalsIgnoreCase("no")) {
        System.out.println("\u001b[32mThank you for playing! \u001b[0m");
    } else {
        System.out.println("\u001b[31mInvalid input. Automatically kicking you from the game. Thank you for playing! \u001b[0m");
    }
    
    // Close scanner
    scanner.close();


}}

