/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testZone();
    }
    
    private static void testZone(){
        int initalGrid[][] = {{0,1,0},{2,1,0},{2,1,2}};
        Board b = new Board(initalGrid);
        b.printBoard();
        while(true){
            /*System.out.println("enter a number: ");
            int a = new Scanner(System.in).nextInt()-1;
            int z = a/3;
            int j = a - (z*3);
            //System.out.println("x/3 = " + z);
            System.out.println("row " + z + ", colom " + j);//*/
            System.out.println("entet a row:");
            int i = new Scanner(System.in).nextInt();
            System.out.println("entet a colom:");
            int j = new Scanner(System.in).nextInt();
            int refNum = (i*3)+j+1;
            System.out.println("refNum = " + refNum);
        }
    }
    
    private static int[][] turnX(int[][] curBoard){
        
    }
    
    private static int[][] turnO(int[][] curBoard){
        
    }
    
    private static boolean isFree(int gridLocation){
       
    }
}
