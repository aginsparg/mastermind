package view;

import model.Board;

public class View {


    private ViewService viewService = new ViewService();

     public void displayGame(Board board){
         viewService.formatBoardAndPrint(board);
     }

     public void displayEndGame(Board board){
         viewService.formatAndPrintCode(board);
         viewService.formatBoardAndPrint(board);
     }


}
