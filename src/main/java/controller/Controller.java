package controller;



public class Controller {

    public void playMastermind(){


        GameSetup gameSetup = new GameSetup();
        GamePlay gamePlay = new GamePlay();
        Integer numberPlayers;


        numberPlayers = GameSetup.numberOfPlayers;


        if (numberPlayers ==1){
            gamePlay.playSinglePlayer();
        }
        else{
            gamePlay.playTwoPlayer();
        }


            while (gamePlay.gameIsNotOver()) {
                gamePlay.guessPeg();
            }
    }
}