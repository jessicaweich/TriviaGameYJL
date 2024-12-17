package com.mycompany.triviagame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GQuestions extends Question {
        String question;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        int correctIndex;

        protected static String filePath = "com/mycompany/triviagame/GQuestions.txt";
        protected static ArrayList<com.mycompany.triviagame.GQuestions> GQuestionsArray = new ArrayList<GQuestions>();

        public static void loadGQuestions() {
            // Try-with-resources ensures the reader is closed automatically
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) { // Process each line of the file
                    try {
                        String[] GQuestionData = line.split(",");
                        if (GQuestionData.length != 6) {
                            throw new IllegalArgumentException("Invalid line format: " + line);
                        }

                        String thisQuestion = GQuestionData[0];
                        String thisAnswer1 = GQuestionData[1];
                        String thisAnswer2 = GQuestionData[2];
                        String thisAnswer3 = GQuestionData[3];
                        String thisAnswer4 = GQuestionData[4];
                        int correctIndex = Integer.parseInt(GQuestionData[5]);

                        // Add the question to the list
                        GQuestionsArray.add(new com.mycompany.triviagame.GQuestions(thisQuestion, thisAnswer1, thisAnswer2, thisAnswer3,
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

        public static com.mycompany.triviagame.GQuestions randomQuestion() {
            Random rand = new Random();
            int randomIndex = rand.nextInt(GQuestionsArray.size());
            return GQuestionsArray.get(randomIndex);
        }



        public GQuestions(String question, String answer1, String answer2, String answer3, String answer4,
                          int correctIndex) {
            super(question, answer1, answer2, answer3, answer4, correctIndex);
        }

        @Override
        public String toString() {
            return "\nGeography Questions:\n" + getQuestion() + "\n\n 1: "
                    + getAnswer1() + "\n 2: " + getAnswer2() + "\n 3: " + getAnswer3() + "\n 4: " + getAnswer4() + "\n";
        }

}
