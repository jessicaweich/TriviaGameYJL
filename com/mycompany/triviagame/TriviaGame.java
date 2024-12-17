package com.mycompany.triviagame;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int userGuess;
        System.out.println("Welcome to Trivia Game!");

        Scanner scr = new Scanner(System.in);
        boolean play = true;

        CSQuestions.loadCSQuestions();
        for(CSQuestions question : CSQuestions.csQuestionsArray) {
            System.out.print(question);
        }
        /*
        do {
            System.out.println("Categories");

            System.out.println("Choose a category:");
            CSQuestions question1 = new CSQuestions("What is a correct syntax to output \"Hello World\" in Java?"
                    ,"Console.Writeline(\"Hello World\");"
                    ,"print(\"Hello World\");"
                    ,"echo(\"Hello World\");"
                    ,"System.out.print(\"Hello World\");"
                    , 4);

            System.out.println(question1);
            System.out.println("Enter your choice: ");
            userGuess = input.nextInt();
            if (userGuess == question1.getCorrectIndex()) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Wrong!");
            }


            System.out.println("Would you like to do another question? [y/n] :");
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

         */


    }
}
