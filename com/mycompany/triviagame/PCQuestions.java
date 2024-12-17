package com.mycompany.triviagame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PCQuestions extends Question{
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int correctIndex;

    protected static String filePath =
            "com/mycompany/triviagame/PCQuestions.txt";
    protected static ArrayList<PCQuestions> pcQuestionsArray = new ArrayList<PCQuestions>();

    public static void loadCSQuestions() {
        // Try-with-resources ensures the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Process each line of the file
                try {
                    String[] PCQuestionData = line.split(",");
                    if (PCQuestionData.length != 6) {
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }

                    String thisQuestion = PCQuestionData[0];
                    String thisAnswer1 = PCQuestionData[1];
                    String thisAnswer2 = PCQuestionData[2];
                    String thisAnswer3 = PCQuestionData[3];
                    String thisAnswer4 = PCQuestionData[4];
                    int correctIndex = Integer.parseInt(PCQuestionData[5]);

                    // Add the question to the list
                    pcQuestionsArray.add(new PCQuestions(thisQuestion, thisAnswer1, thisAnswer2, thisAnswer3,
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

    public static PCQuestions randomQuestion() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(pcQuestionsArray.size());
        return pcQuestionsArray.get(randomIndex);
    }



    public PCQuestions(String question, String answer1, String answer2, String answer3, String answer4,
                       int correctIndex) {
        super(question, answer1, answer2, answer3, answer4, correctIndex);
    }

    @Override
    public String toString() {
        return "\nPop Culture Question:\n" + getQuestion() + "\n\n 1: "
                + getAnswer1() + "\n 2: " + getAnswer2() + "\n 3: " + getAnswer3() + "\n 4: " + getAnswer4() + "\n";
    }
}

