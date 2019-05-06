package controller;

import model.Board;
import view.View;

public class Controller {

    public static void main(String [] args){

        GameSetup gameSetup = new GameSetup();
        GamePlay gamePlay = new GamePlay();
        Integer numberPlayers;


        gameSetup.welcomeToGame();
        numberPlayers = gameSetup.gameOption();

        if (numberPlayers ==1){
            gamePlay.playSinglePlayer();
        }
        else{
            gamePlay.playTwoPlayer();
        }

        while(gamePlay.gameIsNotOver()){
            gamePlay.guessPeg();

        }

        System.out.println("Congrats! You finished!");


    }
}
