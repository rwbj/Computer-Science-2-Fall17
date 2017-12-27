/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

/**
 *
 * @author Robert
 */
public interface MessageDecoder {
    public abstract String decode(String cipherText);
}
