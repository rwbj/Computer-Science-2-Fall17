/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Robert
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        //file object
        File fileObject = new File(fileName);
        boolean fileOK = false;
        //checking file accessability
        while (!fileOK)
        {
      	if  (!fileObject.exists())//if does NOT exits
            System.out.println("No such file");
        else if (!fileObject.canRead())//if can't read
            System.out.println("That file is not readable.");
	else
	    fileOK = true;
        if (!fileOK)
        {
            System.out.println("Enter file name again:");
            fileName = keyboard.next();
            fileObject = new File(fileName);
        }
    }
    Scanner inputStream = null;
    System.out.println("The file " + fileName + "\ncontains\n");
    try
    {
        inputStream = new Scanner( new File(fileName));
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Error opening the file " + fileName);
       	System.exit(0);
    }   
       while (inputStream.hasNextLine())
    {
	String line = inputStream.nextLine();
	System.out.println(line);
    }
    inputStream.close();
    
    /*
    prints the path name and 
    the length of the file
    Determines whether the file can be read from and 
    written to
    deletes the file
    */
    System.out.println("path of file: "+fileObject.getPath());
    System.out.println("size of file: " + fileObject.length());
    System.out.println("readable: "+fileObject.canRead()+"\twritable: " + fileObject.canWrite());
    System.out.println("deleting file");
    //fileObject.delete();
    
    }
}
