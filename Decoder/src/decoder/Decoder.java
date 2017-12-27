/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class Decoder /*implements Comparable*/{

    /*@Override
    public int compareTo(Object o){
        if((o!=null) && (o instanceof String)){
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        run();
        //testZone();
        //microTest();
        
    }
    
    private static void run(){
        Scanner scInt = new Scanner(System.in);//but why!!!
        Scanner scStr = new Scanner(System.in);
        System.out.println("enter the shift value: ");
        int shiftEn = scInt.nextInt();
        System.out.println("enter the shuffle value: ");
        int shuffleEn = scInt.nextInt();
        ShuffleCipher shufC = new ShuffleCipher(shuffleEn);
        SubstitutionCipher subsC = new SubstitutionCipher(shiftEn);
        
        //encoding
        System.out.println("enter a string to encode: ");
        String c = scStr.nextLine();
        c = shufC.encode(c);
        System.out.println("string post shuffle: " + c);
        c = subsC.encode(c);
        System.out.println("string post char shift: " + c);
        
        //decoding
        String m;
        do{
            System.out.println("\nenter the key shift value: ");
            int shiftDe = scInt.nextInt();
            System.out.println("enter the key shuffle value: ");
            int shuffleDe = scInt.nextInt();
            ShuffleCipher shufM = new ShuffleCipher(shuffleDe);
            SubstitutionCipher subsM = new SubstitutionCipher(shiftDe);
            m = subsM.decode(c);
            m = shufM.decode(m);
            System.out.println("decoded message " + m);
            m = shufC.encode(m);
            m = subsC.encode(m);
            if(m.compareTo(c)!=0){
                System.out.println("it looks like your key is not working...\ntry again.");
            }
        }while(m.compareTo(c)!=0);
        
    }
    /*
    private static void testZone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string...");
        String plainText = sc.nextLine();
        String s1;
        String s2;        
        char[] c = new char[plainText.length()];
        char[] c1;
        char[] c2;
        boolean even;
        //int count = 0;
        //if even than split equaly
        if((plainText.length()%2)==0){
            c1 = new char[plainText.length()/2];
            c2 = new char[plainText.length()/2];
            even = true;
            s1 = plainText.substring(0,(plainText.length()/2));
            s2 = plainText.substring(plainText.length()/2,plainText.length());
        }
        //else give the first sring the longer half
        else{
            c1 = new char[(plainText.length()/2)+1];
            c2 = new char[plainText.length()/2];
            even = false;
            s1 = plainText.substring(0,(plainText.length()/2)+1);
            s2 = plainText.substring((plainText.length()/2)+1,plainText.length());
        }
        for(int i =0; i < plainText.length(); i++){
            c[(2*i)] = c1[i];
            if(i<c2.length){
                c[(2*i)+1] = c2[i];
            }
        }
        System.out.println("this is the final answer:\n" + String.copyValueOf(c));
    }
    
    private static void microTest(){
        String plainText = "abcdefg";
        char c1[] = {'a','b','c','d'};
        char c2[] = {'e','f','g'};
        char c[] = new char[plainText.length()];
        //int count = 0;
        for(int i = 0; i < plainText.length()/2+1; i++){
            c[(2*i)] = c1[i];
            //count++;
            if(i<c2.length){
                c[((2*i)+1)] = c2[i];
                //count++;
            }
        }
        System.out.println("this is the final answer:\n" + String.copyValueOf(c) + "\nhalf plainText.length = " + plainText.length()/2);
    }
    */
}
