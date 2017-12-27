/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciessecondtry;
/**
 *
 * @author Robert
 */
public class speciesSecondTryDensity {
    
public static void main(String[] args){
    SpeciesSecondTry speciesPop = new SpeciesSecondTry();
    speciesPop.readInput();
    double density = speciesPop.getDensity();
    System.out.println("the density is " + density);
    }
}
