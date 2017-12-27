/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5carddraw;

/**
 *
 * @author Robert Jones
 */
public class EmptyDeckException extends Exception{
    public EmptyDeckException(){
        super();
    }
    public EmptyDeckException(String message){
        super(message);
    }
}
