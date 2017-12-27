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
public class SalesAssociate {
    private String name;
    private double sales;
    
    public String getName(){
        return name;
    }
    
    public double getSales(){
        return sales;
    }
    
    public void setName(String newName){
        name = newName;        
    }
    
    public void setSales(double newSales){
        sales = newSales;
    }
}
