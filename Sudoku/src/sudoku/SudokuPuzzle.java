/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Robert
 */
public class SudokuPuzzle {
    
    private int puzzle1[] = {1,2,3,6,7,8,9,4,5};
    private int puzzle2[] = {5,8,4,2,3,9,7,6,1};
    private int puzzle3[] = {9,6,7,1,4,5,3,2,8};
    private int puzzle4[] = {3,7,2,4,6,1,5,8,9};
    private int puzzle5[] = {6,9,1,5,8,3,2,7,4};
    private int puzzle6[] = {4,5,8,7,9,2,6,1,3};
    private int puzzle7[] = {8,3,6,9,2,4,1,5,7};
    private int puzzle8[] = {2,1,9,8,5,7,4,3,6};
    private int puzzle9[] = {7,4,5,3,1,6,8,9,2};
    
    private boolean x = true;
    private boolean o = false;
    
    private boolean shown1[] = {o,x,o,x,o,x,o,o,o};
    private boolean shown2[] = {x,x,o,o,o,x,x,o,o};
    private boolean shown3[] = {o,o,o,o,x,o,o,o,o};
    private boolean shown4[] = {x,x,o,o,o,o,x,o,o};
    private boolean shown5[] = {x,o,o,o,o,o,o,o,x};
    private boolean shown6[] = {o,o,x,o,o,o,o,x,x};
    private boolean shown7[] = {o,o,o,o,x,o,o,o,o};
    private boolean shown8[] = {o,o,x,x,o,o,o,x,x};
    private boolean shown9[] = {o,o,o,x,o,x,o,x,o};

    private final int[][] puzzle = {puzzle1, puzzle2, puzzle3, puzzle4, puzzle5, puzzle6, puzzle7, puzzle8, puzzle9};
    private final boolean shown[][] = {shown1,shown2,shown3,shown4,shown5,shown6,shown7,shown8,shown9};
    
    public int[][] getPuzzle(){
        return puzzle;
    }
    
    public boolean[][] getShown(){
        return shown;
    }
}
