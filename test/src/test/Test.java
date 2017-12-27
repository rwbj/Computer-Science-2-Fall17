/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Robert
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TextObj n;
        //System.out.println("n =" + n);
        n = new TextObj();
        System.out.println("n =" + n.y);
        n.y = 2;
        System.out.println("n =" + n.y);
        TextObj x;
        x = n;
        n.y = 1;
        /*x = new TextObj();
        x.y = n.y;
        n.y = n.y + 1;//*/
        System.out.println("x =" + x.y);
        System.out.println("n =" + n.y);
        
        char c = 'a';
        System.out.println(Integer.valueOf(c));
        System.out.println(n.getCharY());
        
        
    }
    
}
