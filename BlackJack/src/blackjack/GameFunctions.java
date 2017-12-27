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

public class GameFunctions {

    private int face;
    private int suit;
    private int[] card = new int[2];
    private Random rng = new Random();
    private Deck deck = new Deck();
    private static Card[] hand = new Card[12];
    private static int handLength = 0;
    private static Card[] dealer = new Card[12];
    private static int dealerLength = 0;
    //private Card newCard = new Card();
    private int money = 100;
    
    /* 
    private void GenDeck(){
        for (int i = 13; i > 0; i--){
            deck[i-1][0] = false;
            for (int n = 4; i > 0; i--){
                deck[i-1][n] = false;
            }
        }
    }
    */
    
    /* this is a saved copy (10/1/17 at 7:33pm)
    public int[] drawCard(){
        do{
            face = rng.nextInt(13);
            suit = rng.nextInt(4);
        }while(deck.isDrawn(face, suit));
        deck.draw(face, suit);
        card[0] = face;
        card[1] = suit;
        return card;
    }
        
    public void addToHand(int newFace, int newSuit){
        newCard.setFace(newFace);
        newCard.setSuit(newSuit);
        hand[handLength] = newCard;
        handLength++;
    }
    
    public void addToDealer(int newFace, int newSuit){
        if (dealerLength == 0){newCard.setShown(false);}
        else{newCard.setShown(true);}
        newCard.setFace(newFace);
        newCard.setSuit(newSuit);
        hand[handLength] = newCard;
        dealerLength++;
    }
    */
    //run this at the start of the main
    public void startGame(){
        for (int i = 0; i < hand.length; i++){
            hand[i] = new Card();
        }
        for (int i = 0; i < dealer.length; i++){
            dealer[i] = new Card();
        }
        //deck.shuffle();
    }
    
    public int[] drawCard(){
        do{
            face = rng.nextInt(13)+1;
            suit = rng.nextInt(4);
        }while(deck.isDrawn(face, suit));
        deck.draw(face, suit);
        card[0] = face;
        card[1] = suit;
        return card;
    }
              
    public void addToHand(int newFace, int newSuit){
        Card c = new Card();
        c.setFace(newFace);
        c.setSuit(newSuit);
        hand[handLength] = c;
        handLength++;
    }
    
    public void addToDealer(int newFace, int newSuit){
        Card c = new Card();
        if (dealerLength == 0){c.setShown(false);}
        else{c.setShown(true);}
        c.setFace(newFace);
        c.setSuit(newSuit);
        dealer[dealerLength] = c;
        dealerLength++;
    }
    
    public void printHand(){
        System.out.println("Your hand is:");
        if (handLength < 1){
            System.out.println("empty");
        }
        else{
            for (int i = 0; i < handLength; i++){
                System.out.println("" + hand[i].getFaceString() + " of " + hand[i].getSuitString());
            }
        }
    }
    
    public void printDealer(){
        System.out.println("Dealer's hand is:");
        if (dealerLength < 1){
            System.out.println("empty");
        }
        else{
            for (int i = 0; i < dealerLength; i++){
                if (dealer[i].getShown())
                {
                    System.out.println("" + dealer[i].getFaceString() + " of " + dealer[i].getSuitString());
                }
                else
                {
                    System.out.println("hidden card");
                }
            }
        }
    }
    
    public void showDealer(){
        for (int i = 0; i < dealer.length; i++){
            dealer[i].setShown(true);
        }
    }
    
    public int count(boolean isPlayer){
        int ace = 0;
        int count = 0;
        if (isPlayer){
            for (int i = 0; i < handLength; i++){
                if (hand[i].getFace() == 1){//change aces to 11
                    //count = count + 11;
                    ace++;
                }
                count = count + hand[i].getValue();
            }
        }
        else{
            for (int i = 0; i < dealerLength; i++){
                if (dealer[i].getFace() == 1){//change aces to 11
                    //count = count + 11;
                    ace++;
                }
                count = count + dealer[i].getValue();
            }
        }
        while(count > 21 && ace > 0){//ace (as 11) becomes 1 if total goes over 21
            count = count - 10;
            ace--;
        }
        return count;
    }
    
    public int getHandLength(){
        return handLength;
    }
    
    public int getDealerLength(){
        return dealerLength;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void addMoney(int newMoney){
        money = money + newMoney;
    }
        
    public void clearTable(){
        for (int i = 0; i < hand.length; i++){
            hand[i].setFace(-1);//is this needed?
            hand[i].setSuit(-1);//is this needed?
            hand[i].setShown(true);
            dealer[i].setFace(-1);//-1 is a null value for this
            dealer[i].setSuit(-1);
            dealer[i].setShown(true);
            deck.shuffle();
            dealerLength = 0;
            handLength = 0;
        }
    }
   
}
