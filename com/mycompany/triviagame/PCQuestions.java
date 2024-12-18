package com.mycompany.triviagame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PCQuestions extends Question {
    // Fields to hold question details
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int correctIndex;

    // Path to the file containing the Pop Culture questions
    protected static String filePath = "com/mycompany/triviagame/PCQuestions.txt";
    // List to store all the Pop Culture questions
    protected static ArrayList<PCQuestions> pcQuestionsArray = new ArrayList<PCQuestions>();

    // Method to load questions from the file
    public static void loadPCQuestions() {
        // Try-with-resources to handle file reading and close reader automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                try {
                    // Split the line into question components
                    String[] PCQuestionData = line.split(",");
                    // Check if the line has all required parts (question + four options + correct index)
                    if (PCQuestionData.length != 6) {
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }

                    // Extract the question and possible answers from the line
                    String thisQuestion = PCQuestionData[0];
                    String thisAnswer1 = PCQuestionData[1];
                    String thisAnswer2 = PCQuestionData[2];
                    String thisAnswer3 = PCQuestionData[3];
                    String thisAnswer4 = PCQuestionData[4];
                    int correctIndex = Integer.parseInt(PCQuestionData[5]); // Parse correct answer index

                    // Add the question to the Pop Culture questions list
                    pcQuestionsArray.add(new PCQuestions(thisQuestion, thisAnswer1, thisAnswer2, thisAnswer3,
                            thisAnswer4, correctIndex));
                } catch (NumberFormatException e) {
                    // Handle cases where the correct index is not a valid number
                    System.err.println("Error parsing correct index for line: " + line);
                } catch (IllegalArgumentException e) {
                    // Handle invalid question format and skip the line
                    System.err.println("Skipping invalid line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Handle errors that occur while reading the file
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to get a random question from the list
    public static PCQuestions randomQuestion() {
        Random rand = new Random(); // Create a Random object
        int randomIndex = rand.nextInt(pcQuestionsArray.size()); // Generate a random index
        Question.questionsAnswered += 1; // Increment the number of questions answered
        return pcQuestionsArray.get(randomIndex); // Return the randomly selected question
    }

    // Constructor to initialize a Pop Culture question object
    public PCQuestions(String question, String answer1, String answer2, String answer3, String answer4,
                       int correctIndex) {
        // Call the superclass (Question) constructor to set the values
        super(question, answer1, answer2, answer3, answer4, correctIndex);
    }

    // Override the toString method to return the question as a formatted string
    @Override
    public String toString() {
        return "\nPop Culture Question:\n" + getQuestion() + "\n\n 1: "
                + getAnswer1() + "\n 2: " + getAnswer2() + "\n 3: " + getAnswer3() + "\n 4: " + getAnswer4() + "\n";
    }
}