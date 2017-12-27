/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import java.util.Random;

/**
 *
 * @author Robert
 */
public class EmployeeData {
    
    public static void main(String[] args) throws SSNCharacterException, SSNLengthException{
        //test();
        run();
    }
    
    private static void run()throws SSNCharacterException, SSNLengthException{
        Employee[] em = new Employee[100];
        for (int i = 0; i < em.length; i++){
            em[i] = new Employee();
        }//*/
        int empCount = 0;
        int avg;
        ///do while(still editing)
        boolean editing = true;
        while(editing){
            System.out.println("Choose you function:");
            String option = em[0].inputString();
            ///switch case :pick emp / next emp / last emp / show emp / show all emp
            switch(option){
                
                case "help":
                    System.out.println(""
                            + "next: add next entry\n"
                            + "show: print spesific employee info\n"
                            + "edit: change spesific employee info\n"
                            + "all: print all employee's info\n"
                            + "auto: randomly create employee list (clears all)\n"
                            + "count: show the total number of employees\n"
                            + "exit: ends the program\n"
                            + "help: shows this list\n");
                    break;
                
                case "auto":
                    System.out.print("how many?: ");
                    int amount = em[0].inputInt();
                    if(amount+empCount>em.length){
                        amount = em.length-empCount-1;
                        System.out.println("only filling up to emp#100");
                    }
                    for(int i = 0; i < amount; i++){
                        em[empCount] = new Employee(empCount+1,genName(),Integer.parseInt(genSSN()),genSalary());
                        empCount++;
                    }
                    break;
                    
                case "next":
                    if (empCount<99){
                        System.out.print("enter name: ");
                        em[empCount] = new Employee(empCount+1, em[0].inputString(), genSalary());
                        System.out.print("enter SSN: ");
                        em[empCount].setSSN(em[0].inputString());
                        empCount = empCount+1;
                    }
                    else{
                        System.out.println("Maximum number of employees reached");
                    }
                    break;
                    
                case "count":
                    System.out.println("total count = " + empCount);
                    break;
                    
                case "edit":
                    System.out.print("enter the desired employee's number: ");
                    int id;
                    boolean editExit = false;
                    do{
                        id = em[0].inputInt();
                        if (id == 0) editExit = true;
                        else if (id>empCount || id<0){
                            System.out.println("out of range, try agian: ");
                        }
                        else {
                            editExit = true;
                            System.out.print("enter name: ");
                            em[id-1].setName(em[0].inputString());
                            System.out.print("enter SSN: ");
                            em[id-1].setSSN(em[0].inputString());
                        }
                    }while(!editExit);
                    break;
                    
                case "show":
                    System.out.print("enter the desired employee's number: ");
                    int num;
                    boolean showExit = false;
                    do{
                        num = em[0].inputInt();
                        if (num == 0){
                            showExit = true;
                        }
                        else if (num>empCount || num<1){
                            System.out.println("out of range, try agian: ");
                        }
                        else {
                            showExit = true;
                            avg = getSalAvg(em,empCount);
                            System.out.println("Salary average is " + avg);
                            em[num-1].printOutput();
                            if(em[num-1].getSalary()>=avg){
                                System.out.println(" Salary is ABOVE average");
                                }
                            else{
                                System.out.println(" Salary is BELOW average");
                            }
                        }
                    }while(!showExit);
                    
                    break;
                        
                case "all":
                    avg = getSalAvg(em,empCount);
                    System.out.println("Salary average is " + avg);
                    for (int i = 0; i < empCount; i++){
                        em[i].printOutput();
                        if(em[i].getSalary()>=avg){
                            System.out.println(" Salary is ABOVE average");
                        }
                        else{
                            System.out.println(" Salary is BELOW average");
                        }
                    }
                    break;
                case "exit":
                    editing = false;
                    break;
                default:
                    System.out.println("not a function, try \"help\"");
                    break;
            }
        }
    }
    
    private static int getSalAvg(Employee[] em, int emCount){
        if (emCount<0 || emCount>em.length){emCount=em.length;}
        int sum = 0;
        int count = 0;
        for (int i = 0; i < emCount; i++){
            if (em[i].getSalary()!=0){
                sum = sum + em[i].getSalary();
                count++;
            }
        }
        if (count == 0) return 0;
        else return sum/count;
    }
    
    private static String genName(){
        String s[] = {"Waylon Dalton",
            "Justine Henderson",
            "Abdullah Lang",
            "Marcus Cruz",
            "Thalia Cobb",
            "Mathias Little",
            "Eddie Randolph",
            "Angela Walker",
            "Lia Shelton",
            "Hadassah Hartman",
            "Joanna Shaffer",
            "Jonathon Sheppard"};
        return s[new Random().nextInt(s.length)];
    }
    
    private static int genSalary(){
        return (((new Random().nextInt(5000))*(new Random().nextInt(100))*(new Random().nextInt(100)))/100)+15000;
    }
    
    private static String genSSN(){
        String s = "" + (new Random().nextInt(9)+1);
        for (int i = 0; i < 8; i++){
            s = s + (new Random().nextInt(10));
        }
        return s;
    }
    
    private static void test()throws SSNCharacterException, SSNLengthException{
        Person p = new Person();
        p.printOutput();
        System.out.println();
        Employee e = new Employee(0,"Mike",23500);
        e.printOutput();
        System.out.println();
        System.out.println(e.getSSN());
        e.setSSN(e.inputString());
        e.printOutput();
        System.out.println();
    }
    
}
