package controller;

import java.util.Scanner;

public class GameUserInput {

    Scanner keyboard = new Scanner(System.in);

    public String nextInput(){
        return keyboard.next();
    }
}
