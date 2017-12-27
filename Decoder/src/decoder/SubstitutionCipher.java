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

public class SubstitutionCipher implements MessageDecoder, MessageEncoder {

    private final int shift;
    
    //constructor
    SubstitutionCipher(){
        shift = -1;
    }//*/
    
    SubstitutionCipher(int shiftValue){
        if(((Object)shiftValue instanceof Integer)){
            if(shiftValue < -20){
                shift = -20;
            }
            else if(shiftValue > 20){
                shift = 20;
            }
            else{
                shift = shiftValue;
            }
        }
        else{
            shift = -1;
        }
    }//*/
    
    @Override
    public String decode(String cipherText) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        char[] c = cipherText.toCharArray();
        for(int i = 0; i<c.length; i++){
            c[i] = (char) (c[i]-shift);
        }
        return String.valueOf(c);
    }//*/
    
    @Override
    public String encode(String plainText) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        char[] c = new char[plainText.length()];
        for (int i = 0; i < plainText.length();i++){
            c[i] = (char) (plainText.charAt(i)+shift);
        }
        return String.valueOf(c);
    }//*/
}
