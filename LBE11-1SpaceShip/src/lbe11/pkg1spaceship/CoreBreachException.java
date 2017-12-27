/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbe11.pkg1spaceship;

/**
 *
 * @author Robert
 */
public class CoreBreachException extends Exception{
    public CoreBreachException(){
        super("Core Breach! Evaluate ship!");
    }
    public CoreBreachException(String message){
        super(message);
    }
}
