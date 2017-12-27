/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5carddraw;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Robert Jones
 */
public class Poker5CardDraw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("enter the number of jokers");
        Deck deck = new Deck(new Scanner(System.in).nextInt());
        deck.testPrintAll();
        deck.drawCard(4, 1).printCard();
        boolean b = true;
        /*while(b){
            System.out.println("enter the face then the suit value");
            try{
                deck.drawCard(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()).printCard();
            }catch(Exception e){
                System.out.println("error");
            }
        }//*/
        deck.printCount();
        int a[] = new int[52];
        for (int i = 0; i < a.length; i++){
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        a[3] = 0;
        a[5] = -1;
        a[7] = 100;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    
}
