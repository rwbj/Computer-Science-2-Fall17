/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Robert
 */
public class Card {
    private int face = -1;
    private int suit = -1;
    private boolean shown = true; //for the face down card in the dealer's hand
    
    public int getFace(){
        return face;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public boolean getShown() {
        return shown;
    }
    
    public void setFace(int newFace) {
        face = newFace;
    }
    
    public void setSuit(int newSuit) {
        suit = newSuit;
    }
    
    public void setShown(boolean newShown){
        shown = newShown;
    }
    
    public int getValue(){
        int value;
        if (face == 1){value = 11;}
        else if (face > 10){value = 10;}
        else {value = face;}
        return value;
    }
    
    public String getFaceString(){
        String faceString;
        if (face > 1 && face < 11){
            faceString = (""+face);
        }
        else{
            switch(face){
                case 1:
                    faceString = "ace";
                    break;
                case 11:
                    faceString = "jack";
                    break;
                case 12:
                    faceString = "queen";
                    break;
                case 13:
                    faceString = "king";
                    break;
                default:
                    faceString = "undeclard face";
                    break;                
            }
        }
        return faceString;
    }
    
    public String getSuitString(){
        String suitString;
        switch(suit){
            case 0:
                suitString = "spades";
                break;
            case 1:
                suitString = "hearts";
                break;
            case 2:
                suitString = "clubs";
                break;
            case 3: 
                suitString = "diamonds";
                break;
            default:
                suitString = "undeclared suit";
                break;
        }
        return suitString;
    }
}