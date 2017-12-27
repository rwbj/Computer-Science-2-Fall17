/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combolock;

/**
 *
 * @author Robert
 */

import java.util.Scanner;

public class ComboLockRun {
    public static void main(String[] args){
        /*the method to run the GUI(?)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComboLockGUI().setVisible(true);
            }
        });
        */
        ComboLock theLock = new ComboLock();
        
        Scanner sc = new Scanner(System.in);
        int rotations = 0;
        char direction = 'l';
        boolean isDone = false;
        int testNum;
        String readSc;
        int successes = 0;
        theLock.genNums();
        theLock.helpPrint();
        do{
            readSc = sc.nextLine();
            switch(readSc){
                case "generate": 
                    theLock.genNums();
                    System.out.println("the combination has been (re)generated\n");
                    successes = 0;
                    break;
                case "print":
                    theLock.writeNums();
                    break;
                case "turn":
                    if(successes>2){
                        System.out.println("too many turns, start form the begining");
                        successes = 0;
                    }
                    else{
                        boolean b = true;
                        //direction
                        while(b){
                            System.out.print("Which direction? (r/l): ");
                            readSc = sc.nextLine();
                            //System.out.println("readSc = " + readSc);//test
                            //System.out.println("readSc.charAt(0) = " + readSc.charAt(0));//test
                            //System.out.println("direction = " + direction);//test
                            if(readSc.charAt(0)=='r'||readSc.charAt(0)=='l'){
                                direction = readSc.charAt(0); 
                                b=false;
                            }
                            else{System.out.print("please use r or l");}
                            //System.out.println("direction = " + direction);//test

                        }    
                        //rotation
                        b=true;
                        while(b){
                            System.out.print("full rotation? (y/n): ");
                            readSc =sc.nextLine();
                            if(readSc.charAt(0)=='y'){rotations=1; b = false;}
                            else if(readSc.charAt(0)=='n'){rotations=0; b = false;}
                            else{System.out.println("please use y or n");}
                        }
                        //clicks
                        b=true;
                        while(b){
                            System.out.print("what number to you want to turn to? ");
                            testNum=sc.nextInt();
                            if(testNum > -1 && testNum < 40){
                                //theLock.turn(testNum, direction);
                                theLock.setNum(testNum);
                                b=false;
                                String dirString;
                                if(direction=='l'){dirString="left";}
                                else{dirString="right";}
                                //System.out.println("you entered: turn " + dirString + " to " + testNum + ", with " + rotations + " full rotation");
                            }
                            else{System.out.print("\nthe number needs to be between 0 and 39");}
                        }
                        //run theLock.turn
                        //theLock.turn(testNum,direction);//prints condition
                        //print successes
                        if(theLock.isAtNum(successes, rotations, theLock.getNum())&&theLock.correctDirection(successes, direction)){
                            System.out.println("click\n");
                            successes++;
                        }
                        else{
                            System.out.println("wrong input, start form the begining");
                            successes = 0;
                        }
                    }
                    break;
                case "open":
                    if(theLock.unlock(successes>=3)){isDone=true;}
                    else{System.out.println("The lock is held shut");}
                    break;
                /*case "dile":// not needed
                    theLock.getNum();
                    break;*/
                case "help":                        
                    theLock.helpPrint();
                    break;
                case "quit":
                    isDone = true;
                    break;
                case ""://the turn case results in running the default case after firing without this case
                    break;
                default:
                    System.out.println("CAN'T COMUTE!");
                    System.out.println("what do you want!?: ");
                    break;
            }
        }while(!isDone);
    }
}
