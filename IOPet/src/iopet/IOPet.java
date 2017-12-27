/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iopet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* 7. 
* Revise the class Pet, as shown in Listing 6.1 of Chapter 6, 
*   so that it is serializable. 
* Write a program that allows you to 
*   write and 
*   read objects of type Pet to a file. 
* The program should ask the user whether to write to a file or read from a file. In either case, 
* the program next asks for the file name. 
* A user who has asked to write to a file can enter as many records as desired. 
* A user who has asked to read from a file is shown all of the records in the file. 
*   Be sure that the records do not scroll by so quickly that the user cannot read them. (Hint: Think of a way to pause the program after a certain number of lines are displayed.)
*/
public class IOPet implements Serializable{
    /*
    OVER COMPICATED
    ALL YOU NEED TO DO TO ADD A PET IS
    READ FROM FILE TO SAVE WHAT IS IN THERE (METHOD FOR THAT?) AND
    THEN WRITE TO THE FILE ADDING THE NEXT PET TO THE END.
    WHEN YOU READ FROM THE FILE AS AN ARRAY OF TYPE PET
    THE ARRAY WILL GENERATE ITSELF!
    */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //Pet[] pets = {}; // this is not used
        char o = 'n';
        String fileName = "";
        do{
            System.out.println("type read or write");
            o = new Scanner(System.in).next().charAt(0);
        }while(!(o=='r' || o=='R' || o=='w' || o=='W'));
        if( o=='r' || o=='R' ){
            System.out.println("enter the file name to read from");
            fileName = new Scanner(System.in).next();
            /*pets = readPets(fileName);//this version will save the file's array in to a local var (can write to a file)
            printPets(pets);//*/
            printPets(readPets(fileName));
        }
        else if( o=='w' || o=='W' ){
            /*char o2 = 'y';// this segment has been moved to the writePets() method
            do{
                //pets = addPet(pets);
                do{
                    System.out.println("do you want to add a pet? (yes/no)");
                    o2 = new Scanner(System.in).next().charAt(0);
                }while(!(o2=='y' || o2=='Y' || o2=='n' || o2=='N'));
            }while(o2=='y' || o2=='Y');//*/
            System.out.println("enter the file name to write to");
            fileName = new Scanner(System.in).next();
            writePets(fileName);
        }
        else{
            System.out.println("error in selection");
            exit(0);
        }
    }
    
    private static void printPets(Pet[] pets) throws InterruptedException{
        try{
            for(Pet p:pets){
                p.writeOutput();
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(1500);
            }
        }catch(Exception e){}
    }
    
    private static Pet[] addPet(Pet[] current){
        Pet[] temp = new Pet[current.length+1];//creates an array 1 larger than before
        for (int i = 0; i < current.length; i++){
            temp[i] = current[i];
        }
        temp[temp.length-1] = new Pet(inName(),inAge(),inWeight());
        return temp;
    }
    
    private static Pet[] readPets(String fileName) throws IOException, ClassNotFoundException{
        Pet[] filePets = new Pet[32];
        ObjectInputStream inStm;
        try {
            inStm = new ObjectInputStream(new FileInputStream(fileName));
            for(int i = 0; i<filePets.length; i++){
                filePets[i] = (Pet)inStm.readObject();
                /*Pet tempArr[] = filePets.clone();
                filePets = new Pet[filePets.length+1];//
                for(int j = 0; j<tempArr.length;j++){
                     filePets[j] = tempArr[j];
                }
                filePets[i] = temp;//*/
            }
            inStm.close();
        }
        catch (Exception e){System.out.println(e.getMessage());}
        return filePets;
    }
    
    private static void writePets(String fileName) throws FileNotFoundException, IOException{
        try{
            ObjectOutputStream outStm = new ObjectOutputStream(new FileOutputStream(fileName));
            
            
            //copied from the main() method
            char o2 = 'y';
            do{
                //pets = addPet(pets);
                do{
                    System.out.println("do you want to add a pet? (yes/no)");
                    o2 = new Scanner(System.in).next().charAt(0);
                }while(!(o2=='y' || o2=='Y' || o2=='n' || o2=='N'));
                Pet p = new Pet(inName(),inAge(),inWeight());
                outStm.writeObject(p);
            }while(o2=='y' || o2=='Y');
            
            
            //outStm.writeObject(petArr); //this is not used
            //outStm.flush();
            outStm.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private static int inAge(){
        System.out.println("enter age:");
        try{
            return new Scanner(System.in).nextInt();
        }
        catch(Exception e){
            return 0;
        }
    }
    
    private static String inName(){
        System.out.println("enter name");
        try{
            return new Scanner(System.in).nextLine();
        }
        catch(Exception e){
            return "N/A";
        }
    }
    
    private static double inWeight(){
        System.out.println("enter weight");
        try{
            return new Scanner(System.in).nextDouble();
        }
        catch(Exception e){
            return 0.0;
        }
    }
}
