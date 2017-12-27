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
public class SSNLengthException extends Exception{
    public SSNLengthException(){
        super();
    }
    public SSNLengthException(String message){
        super(message);
    }
}
