package controller;

public class Main {
    public static void main(String [] args){


    Controller controller = new Controller();
    GameSetup gameSetup = new GameSetup();


        gameSetup.welcomeToGame();
        gameSetup.gameOption();




        do {
    controller.playMastermind();
    }while (GamePlay.amountPlayed < GameSetup.amountWantToPlay);


    }
}
