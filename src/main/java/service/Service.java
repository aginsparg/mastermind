package service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Board;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Service {


    public Boolean checkPegsAgainstCode(Board board) {
        String newestRow = board.getRow().get(board.getRow().size()-1);

        if (newestRow.equals(board.getSecretCode())){
            fillClues(board);
            return true;
        }
        else {
            fillClues(board, newestRow);
            return false;

        }
    }

    private void fillClues(Board board) {

        board.setClues("RRRR");
    }

    private void fillClues(Board board, String pegs) {
        createClues(board, pegs);

    }

    private void createClues(Board board, String pegs) {
        String toSetAsClue = "";
        String keyCopy = board.getSecretCode();
        String guessCopy = pegs;

        for (int i=0; i<4; i++){
                if (keyCopy.charAt(i) == guessCopy.charAt(i)){
                    toSetAsClue += "R";

                    keyCopy = keyCopy.replace(keyCopy.charAt(i), ' ');
                    guessCopy = guessCopy.replace(guessCopy.charAt(i), ' ');
                }
        }

        for (int i=0; i<guessCopy.length(); i++){
            if (guessCopy.charAt(i) != ' '){
            if (keyCopy.contains(Character.toString(guessCopy.charAt(i)))) {
                toSetAsClue += "W";
            }
            }}

        while (toSetAsClue.length()<4){
            toSetAsClue +=" ";
        }

        board.setClues(toSetAsClue);
        }
    }