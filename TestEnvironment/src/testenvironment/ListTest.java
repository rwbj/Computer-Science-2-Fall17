/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testenvironment;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Robert
 */
public class ListTest{
    public static void main(String args[]){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random rng = new Random();
        for(int i = 0; i<10; i++){
            arrList.add(rng.nextInt(10));
        }
        for(int i = 0; i < 10; i++){
            System.out.println(arrList.get(i));
        }
    }
}
