package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Board {


    private List<String> row=new ArrayList<>();
    private String secretCode = "";
    private List<String> clues = new ArrayList<>();




    public void setSecretCode(String code) {

            secretCode = code;

    }

    public void setRow(String guess){

        row.add(guess);
    }

    public void setClues(String clue){
        clues.add(clue);
    }
}