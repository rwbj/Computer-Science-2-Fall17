/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5carddraw;

/**
 *
 * @author Robert Jones
 */
public class Card {
    private int face;
    private String faceStr;
    private int suit;
    private String suitStr;
    private String[] suitStrArr = {"no suit set", "spades", "diamonds", "clubs", "hearts", "the joker"};
    private String[] faceStrArr = {"no face set",
        "ace",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "jack",
        "queen",
        "king",
        "joker"};
    private boolean shown;
    private boolean inDeck;
            
    public Card(){
        face = 0;
        faceStr = faceToString();
        suit = 0;
        suitStr = suitToString();
        shown = false;
        inDeck = true;
    }
    
    public Card(int initalFace, int initalSuit){
        face = initalFace;
        faceStr = faceToString();
        suit = initalSuit;
        suitStr = suitToString();
        shown = false;
        inDeck = true;
    }
    
    public Card(int initalFace, int initalSuit, boolean initalShown){
        face = initalFace;
        faceStr = faceToString();
        suit = initalSuit;
        suitStr = suitToString();
        shown = initalShown;
        inDeck = true;
    }
    
    public String faceToString(){
        String s;
        try{
            s = faceStrArr[face];
        }catch(Exception e){
            s = faceStrArr[0];
        }
        return s;
    }
    
    public String suitToString(){
        String s;
        try{
            s = suitStrArr[suit];
        }catch(Exception e){
            s = suitStrArr[0];
        }
        return s;
    }
    
    public void printCard(){
        if (face == 14){
            System.out.println(faceStr);
        }
        else {
            System.out.println(faceStr + " of " + suitStr);
        }
    }
    
    public int getFace(){
        return face;
    }
    
    public void setFace(int newFace){
        face = newFace;
        faceStr = faceToString();
    }
    
    public int getSuit(){
        return suit;
    }
    
    public void setSuit(int newSuit){
        suit = newSuit;
        suitStr = suitToString();
    }
    
    public boolean getShown(){
        return shown;
    }
    
    public void setShown(boolean newShown){
        shown = newShown;
    }
    
    public boolean getInDeck(){
        return inDeck;
    }
    
    public void setInDeck(boolean isInDeck){
        inDeck = isInDeck;
    }
}
