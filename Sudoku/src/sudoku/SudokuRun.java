/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class SudokuRun {
    private Sudoku sud = new Sudoku();
    private SudokuPuzzle sudPuz = new SudokuPuzzle();
    
    public static void main(String[] args){
        run();
        //testPuzzle();
        //driver();
    }
    
    public static void run(){
        Sudoku sud = new Sudoku();
        SudokuPuzzle sudPuz = new SudokuPuzzle();
        //get puzzle
        sud.setPuzzle(sudPuz.getPuzzle(), sudPuz.getShown());
        //print puzzle
        //sud.printToString(sud.shownPuzzle());
        boolean exit = false;
        while(!exit){
            Scanner sc = new Scanner(System.in);
            System.out.println("guess:1\ncheck:9\nquit:0");
            sud.printToString(sud.shownPuzzle());
            System.out.print("input:");
            int s = sc.nextInt();
            switch(s){
                case 1:
                    //ask for player input
                    sud.inputGuess();
                    break;
                case 9:
                    sud.checkGuess();
                    break;
                case 0:
                    exit = true;
                    System.out.println("now quitting");
                    break;
                default:
                    System.out.println("invalid!");
            }
        }
    }
    /*
    public static void driver(){
        Sudoku sud = new Sudoku();
        SudokuPuzzle sudPuz = new SudokuPuzzle();
        System.out.println("this is the sudPuz:" + Arrays.deepToString(sudPuz.getPuzzle()));
        System.out.println("\nthis is better:");
        for (int i = 0; i < sudPuz.getPuzzle().length; i++){
            int tempPuz[][] = sudPuz.getPuzzle();
            System.out.println(Arrays.toString(tempPuz[i]));
        }
    }
    
    public static void testPuzzle(){
        Sudoku sud = new Sudoku();
        SudokuPuzzle sudPuz = new SudokuPuzzle();
        //sud.Sudoku();
        sud.setPuzzle(sudPuz.getPuzzle(), sudPuz.getShown());
        for (int i = 0; i < 9; i++){
            int countRow = 0;
            int countCol = 0;
            int j;
            for (j = 0; j < 9; j++){
                countRow = countRow + sud.getAnswer(i,j);
                countCol = countCol + sud.getAnswer(j,i);
            }
            System.out.println("countRow of row " + i + " is " + countRow);
            System.out.println("countCol of col " + j + " is " + countCol);
        }
        int testPuz[][] = sudPuz.getPuzzle();
        for (int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(testPuz[i]));
        }
        sud.printToString(sudPuz.getPuzzle());
        
        sud.printToString(sud.shownPuzzle());
        //sud.printPuzzle();
        //System.out.println(Arrays.toString(sud.inputGuess()));
    }
    */
}
