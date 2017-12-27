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
public class ShuffleCipher implements MessageDecoder, MessageEncoder{
    
    private final int shuffle;

    ShuffleCipher(){
        shuffle = 1;
    }//*/
    
    ShuffleCipher(int shuffleTimes){
        if(((Object)shuffleTimes instanceof Integer) && (shuffleTimes > -1)){
            shuffle = shuffleTimes;
        }
        else{
            shuffle = 1;
        }
    }
    
    @Override
    public String encode(String plainText) {
        String s1;
        String s2;        
        char[] c = new char[plainText.length()];
        boolean even;
        //int count = 0;
        //if even than split equaly
        for(int j = 0; j < shuffle; j++){//do "shuffle" amount of times
            if((plainText.length()%2)==0){
                even = true;
                s1 = plainText.substring(0,(plainText.length()/2));
                s2 = plainText.substring(plainText.length()/2,plainText.length());
            }
            //else give the first sring the longer half
            else{
                even = false;
                s1 = plainText.substring(0,(plainText.length()/2)+1);
                s2 = plainText.substring((plainText.length()/2)+1,plainText.length());
            }
            for(int i =0; i < s1.length(); i++){
                c[(2*i)] = s1.charAt(i);
                if(i<s2.length()){
                    c[(2*i)+1] = s2.charAt(i);
                }
            }
            plainText = String.copyValueOf(c);
        }
        return plainText;
    }
    
    @Override
    public String decode(String cipherText) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int j = 0; j < shuffle; j++){
            char c2[] = new char[cipherText.length()/2];
            char c1[];
            boolean even;
            if(cipherText.length()%2==0){//is even
                c1 = new char[cipherText.length()/2];
            }
            else{//is odd
                c1 = new char[cipherText.length()/2+1];
            }
            int count = 0;
            for (int i = 0; i < c1.length; i++){
                //if(i<c1.length-1){
                    c1[i] = cipherText.charAt(count);
                    count++;
                //}
                if(i<c2.length){
                    c2[i] = cipherText.charAt(count);
                    count++;
                }
            }
            cipherText = String.valueOf(c1)+String.valueOf(c2);
        }
        return cipherText;
    }
}
