package growthratelargerthan;

/**
 *
 * @author Robert
 */
/*
Input: 
one argument of type Species. 
Output: 
if the receiving object has larger growth rate that the growth rate of the argument object. return true
otherwise returns false*/
public class SpeciesRun {
    public static void main (String[] args){
        Species s1, s2;
        s1 = new Species();
        s2 = new Species();
        System.out.println("For Species 1:");
        s1.readInput();
        System.out.println("For Species 2:");
        s2.readInput();
        /*
        if(s1.equals(s2)){System.out.println("Species 1 is the same as Species 2!");}
        else{System.out.println("Species 1 is differant than Species 2");}
        */
        if(s1.greaterPop(s2)){System.out.println("Species 1 IS greater than Species 2! (s1.greaterPop(s2)=ture");}
        else{System.out.println("Species 1 is NOT greater than Species 2  (s1.greaterPop(s2)=false");}
    }
}
