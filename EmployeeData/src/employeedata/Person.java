/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

/**
 *
 * @author Robert
 */
public class Person{
    private String name;
    
    public Person(){
        name = "no name set";
    }
    
    public Person(String initalName){
        name = initalName;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean hasSameName(String otherName){
        if (name.equals(otherName)){
            return true;
        }
        else return false;
    }
    
    public void printOutput(){
        System.out.print("name:" + name);
    }
    
}
