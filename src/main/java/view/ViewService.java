package view;

import model.Board;

import java.util.List;

public class ViewService {

    public void formatBoardAndPrint(Board board){

        List<String>rows = board.getRow();

        for (int i =0; i<rows.size(); i++) {
            String row = rows.get(i);
            for (int m=0; m<4; m++){
                System.out.print("     " + row.charAt(m));
            }
            System.out.println();
            formatAndPrintClues(board, i);

        }
    }


    public void formatAndPrintCode(Board board) {
        List<String> code = board.getSecretCode();

        for (int i =0; i<code.size(); i++) {
            System.out.print("     " + code.get(i));
        }
        System.out.println();
    }

    public void formatAndPrintClues(Board board, Integer locationInList){
        List<String> cluesRow = board.getClues();

            String clue = cluesRow.get(locationInList);
        for (int i=0; i<2; i++) {

            System.out.print(clue.charAt(i) + "  ");
        }
        System.out.println();

        for (int i=2; i<4; i++){
                System.out.print(clue.charAt(i) + "  ");

        }
        System.out.println();

    }
}
