package com.mycompany.triviagame;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userGuess = -1; // Stores user input for category or answer
        int correctIndex = 0; // Stores the index of the correct answer
        boolean play = true; // Controls if the game continues

        // Variables to hold question objects from each category
        CSQuestions thisCSQuestion;
        PCQuestions thisPCQuestion;
        GQuestions thisGQuestion;

        System.out.println("Welcome to Trivia Game!");

        // Load questions from respective files into memory for all categories
        CSQuestions.loadCSQuestions();
        PCQuestions.loadCSQuestions();
        GQuestions.loadGQuestions();

        do {
            // Display category options to the user
            System.out.println("Categories");
            System.out.println("1. Computer Science");
            System.out.println("2. Pop Culture");
            System.out.println("3. Geography");

            // Prompt user to select a category until a valid input is provided
            do {
                System.out.print("\nChoose a category: ");
                try {
                    userGuess = input.nextInt(); // Capture user's category selection
                    switch (userGuess) {
                        case 1:
                            System.out.println("You chose Computer Science");
                            // Fetch a random Computer Science question
                            thisCSQuestion = CSQuestions.randomQuestion();
                            correctIndex = thisCSQuestion.getCorrectIndex(); // Get correct answer
                            System.out.print(thisCSQuestion); // Display the question
                            break;
                        case 2:
                            System.out.println("You chose Pop Culture");
                            // Fetch a random Pop Culture question
                            thisPCQuestion = PCQuestions.randomQuestion();
                            correctIndex = thisPCQuestion.getCorrectIndex(); // Get correct answer
                            System.out.print(thisPCQuestion); // Display the question
                            break;
                        case 3:
                            System.out.println("You chose Geography");
                            // Fetch a random Geography question
                            thisGQuestion = GQuestions.randomQuestion();
                            correctIndex = thisGQuestion.getCorrectIndex(); // Get correct answer
                            System.out.print(thisGQuestion); // Display the question
                            break;
                        default:
                            // Invalid option for category
                            System.out.println("**Invalid Entry. Please select a valid category between 1 and 3.**");
                            correctIndex = -1; // Reset correctIndex
                            break;
                    }
                } catch (InputMismatchException e) {
                    // Error if user provides non-integer input for category selection
                    System.out.println("**Invalid input type. Please enter a number between 1 and 3.**");
                    input.nextLine(); // Clear the invalid input
                    userGuess = -1; // Reset userGuess to re-prompt
                }
            } while (userGuess < 1 || userGuess > 3); // Keep asking until a valid category (1-3) is selected

            // Prompt user to answer the selected question
            do {
                try {
                    System.out.print("\nEnter your choice (1-4): ");
                    userGuess = input.nextInt(); // Capture the user's answer

                    if (userGuess < 1 || userGuess > 4) {
                        // Notify user if the answer is not a valid option
                        System.out.println("**Invalid Entry. Please enter a number between 1 and 4.**");
                    }
                } catch (InputMismatchException e) {
                    // Handle input errors for non-integer answers
                    System.out.println("**Invalid input type. Please enter a valid number between 1 and 4.**");
                    input.nextLine(); // Clear the invalid input
                    userGuess = -1; // Reset userGuess to allow retry
                }
            } while (userGuess < 1 || userGuess > 4); // Keep asking until a valid answer (1-4) is provided

            // Check if the user's answer is correct
            if (userGuess == correctIndex) {
                System.out.println("Correct!"); // Notify of correct answer
                Question.answersCorrect += 1; // Increment correct answers count
            } else {
                System.out.println("Wrong!"); // Notify of incorrect answer
                System.out.println("\nThe correct answer was " + correctIndex); // Display correct answer
            }

            // Prompt user to decide if they want to continue playing
            boolean validInput = false; // Track if a valid input for replay is given
            do {
                try {
                    System.out.print("\nWould you like to do another question? [y/n]: ");
                    String userPlay = input.next().trim(); // Capture and trim user input

                    if (Objects.equals(userPlay, "n") || Objects.equals(userPlay, "N")) {
                        // User chooses to quit the game
                        play = false; // Stop the game
                        validInput = true; // Input is valid
                    } else if (Objects.equals(userPlay, "y") || Objects.equals(userPlay, "Y")) {
                        // User chooses to continue the game
                        play = true; // Continue the game
                        validInput = true; // Input is valid
                    } else {
                        // Notify if replay input is invalid
                        System.out.println("**Invalid Entry. Please enter 'y' to continue or 'n' to quit.**");
                    }
                } catch (Exception e) {
                    // Handle unexpected errors during replay prompt
                    System.out.println("**An unexpected error occurred. Please enter 'y' or 'n'.**");
                    input.nextLine(); // Clear the input buffer
                }
            } while (!validInput); // Keep asking until a valid replay input is obtained
        } while (play); // Continue playing while user wants to

        // Game over message and end-of-game summary
        System.out.println("\nGAME OVER!");
        System.out.println("Player Stats:");
        System.out.printf("You answered %d out of %d questions correctly.\n", Question.answersCorrect, Question.questionsAnswered);
        double percentage = (double) (100.00 * Question.answersCorrect / (double) Question.questionsAnswered);
        System.out.println("Your percentage right was: " + percentage + "%");
        System.out.println("Thank you for playing & have a great winter break! Goodbye!");
    }
}
