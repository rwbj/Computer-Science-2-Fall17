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
import java.util.Scanner;

public class BlackJackRun {
    public static void main (String[] args){        
        play();
        //driverTest();
    }
    
    public static void play(){
        GameFunctions game = new GameFunctions();
        Scanner sc = new Scanner(System.in);
        String scString;
        Scanner it = new Scanner(System.in);
        int bet;
        
        game.startGame();
        game.clearTable();
        
        boolean exit = false;
        do{
            try{
                System.out.println("play a new hand?");
                scString = sc.nextLine();
                if (scString.charAt(0) == 'y'){
                    //bet
                    boolean canBet=true;
                    do{
                        System.out.println("\nyou have $" + game.getMoney() + "\nhow much do you want to bet?: ");
                        bet = it.nextInt();
                        if (bet <= game.getMoney() && bet > 0){
                            game.addMoney(0-bet);
                            canBet=false;
                        }
                        else {
                            System.out.println("you can't bet that amount");
                        }
                    }while(canBet);

                    System.out.println("");
                    //draw hand
                    for (int i = 0; i < 2; i++){
                        int[] c = game.drawCard();
                        game.addToHand(c[0], c[1]);                
                    }

                    //draw dealer
                    for (int i = 0; i < 2; i++){
                        int[] c = game.drawCard();
                        game.addToDealer(c[0], c[1]);                
                    }

                    //show hand
                    game.printHand();

                    System.out.println("");
                    //show dealer
                    game.printDealer();
                    //hand hit/stay/bust loop

                    System.out.println("");

                    boolean playerHit = true;
                    boolean dealerHit = true;
                    do{
                        System.out.println("you hand's total is " + game.count(true));
                        if (game.count(true)==21){
                            System.out.println("forced stay at 21!");
                            playerHit = false;
                        } 
                        else if(game.count(true)>21){
                            System.out.println("you BUSTED!");
                            playerHit = false;
                            dealerHit = false;
                        }
                        else{
                            System.out.println("hit or stay?");
                            scString = sc.nextLine();
                            if (scString.charAt(0)=='h'){
                                int[] c;
                                c = game.drawCard();
                                game.addToHand(c[0], c[1]);
                                game.printHand();
                            }
                            else if (scString.charAt(0)=='s'){
                                playerHit = false;
                            }
                            else{System.out.println("please enter hit/stay");}
                        }

                        System.out.println("");

                    }while(playerHit);

                    System.out.println("");
                    //dealer hit/stay/bust loop
                    game.showDealer();
                    game.printDealer();
                    System.out.println("dealer hand's total is " + game.count(false));
                    while(dealerHit){
                        sc.nextLine();
                        if (game.count(false)>=17 && game.count(false)<=21){
                            System.out.println("forced stay at " + game.count(false));
                            dealerHit = false;
                        }
                        else if (game.count(false)>21){
                            System.out.println("dealer BUSTED!");
                            dealerHit = false;
                        }
                        else {
                            int[] c;
                            c = game.drawCard();
                            game.addToDealer(c[0], c[1]);
                            game.printDealer();
                            System.out.println("dealer hand's total is " + game.count(false));                        
                        }
                    }
                    System.out.println("");

                    //compare hand totals
                    System.out.println("player: " + game.count(true));
                    System.out.println("dealer: " + game.count(false) + "\n");
                    if ((game.count(true)<=21 && game.count(true)>=game.count(false)) || game.count(false)>21){
                        //pay out it win or half on a tie
                        if (game.count(true)==game.count(false)){
                            System.out.println("the hand is a DRAW\nyou get $" + bet + " back");
                            game.addMoney(bet);
                        }
                        else {
                            System.out.println("you WIN the hand\nyou won $" + (2*bet));
                            game.addMoney(2*bet);
                        }
                    }
                    else{
                        System.out.println("you LOSE the hand");
                    }
                    game.clearTable();
                }
                else if(scString.charAt(0)=='n'){exit = true;}
                else if(scString=="" || scString.length()==0){System.out.println("please enter yes/no");}
                else{System.out.println("please enter yes/no");}
                //exit?
            }catch(Exception e){
                System.out.println(e.getMessage());
                }
        }while(!exit);
        System.out.println("you are leaving the table with $" + game.getMoney());
    }
    
    ///this is the test driver!!!!
    
    @SuppressWarnings("empty-statement")
    public static void driverTest(){
        System.out.println("this is a test");
        //the class objects
        GameFunctions gameTest = new GameFunctions();
        Card cardTest = new Card();
        Deck deckTest = new Deck();
        int[] c = new int[2];
        //variables
        int testF = 13;
        int testS = 3;
        
        //populate the arrays for the hands
        gameTest.startGame();
        gameTest.clearTable();
        
        //run tests
        System.out.println("\ntesting Card.class");
        cardTest.setFace(testF);
        cardTest.setSuit(testS);
        System.out.println("face = " + cardTest.getFace());
        System.out.println("suit = " + cardTest.getSuit());
        System.out.println(cardTest.getSuitString());
        
        //deck test
        System.out.println("\ntesting Deck.class");
        System.out.println("pre-draw = false: " + deckTest.isDrawn(testF, testS));
        deckTest.draw(testF, testS);
        System.out.println("post-draw = true: " + deckTest.isDrawn(testF, testS));
        deckTest.shuffle();
        System.out.println("post-shuffle = false: " + deckTest.isDrawn(testF, testS));
        
        //blackjack test
        System.out.println("\ntesting BlackJack.class");
        System.out.println("show the hand pre-card draw");
        gameTest.printHand();
        System.out.println("generat card");
        /*
        //first card
        c = gameTest.drawCard();
        System.out.println("face = " + c[0] + ", suit = " + c[1]);
        gameTest.addToHand(c[0],c[1]);
        gameTest.printHand();
        System.out.println("handLength = " + gameTest.getHandLength());
        //second card
        c = gameTest.drawCard();
        System.out.println("face = " + c[0] + ", suit = " + c[1]);
        gameTest.addToHand(c[0],c[1]);
        gameTest.printHand();
        System.out.println("handLength = " + gameTest.getHandLength());
        */
        //four more cards
        for (int i = 0; i < 2; i++){
            c = gameTest.drawCard();
            gameTest.addToHand(c[0], c[1]);
        }
        gameTest.printHand();
        System.out.println("handLength = " + gameTest.getHandLength());
        System.out.println("player hand count is: " + gameTest.count(true));
        
        
        //hand test
        
        //dealer test
        System.out.println("\ntest the dealer's hand");
        c = gameTest.drawCard();
        System.out.println("c[0]+c[1] = " + c[0] +", "+ c[1]);
        gameTest.addToDealer(c[0], c[1]);
        c = gameTest.drawCard();
        System.out.println("c[0]+c[1] = " + c[0] +", "+ c[1]);
        gameTest.addToDealer(c[0], c[1]);
        gameTest.printDealer();
        System.out.println("the dealer's count is: " + gameTest.count(false));
        
        //clear table
        System.out.println("\nclear table");
        gameTest.clearTable();
        gameTest.printHand();
        System.out.println("handLength = " + gameTest.getHandLength());
        gameTest.printDealer();
        System.out.println("dealerLength = " + gameTest.getDealerLength());
    }
}