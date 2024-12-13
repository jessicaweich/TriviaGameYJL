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
        do {
            System.out.println("Categories");

            System.out.println("Choose a category:");

            System.out.println("Would you like to continue? [y/n] :");
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

        /*
        Question question1 = new Question("What is a correct syntax to output \"Hello World\" in Java?"
                                        ,"Console.Writeline(\"Hello World\");"
                                        ,"print(\"Hello World\");"
                                        ,"echo(\"Hello World\");"
                                        ,"System.out.print(\"Hello World\");"
                                        , 4);

        System.out.println("Question: " + question1.getQuestion() + "?");

        System.out.println("1 : " + question1.getAnswer1() + "?");
        System.out.println("2 : " + question1.getAnswer2() + "?");
        System.out.println("3 : " + question1.getAnswer3() + "?");
        System.out.println("4 : " + question1.getAnswer4() + "?");
        System.out.println("Enter your choice: ");
        String[] answers = question1.getAnswerArray();
        int i = 0;
        for (String answer : answers) {
            ++i;
            System.out.println(i + " : " + answer);
        }
        userGuess = input.nextInt();
        if (userGuess == question1.getCorrectIndex()) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Wrong!");
        }

         */

    }
}
