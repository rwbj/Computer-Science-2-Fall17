/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylbe;


/**
 *
 * @author Robert
 */
public class ArrayLBE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SalesAssociate[] sa = new SalesAssociate[3];
        
        for(int i = 0; i < sa.length; i++){
            sa[i] = new SalesAssociate();
            sa[i].setName("Jane Doe");
            sa[i].setSales(5000);
            System.out.println("sales person #" + (i+1) + "'s name: " + sa[i].getName() + ", sales: " + sa[i].getSales());
        }
    }
}
