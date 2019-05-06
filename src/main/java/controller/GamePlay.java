package controller;

import model.Board;
import service.Service;
import view.View;

import java.util.Scanner;

public class GamePlay {
    private Scanner keyboard = new Scanner(System.in);
    private Board board = new Board();
private Integer i;
    private String secretCode="";
    private Integer numberGuessed=0;
    private boolean wonGame = false;
    Service service = new Service();
    View view = new View();


    public void playSinglePlayer() {
        automaticSecretCode();
    }


    public void playTwoPlayer() {
        createSecretCode();
    }


    private void createSecretCode() {
        System.out.println("Please input four color codes to form your code. If more are inputted, only the 1st four will be saved.");
        System.out.println("Your choices are: R (red), O (orange), B (blue), W (white), P (purple), and Y (yellow)");

        secretCode = keyboard.next();
        secretCode = secretCode.replaceAll("\\s+", "").toUpperCase();


        if (!isValid(secretCode)) {
            createSecretCode();
        } else {
            board.setSecretCode(secretCode);
        }
    }

    private boolean isValid(String userInput){
        i = 0;
        if (userInput.length()==4) {
            while (i < 4) {
                if (secretCode.charAt(i) == 'R' || secretCode.charAt(i) == 'O' || secretCode.charAt(i) == 'B' || secretCode.charAt(i) == 'W' || secretCode.charAt(i) == 'P' || secretCode.charAt(i) == 'Y') {
                    i++;
                } else {
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

    private void automaticSecretCode() {

        for (int i = 0; i < 4; i++) {
            switch ((int) (Math.random() * (5))) {
                case 0:
                    secretCode=secretCode+"R";
                    break;
                case 1:
                    secretCode=secretCode+"O";
                    break;
                case 2:
                    secretCode=secretCode+"B";
                    break;
                case 3:
                    secretCode=secretCode+"W";
                    break;
                case 4:
                    secretCode=secretCode+"P";
                    break;
                case 5:
                    secretCode=secretCode+"Y";
                    break;
            }
        }
        board.setSecretCode(secretCode);
    }

    public void guessPeg() {
        String peg;
        System.out.println("Try to guess the secret code. Choose 4 of the following choices: R, O, B, W, P, or Y. Good Luck!");
        peg = keyboard.next();
        peg = peg.replaceAll("\\s+", "").toUpperCase();

        if (isValid(peg)){
            board.setRow(peg);
            wonGame = service.checkPegsAgainstCode(board, numberGuessed);

            numberGuessed+=1;
        }
        else{
            System.out.println("That was an invalid guess. Please try again.");
            guessPeg();
        }

        if (wonGame) {
            displayEndBoard(board);
        }
        else {
            displayBoard(board);
        }

    }


    public boolean gameIsNotOver() {
        if (numberGuessed==12 || wonGame){
            return false;
        }
        else {
            return true;
        }
    }

    public void displayBoard(Board board) {
        view.displayGame(board);

    }

    private void displayEndBoard(Board board) {
        view.displayEndGame(board);
    }
}