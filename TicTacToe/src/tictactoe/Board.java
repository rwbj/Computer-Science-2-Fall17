/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;

/**
 *
 * @author Robert
 */
public class Board {
    private int grid[][] = new int[3][3];//grid[row][colom]
    private int b1;
    private int b2;
    private int b3;
    private int b4;
    private int b5;
    private int b6;
    private int b7;
    private int b8;
    private int b9;
    
    public Board(int in1, int in2, int in3, int in4, int in5, int in6, int in7, int in8, int in9){
        b1 = in1;
        b2 = in2;
        b3 = in3;
        b4 = in4;
        b5 = in5;
        b6 = in6;
        b7 = in7;
        b8 = in8;
        b9 = in9;
        allBoxesIntoGrid();
    }
    
    public Board(int initalGrid[][]){
        grid = initalGrid;//this might be a problem as initalGrid can be any length. Solution: set the values of the first three rows and coloms in each spot with in grid
        allGridIntoBoxes();
    }
    
    private void allBoxesIntoGrid(){
        grid = new int[][]{{b1,b2,b3},{b4,b5,b6},{b7,b8,b9}};
        System.out.println(Arrays.deepToString(grid));
    }
    
    private void boxIntoGrid(int boxNum){
        int val = 0;
        if (boxNum > 0 && boxNum < 10){
            switch(boxNum){
                case 1: val = b1;
                case 2: val = b2;
                case 3: val = b3;
                case 4: val = b4;
                case 5: val = b5;
                case 6: val = b6;
                case 7: val = b7;
                case 8: val = b8;
                case 9: val = b9;
                default: val = 0;
            }
            boxNum = boxNum-1; //moves range from 1-9 to 0-8 for devision
            int i = boxNum/3; //gets row number
            int j = boxNum - (i*3); //gets the colom number
            grid[i][j] = val;
        }
    }
    private void allGridIntoBoxes(){
        b1 = grid[0][0];
        b2 = grid[0][1];
        b3 = grid[0][2];
        b4 = grid[1][0];
        b5 = grid[1][1];
        b6 = grid[1][2];
        b7 = grid[2][0];
        b8 = grid[2][1];
        b9 = grid[2][2];
    }
    
    private void gridIntoBox(int row, int col){
        if (row<3 && row>-1 && col<3 && col>-1){
            int boxNum = ((row*3)+col+1);
            switch(boxNum){
                case 1: b1 = grid[row][col];
                case 2: b2 = grid[row][col];
                case 3: b3 = grid[row][col];
                case 4: b4 = grid[row][col];
                case 5: b5 = grid[row][col];
                case 6: b6 = grid[row][col];
                case 7: b7 = grid[row][col];
                case 8: b8 = grid[row][col];
                case 9: b9 = grid[row][col];
                default:;
            }
        }
        /*else {//throw exception for bad input...
            throw
        }//*/
    }
    
    public char toMark(int boxNum){
        if (boxNum==1){
            return 'X';
        }
        else if(boxNum==2){
            return 'O';
        }
        else{
            return ' ';
        }
    }
    
    public void printBoard(){
        for (int i = 0; i < grid.length; i++){//this prints top to bottom
            for (int j = 0; j < grid[i].length; j++){//this prints left to right
                if (j!=0){
                    System.out.print("|");
                }
                System.out.print(" " + toMark(grid[i][j]) + " ");
            }
            System.out.println();
            if (i!=grid.length-1){
                System.out.print("-----------\n");
            }
        }
    }
    /**
     *
     * @return 
     * returns a int value for the win state
     * 0 = no win yet
     * 1 = player 1 wins (X)
     * 2 = player 2 wins (O)
     */
    public int isWinner(){
        int i = 0;
        if(grid[1][1]!=0){
            if ((grid[1][1]==grid[2][0] && grid[1][1]==grid[0][2]) || //[/]
                    (grid[1][1]==grid[2][2] && grid[1][1]==grid[0][0]) || //[\]
                    (grid[1][1]==grid[0][1] && grid[1][1]==grid[2][1]) || //[|]
                    (grid[1][1]==grid[1][0] && grid[1][1]==grid[1][2])){  //[-]
                i = grid[1][1];//wins containing the middle
            }
        }
        else if(grid[0][0]!=0){
            if ((grid[0][0]==grid[0][1] && grid[0][0]==grid[0][2]) || //[-]
                    (grid[0][0]==grid[1][0] && grid[0][0]==grid[2][0])){ //[|]
                i = grid[0][0];//wins containint the top left
            }
        }
        else if(grid[2][2]!=0){
            if ((grid[2][2]==grid[2][1] && grid[2][2]==grid[2][0]) || //[-]
                    (grid[2][2]==grid[1][2] && grid[2][2]==grid[0][2])){ //[|]
                i =  grid[2][2];//wins containtin the bottom right
            }
        }
        return i;
    }
    
    public boolean isFull(){
        boolean b = true;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j]==0){
                    b = false;
                }
            }
        }
        return b;
    }
    
    public boolean isOver(){
        boolean b = false;
        if (isFull()){
            b = true;
        }
        else if (isWinner()!=0){
            b = true;
        }
        return b;
    }
    
    public void printWinner(){
        char c = toMark(isWinner());
        if (c=='X' || c=='O'){
            System.out.println("WINNER! " + c + " has won the game");
        }
        else System.out.println("there is no winner");
    }
    
    public void clearBoard(){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j]=0;
            }
        }
        allGridIntoBoxes();
    }
    
    public int[][] getBoard(){
        return grid;
    }
    
    public void setBox(int pos, int val){
        if (pos > 0 && pos < 10){
            switch(pos){
                case 1: grid[0][0] = val;
                case 2: grid[0][1] = val;
                case 3: grid[0][2] = val;
                case 4: grid[1][0] = val;
                case 5: grid[1][1] = val;
                case 6: grid[1][2] = val;
                case 7: grid[2][0] = val;
                case 8: grid[2][1] = val;
                case 9: grid[2][2] = val;
                default:;
            }
        }
    }
    
}