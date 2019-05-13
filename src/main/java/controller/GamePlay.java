package controller;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import service.Service;
import view.View;

import java.util.Scanner;
import java.util.stream.Collectors;
@Getter
@Setter
public class GamePlay {
    private GameUserInput gameUserInput = new GameUserInput();
    private OutputToUser outputToUser = new OutputToUser();
    private Board board = new Board();
    private View view = new View();
    private String secretCode="";
    private Integer numberGuessed=0;
    private boolean wonGame = false;
    private Service service = new Service();
    private String wantsDuplicates;
    static Integer amountPlayed=0;


    public void playSinglePlayer() {
        outputToUser.askAboutDuplicates();
        wantsDuplicates = gameUserInput.nextInput();

        if (!(wantsDuplicatesAnswerValid())){
            playSinglePlayer();
        }
        automaticSecretCode();
        view.clearScreen();
    }


    public void playTwoPlayer() {

        outputToUser.askAboutDuplicates();
        wantsDuplicates = gameUserInput.nextInput();
        if (!(wantsDuplicatesAnswerValid())){
            playTwoPlayer();
        }
        createSecretCode();
        view.clearScreen();
    }

    private boolean wantsDuplicatesAnswerValid(){
        return  (wantsDuplicates.equalsIgnoreCase("yes") || wantsDuplicates.equalsIgnoreCase("no")|| wantsDuplicates.equalsIgnoreCase("y")||wantsDuplicates.equalsIgnoreCase("n"));
    }


    private void createSecretCode() {
       outputToUser.createSecretCodeInstructions();
        secretCode = gameUserInput.nextInput();
        secretCode = secretCode.replaceAll("\\s+", "").toUpperCase();

        if (wantsDuplicates.equalsIgnoreCase("N")|| wantsDuplicates.equalsIgnoreCase("no")){
        if (areDuplicates(secretCode)){
            outputToUser.duplicatesErrorMessage();
            createSecretCode();
        }}


        if (!isValid(secretCode)) {
            createSecretCode();
        } else {
            board.setSecretCode(secretCode);
        }
    }

    private Boolean areDuplicates(String toCheck) {
        int duplicate = 0;
        for (int i=0; i<toCheck.length(); i++){
            for (int j=0; j<toCheck.length(); j++){
               if (i !=j){
                if (toCheck.charAt(i)==toCheck.charAt(j)){
                   duplicate++;
               }
               }
            }
        }
        if (duplicate>0){
            return true;
        }
        else {
            return false;
        }

    }

    private boolean isValid(String userInput){
        Integer locationInCode = 0;
        if (userInput.length()==4) {
            while (locationInCode < 4) {
                if (secretCode.charAt(locationInCode) == 'R' || secretCode.charAt(locationInCode) == 'O' || secretCode.charAt(locationInCode) == 'B' || secretCode.charAt(locationInCode) == 'W' || secretCode.charAt(locationInCode) == 'P' || secretCode.charAt(locationInCode) == 'Y') {
                    locationInCode++;
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
        secretCode="";

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
        if (wantsDuplicates.equalsIgnoreCase("N")|| wantsDuplicates.equalsIgnoreCase("no")){
        if (areDuplicates(secretCode)){
            automaticSecretCode();
        }
        }
        board.setSecretCode(secretCode);
    }

    public void guessPeg() {
        String peg;
        outputToUser.guessSecretCodeInstructions();
        peg = gameUserInput.nextInput();
        peg = peg.replaceAll("\\s+", "").toUpperCase();

        if (isValid(peg)){
            board.setRow(peg);
            wonGame = service.checkPegsAgainstCode(board);

            numberGuessed+=1;
        }
        else{
            outputToUser.invalidGuessError();
            guessPeg();
        }

        if (wonGame) {
            view.displayEndGame(board);
        }
        else {
            view.displayGame(board);
        }
    }


    public boolean gameIsNotOver() {
        if (numberGuessed==12){
            outputToUser.youLostMessage();
            amountPlayed++;
            return false;
        }
        else if (wonGame){
            outputToUser.youWonMessage();
            amountPlayed++;
            return false;
        }
        else {
            return true;
        }
    }

}