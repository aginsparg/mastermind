package view;

import model.Board;

public class View {


    private ViewService viewService = new ViewService();

     public void displayGame(Board board){
         clearScreen();
         viewService.formatBoardAndPrint(board);
     }

     public void displayEndGame(Board board){
         clearScreen();
         viewService.formatAndPrintCode(board);
         viewService.formatBoardAndPrint(board);
     }

     public void clearScreen(){
         for (int i=0; i<30; i++){
             System.out.println();
         }
     }


}
