package controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameSetup {


    GameUserInput gameUserInput = new GameUserInput();
    OutputToUser outputToUser = new OutputToUser();
    static Integer amountWantToPlay = 0;
    static Integer numberOfPlayers;

    public void welcomeToGame(){
        outputToUser.welcomeMessage();
    }

    public void gameOption() {
        numberPlayers();

        if (numberOfPlayers==2) {
            amountRoundsToPlay();
        }
    }


    private void numberPlayers() {
        numberOfPlayers=0;
        outputToUser.askNumberPlayers();
        String numberPlayers = gameUserInput.nextInput();

        try{
            numberOfPlayers = Integer.parseInt(numberPlayers);

            if (numberOfPlayers>2 || numberOfPlayers<1){
                outputToUser.numberPlayersErrorMessage();
                gameOption();
            }
        }catch (Exception e){
            outputToUser.numberPlayersErrorMessage();
            gameOption();
        }
    }


    public void amountRoundsToPlay() {
        outputToUser.roundsToPlayMessage();
        String roundsPlaying = gameUserInput.nextInput();

        try{
            amountWantToPlay = Integer.parseInt(roundsPlaying) *2;
        }catch (Exception e){
            outputToUser.invalidInputMessage();
            amountRoundsToPlay();
        }
    }
}