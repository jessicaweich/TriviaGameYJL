package com.mycompany.triviagame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CSQuestions extends Question{
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int correctIndex;

    //source for questions - https://www.w3schools.com
    protected static String filePath =
            "com/mycompany/triviagame/CSquestions.txt";
    protected static ArrayList<CSQuestions> csQuestionsArray = new ArrayList<CSQuestions>();

    public static void loadCSQuestions() {
        // Try-with-resources ensures the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Process each line of the file
                try {
                    String[] CSQuestionData = line.split(",");
                    if (CSQuestionData.length != 6) {
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }

                    String thisQuestion = CSQuestionData[0];
                    String thisAnswer1 = CSQuestionData[1];
                    String thisAnswer2 = CSQuestionData[2];
                    String thisAnswer3 = CSQuestionData[3];
                    String thisAnswer4 = CSQuestionData[4];
                    int correctIndex = Integer.parseInt(CSQuestionData[5]);

                    // Add the question to the list
                    csQuestionsArray.add(new CSQuestions(thisQuestion, thisAnswer1, thisAnswer2, thisAnswer3,
                            thisAnswer4, correctIndex));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing correct index for line: " + line);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static CSQuestions randomQuestion() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(csQuestionsArray.size());
        Question.questionsAnswered +=1;
        return csQuestionsArray.get(randomIndex);
    }



    public CSQuestions(String question, String answer1, String answer2, String answer3, String answer4, int correctIndex) {
        super(question, answer1, answer2, answer3, answer4, correctIndex);
    }

    @Override
    public String toString() {
        return "\nComputer Science Question:\n" + getQuestion() + "\n\n 1: "
                + getAnswer1() + "\n 2: " + getAnswer2() + "\n 3: " + getAnswer3() + "\n 4: " + getAnswer4() + "\n";
    }
}
