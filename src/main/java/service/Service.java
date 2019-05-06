package service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Board;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Service {


    public Boolean checkPegsAgainstCode(Board board, Integer guessNumber) {
        String newestRow = board.getRow().get(board.getRow().size()-1);

        if (newestRow.equals(board.getSecretCode().get(0))){
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

        for (int i=0; i<4; i++){
                if (board.getSecretCode().get(0).charAt(i) == pegs.charAt(i)){
                    toSetAsClue+="R";
                }
                else if (board.getSecretCode().get(0).contains(Character.toString(pegs.charAt(i)))){
                    toSetAsClue+="W";
                }
                else {
                    toSetAsClue+=" ";
                }
            }

        board.setClues(toSetAsClue);
        }
    }
