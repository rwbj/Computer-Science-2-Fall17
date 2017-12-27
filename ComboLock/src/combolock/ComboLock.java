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
import java.util.Random;

public class ComboLock {
    
    private int num = 0; // the current location of the dile
    private int targetStop[][] = new int[3][2]; //targetStop={{dile value}, {full rotations(0 or 1)}}
    private String directionText;
    
    public void genNums(){
        Random RNG = new Random();
        for(int i = 0; i < 3; i++){
            targetStop[i][0] = RNG.nextInt(40);//the taget stop num
            targetStop[i][1] = RNG.nextInt(2);//number of full rotations
        }
    }
    
    public void writeNums(){
        for(int i = 0; i<3; i++){
            if (i == 1) {directionText = "right";}
            else{directionText = "left";}
            System.out.print("turn " + directionText);
            if (targetStop[i][1] == 1) {System.out.print(" one full rotation");}            
            System.out.println(", stopping at " + targetStop[i][0]);
            //System.out.println("");
        }
        System.out.println("");
    }
    public int getTargetStop(int step){
        return targetStop[step][0];
    }
    
    public int getNum(){
        //System.out.println("the dile is at " + num);
        return num;
    }
    /* //I ties this at first to test the direction at the same time as setting the num
    public void turn(int clicks, char direction){
        if(direction == 'l'){
            for(int i = clicks; i>0; i--){
                if(num == 0){num = 39;}
                else{num--;}
            }
        }
        else{
            for(int i = clicks; i>0; i--){
                if(num == 39){num = 0;}
                else{num++;}
            }
        }  
    }
    */
    public boolean isAtNum(int step, int rotations, int num){
        if(num==targetStop[step][0]&&rotations==targetStop[step][1]){return true;}
        else{return false;}
        
    }
    
    public void helpPrint(){
        System.out.println("turn = turn the dile");
        System.out.println("open = attempt to open the lock");
        System.out.println("generate = randomeize the lock's combination");
        System.out.println("print = print out the combination instructions");
        //System.out.println("dile = show the dile's location");
        System.out.println("help = show this comand list");
        System.out.println("quit = exit the program\n");
        }
        
    public boolean unlock(boolean canOpen){
        if(canOpen){
            System.out.println("THE LOCK HAS OPENED!!!");
            return true;
        }
        else{return false;}
    }
    
    public void setNum(int numValue){
        num = numValue;
    }
    
    public boolean correctDirection(int successes, char direction){
        if(successes==1 && direction=='r'){return true;}
        else if(successes!=1 && direction=='l'){return true;}
        else{return false;}
    }

}
