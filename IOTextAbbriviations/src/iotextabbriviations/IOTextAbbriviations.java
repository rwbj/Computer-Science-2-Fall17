/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotextabbriviations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Text messaging is a popular means of communication. 
 * Many abbreviations are in common use but are not appropriate for formal communication. 
 * Suppose the abbreviations are stored, 
 *      one to a line, 
 * Write a program that will 
 *      read a message 
 *      from another text file and 
 *      surround each occurrence of an abbreviation with <> brackets. 
 * Write the marked message to a new text file.
 *      in a text file named abbreviations.txt.
 * 
 * @author Robert
 */
public class IOTextAbbriviations {
    
    private static String message = "";
    private static String[] abbrivList;
    private static File abbrivListFile = new File("abbreviations.txt");
    private static File messageFile = new File("message.txt");
    private static File returnMessageFile = new File("returnedMessage.txt");

    public static void main(String[] args) throws FileNotFoundException {
        setAbbriv(readFileList(abbrivListFile));
        //System.out.println("tests:");
        //for (String s:abbrivList){System.out.println(s);}
        //System.out.println(abbrivList.toString());
        //System.out.println(message);
        //System.out.println("enter text:");
        //setMessage(inputString());
        //System.out.println(addTags(message,abbrivList));
        System.out.println("list of abbriviations:\n" + Arrays.toString(abbrivList));
        setMessage(readFile(messageFile));
        System.out.println("\nmessage in file:\n" + message);
        writeFile(returnMessageFile,addTags(message,abbrivList));
        System.out.println("\nmessage with tags:\n" + addTags(message,abbrivList));
    }
        
    public static String addTags(String toTag, String[] abbriv){
        //String postTag = preTag;
        //String s = preTag.toLowerCase();
        for(String a:abbriv)
            if(toTag.contains(a)){
                toTag = toTag.replaceAll(a, "<" + a + ">");
            }
        return toTag;
    }
    
    public static String[] readFileList(File fileIn){
        String in = "";
        try{
            Scanner inputStream = new Scanner(fileIn);
            while(inputStream.hasNextLine()){
                in = in + inputStream.nextLine()+ "<thisiswereyousplitthelistitems>";
            }
            inputStream.close();
            //System.out.println("list in string" + in);
            return in.split("<thisiswereyousplitthelistitems>");
        }
        catch(Exception e){
            System.out.println("error in getting string array from file:\t" + e.getMessage());
            exit(0);
            return new String[] {""};
        }
    }
    
    public static String readFile(File fileIn){
        String in = "";
        try{
            Scanner inStm = new Scanner(fileIn);
            while(inStm.hasNextLine()){
                in = in + inStm.nextLine();
            }
            inStm.close();
            return in;
        }
        catch(Exception e){
            System.out.println("error in getting message from file:\t" + e.getMessage());
            exit(0);
            return "";
        }
    }
    
    public static void writeFile(File fileName, String outStr){
        try{
            PrintWriter outStm = new PrintWriter(fileName);
            outStm.print(outStr);
            outStm.close();
        }
        catch(Exception e){
            System.out.println("error in setting message of file:\t" + e.getMessage());
            exit(0);
        }
    }
        
    public static void setAbbriv(String[] newAbbrivList){
        abbrivList = newAbbrivList;
    }
    
    public static void setMessage(String newMessage){
        message = newMessage;
    }
    
    public static String inputString(){
        return new Scanner(System.in).nextLine();
    }
    
}