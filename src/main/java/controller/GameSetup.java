package controller;

import java.util.Scanner;

public class GameSetup {

    Scanner keyboard = new Scanner(System.in);

    public void welcomeToGame(){
        System.out.println("Welcome to Mastermind. In this game the goal is to figure out the secret code. ");
        System.out.println("You have the choices of red, orange, blue, white, purple, and yellow pegs.");
        System.out.println("Following each guess the computer will print out Rs or Ws to indicate the accuracy of your guess.");
        System.out.println("R shows that a peg is the correct color and correct location while W shows a peg is the correct color but not the correct location.");
        System.out.println("You have 12 chances to break the code and win the game. Enjoy the challenge!");
    }

    public Integer gameOption() {
        int input2=0;
        System.out.println("If you would you like to play against the computer press 1. If you would like to play against a friend press 2. Then press Enter");
        String input = keyboard.next();

        try{
             input2 = Integer.parseInt(input);

             if (input2>2){
                 System.out.println("That is not a valid input. Please input a 1 or 2");
                 gameOption();
             }
        }catch (Exception e){
            System.out.println("That is not a valid input. Please input a 1 or 2.");
            gameOption();
        }
        return input2;
    }


}
