package sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    private int answer[][] = new int[9][9];
    private int guess[][] = new int[9][9];
    private boolean shown[][] = new boolean[9][9]; //each index var= index of
    
    public void Sudoku(){
        for (int i = 0; i<answer.length; i++){
            for (int j = 0; j<answer[i].length; i++){
                answer[i][j] = 0;
                guess[i][j] = 0;
                shown[i][j] = false;
            }
        }
    }
    
    public void setPuzzle(int puzzle[][], boolean shownCells[][]){
        for (int i = 0; i < answer.length; i++){
            for (int j = 0; j < answer[i].length; j++){
                answer[i][j] = puzzle[i][j];
                shown[i][j] = shownCells[i][j];
            }
        }
    }
    
    public void inputGuess(){
        Scanner sc = new Scanner(System.in);
        int r;// = row
        int c;// = colum
        int g;// = guess
        boolean end = true;
        String error = "please enter a valid integer";
        do{
            end = true;
            System.out.print("row :");
            r = sc.nextInt()-1;
            /*if (r<1 || r>9){
                System.out.println(error);
                end = false;
            }*/
            System.out.print("colum :");
            c = sc.nextInt()-1;
            /*if (c<1 || c>9){
                System.out.println(error + " for colum");
                end = false;
            }*/
            System.out.print("guess :");
            g = sc.nextInt();
            
            //out of range check and denile exit
            if (r<0 || r>8){
                System.out.println(error + " for row");
                end = false;
            }
            if (c<0 || c>8){
                System.out.println(error + " for colum");
                end = false;
            }
            if (g<0 || g>9){
                System.out.println(error + " for guess");
                end = false;
            }
        }while(!end);
        if (!shown[r][c]){
            guess[r][c] = g;
        }
        else{
            System.out.println("that was a given number");
        }
    }
    
    public void checkGuess(){
        boolean b = true;
        for (int i = 0; i < answer.length; i++){
            for (int j = 0; j < answer[i].length; j++){
                if (guess[i][j]!=0 && guess[i][j]!=answer[i][j] && !shown[i][j]){
                    System.out.println("check answer at " + (i+1) + "," + (j+1));
                    b=false;
                }
            }
        }
        if (b){System.out.println("everything is good!");}
    }
    
    public int[][] shownPuzzle(){
        int p[][] = new int[answer.length][answer[0].length];
        //System.out.println("p.lenght = "+p.length + "\np[0].length = " + p[0].length);
        for (int i = 0; i < p.length; i++){
            for (int j = 0; j < p[i].length; j++){
                p[i][j] = 0;
                if (shown[i][j]){
                    p[i][j] = answer[i][j];
                }
                else {
                    p[i][j] = guess[i][j];
                }
            }
        }
        return p;
    }
    
    public boolean isShown(int row, int col){
        return shown[row][col];
    }
    
    public int getAnswer(int row, int col){
        return answer[row][col];
    }
    
    public void printToString(int puzzle[][]){
        for (int i = 0; i < puzzle.length; i++){
            for (int j = 0; j < puzzle.length; j++){
                if (puzzle[i][j]==0){
                    System.out.print("[ ]");
                }
                else{
                    System.out.print("[" + puzzle [i][j] + "]");
                }
                if (j==2 || j==5){
                    System.out.print(" + ");
                }
            }
            System.out.println();
            if (i==2 || i==5){
                System.out.println(" +  +  +  +  +  +  +  +  +  +  + ");
            }
        }
    }
    /*public void printPuzzle(){
        for(int i =0; i < answer.length; )
    }*/
}
