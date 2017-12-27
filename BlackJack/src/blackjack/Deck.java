/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author Robert
 */
public class Deck {
    //private int face;
    //private int suit;
    private static boolean[][] deck = new boolean[13][4];
    //private int[] card = new int[2];
    //private Random rng = new Random();
    
    /*
    public int[] drawCard(){
        do{
            face = rng.nextInt(13);
            suit = rng.nextInt(4);
        }while (!deck[face][suit]);
        card[0] = face;
        card[1] = suit;
        return card;
    }
    */
    
    public boolean isDrawn(int face,int suit){
        return deck[face-1][suit];
    }
    
    public void draw(int face, int suit){
        deck[face-1][suit] = true;
    }
    
    public void shuffle(){
        for (int i = 0; i < deck.length; i++){
            for (int n = 0; n < deck[0].length; n++){
                deck[i][n] = false;
            }
        }
    }
}
