package com.mycompany.triviagame;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int correctIndex;
        boolean play = true;
        CSQuestions thisCSQuestion;
        PCQuestions thisPCQuestion;
        GQuestions thisGQuestion;
        System.out.println("Welcome to Trivia Game!");


        CSQuestions.loadCSQuestions();
        PCQuestions.loadCSQuestions();
        GQuestions.loadGQuestions();

        do {
            System.out.println("Categories");


            System.out.println("1. Computer Science");
            System.out.println("2. Pop Culture");
            System.out.println("3. Geography");

            System.out.println("Choose a category:\n");
            userGuess = input.nextInt();
            switch (userGuess) {
                case 1:
                    System.out.println("You chose Computer Science");
                    thisCSQuestion = CSQuestions.randomQuestion();
                    correctIndex = thisCSQuestion.getCorrectIndex();
                    System.out.print(thisCSQuestion);
                    break;

                case 2:
                    System.out.println("You chose Pop Culture");
                    /*
                    for (PCQuestions question : PCQuestions.pcQuestionsArray) {
                        System.out.println(question);
                    }*/
                    thisPCQuestion = PCQuestions.randomQuestion();
                    correctIndex = thisPCQuestion.getCorrectIndex();
                    System.out.print(thisPCQuestion);
                    break;
                case 3:
                    System.out.println("You chose Geography");
                    /*
                    for(GQuestions question : GQuestions.GQuestionsArray){
                        System.out.println(question);
                    }*/
                    thisGQuestion = GQuestions.randomQuestion();
                    correctIndex = thisGQuestion.getCorrectIndex();
                    System.out.print(thisGQuestion);
                    break;
                default:
                    System.out.println("Invalid Entry. Game will not restart.");
                    correctIndex = -1;
                    break;
            }


            System.out.println("Enter your choice: ");
            userGuess = input.nextInt();
            if (userGuess == correctIndex) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Wrong!");
                System.out.println("\nThe correct answer was " + correctIndex);
            }

            System.out.println("\nWould you like to do another question? [y/n] :");
            String userPlay  = input.next();



            if (Objects.equals(userPlay, "n") || Objects.equals(userPlay, "N")) {
                play = false;
            }
            else if ((!Objects.equals(userPlay, "y") && (!Objects.equals(userPlay, "Y")))) {
                play = false;
                System.out.println("Invalid Entry. Game will not restart.");
            }
            else play = true;
        } while (play);


    }
}
