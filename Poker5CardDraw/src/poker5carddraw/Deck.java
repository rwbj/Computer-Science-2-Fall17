/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5carddraw;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author Robert Jones
 */
public class Deck {
    Card[] c;
    int[] d;
    
    public Deck(){
        c = new Card[54];
        d = new int[c.length];
        int count = 0;
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++){
                c[count] = new Card(i+1,j+1);
                d[count] = count;
                count++;
            }
        }
        for(int i = count; i < c.length; i++){
            c[i] = new Card(14,5);
            d[count] = count;
            count++;
        }
    }
    
    public Deck(int numOfJokers){
        if(numOfJokers<0) numOfJokers = 0;
        c = new Card[52+numOfJokers];
        d = new int[c.length];
        int count = 0;
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++){
                c[count] = new Card(i+1,j+1);
                d[count] = count;
                count++;
            }
        }
        for(int i = count; i < c.length; i++){
            c[i] = new Card(14,5);
            d[count] = count;
            count++;
        }
    }
    
    public void printCount(){
        System.out.println(Arrays.toString(d));
    }
    
    public Card drawCard(){
        boolean end = false;
        Card newCard;
        do{
            int index = new Random().nextInt(c.length);
            newCard = c[index];
            if (newCard.getInDeck()==true){
                end = true;
                c[index].setInDeck(false);
            }
        }while(!end);
        return newCard;
    }
    /**
     * this will return a requested card regardless of whether the card is in the deck (inDeck)
     * and pull the card from the deck (inDeck=false)
     * @param cardFace (0 = not set, 1-13 = card value, 14 = joker)
     * @param cardSuit
     * @return Object of class Card with the face of cardFace and suit of cardSuit
     */
    public Card drawCard(int cardFace, int cardSuit){
        int index = ((4*(cardFace-1))+(cardSuit-1));
        c[index].setInDeck(false);
        return c[index];
    }
    
    public void resetDeck(){
        for(int i = 0; i < c.length; i++){
            c[i].setInDeck(true);
        }
    }
    
    public void testPrintAll(){
        for(Card ic:c){
            ic.printCard();
        }
    }
}
