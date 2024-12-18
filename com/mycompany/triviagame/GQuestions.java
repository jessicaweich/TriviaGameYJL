package com.mycompany.triviagame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GQuestions extends Question {
    // Fields for storing question and answers
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int correctIndex;

    // File path for the text file containing questions
    protected static String filePath = "com/mycompany/triviagame/GQuestions.txt";
    // List to store all Geography questions
    protected static ArrayList<com.mycompany.triviagame.GQuestions> gQuestionsArray = new ArrayList<GQuestions>();

    // Loads questions from the file into the list
    public static void loadGQuestions() {
        // Try-with-resources to automatically close the reader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                try {
                    // Split each line into components
                    String[] GQuestionData = line.split(",");
                    if (GQuestionData.length != 6) { // Ensure the line has correct data format
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }

                    // Extract the question and answers from the line
                    String thisQuestion = GQuestionData[0];
                    String thisAnswer1 = GQuestionData[1];
                    String thisAnswer2 = GQuestionData[2];
                    String thisAnswer3 = GQuestionData[3];
                    String thisAnswer4 = GQuestionData[4];
                    int correctIndex = Integer.parseInt(GQuestionData[5]); // Get the correct answer index

                    // Add the question to the list
                    gQuestionsArray.add(new com.mycompany.triviagame.GQuestions(thisQuestion, thisAnswer1, thisAnswer2, thisAnswer3,
                            thisAnswer4, correctIndex));
                } catch (NumberFormatException e) {
                    // Handle cases where the correct index can't be parsed as an integer
                    System.err.println("Error parsing correct index for line: " + line);
                } catch (IllegalArgumentException e) {
                    // Handle invalid line formats
                    System.err.println("Skipping invalid line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Handle errors while reading the file
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Returns a random question from the list
    public static com.mycompany.triviagame.GQuestions randomQuestion() {
        Random rand = new Random(); // Create a random number generator
        int randomIndex = rand.nextInt(gQuestionsArray.size()); // Get a random index
        Question.questionsAnswered += 1; // Increment the number of questions answered
        return gQuestionsArray.get(randomIndex); // Return the random question
    }

    // Constructor for the Geography question object
    public GQuestions(String question, String answer1, String answer2, String answer3, String answer4,
                      int correctIndex) {
        // Call the parent class (Question) constructor
        super(question, answer1, answer2, answer3, answer4, correctIndex);
    }

    // Returns the question and options as a formatted string
    @Override
    public String toString() {
        return "\nGeography Questions:\n" + getQuestion() + "\n\n 1: "
                + getAnswer1() + "\n 2: " + getAnswer2() + "\n 3: " + getAnswer3() + "\n 4: " + getAnswer4() + "\n";
    }

}