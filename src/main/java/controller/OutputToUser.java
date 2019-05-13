package controller;

public class OutputToUser {


    public void welcomeMessage(){
        System.out.println("Welcome to Mastermind. In this game the goal is to figure out the secret code. ");
        System.out.println("You have the choices of red, orange, blue, white, purple, and yellow pegs.");
        System.out.println("Following each guess the computer will print out Rs or Ws to indicate the accuracy of your guess.");
        System.out.println("R shows that a peg is the correct color and correct location while W shows a peg is the correct color but not the correct location.");
        System.out.println("You have 12 chances to break the code and win the game. Enjoy the challenge!");
    }

    public void askNumberPlayers(){
        System.out.println("If you would you like to play against the computer press 1. If you would like to play against a friend press 2. Then press Enter");
    }

    public void numberPlayersErrorMessage(){
        System.out.println("That is not a valid input. Please input a 1 or 2.");
    }


    public void askAboutDuplicates(){
        System.out.println("Would you like to play with duplicates? Y/N");
    }

    public void createSecretCodeInstructions(){
        System.out.println("Please input four color codes to form your code. If more are inputted, only the 1st four will be saved.");
        System.out.println("Your choices are: R (red), O (orange), B (blue), W (white), P (purple), and Y (yellow)");
    }

    public void duplicatesErrorMessage(){
        System.out.println("You cannot have duplicates.");
    }

    public void guessSecretCodeInstructions(){
        System.out.println("Try to guess the secret code. Choose 4 of the following choices: R, O, B, W, P, or Y. Good Luck!");
    }

    public void invalidGuessError() {
        System.out.println("That was an invalid guess. Please try again.");
    }

    public void roundsToPlayMessage(){
        System.out.println("How many rounds would you like to play?");
        System.out.println("ex: 1 round means each player gets a turn to be the code creator and code guesser");
    }

    public void youWonMessage(){
        System.out.println("Congratulations! You won the game! You are a master mind :) ");
    }

    public void youLostMessage() {
        System.out.println("I'm sorry. You lost. Better luck next time. :( ");
    }

    public void invalidInputMessage() {
        System.out.println("That is an invalid input. Please enter an integer number.");
    }
}
