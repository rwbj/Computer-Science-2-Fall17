/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class Employee extends Person{
    
    private String SSN;
    private int salary;
    private int empNum = 0;

    public Employee() throws SSNCharacterException, SSNLengthException{
        super();
        setSSN("000000000");
        setSalary(0);
    }
    
    public Employee(String initalName) throws SSNCharacterException, SSNLengthException{
        super(initalName);
        setSSN("000000000");
        setSalary(0);
    }
    /*
    public Employee(int initalSSN) throws SSNCharacterException, SSNLengthException{
        super();
        setSSN(""+initalSSN);
        setSalary(0);
    }
    
    public Employee(int initalSSN, int initalSalary) throws SSNCharacterException, SSNLengthException{
        super();
        setSSN(""+initalSSN);
        setSalary(initalSalary);
    }
    
    public Employee(String initalName, int initalSSN, int initalSalary) throws SSNCharacterException, SSNLengthException{
        super(initalName);
        setSSN(""+initalSSN);
        setSalary(initalSalary);
    }
    */
    public Employee(int newEmpNum, String initalName){
        super(initalName);
        empNum = newEmpNum;
        SSN = "000000000";
        salary = 0;
    }
    
    public Employee(int newEmpNum, String initalName, int initalSalary){
        super(initalName);
        empNum = newEmpNum;
        SSN = "000000000";
        salary = initalSalary;
    }
    
    public Employee(int newEmpNum, String initalName,int initalSSN, int initalSalary){
        super(initalName);
        empNum = newEmpNum;
        SSN = "" + initalSSN;
        salary = initalSalary;
    }
    
    public int inputInt(){
        boolean b = true;
        int i = 0;
        do{
            try{
                i = new Scanner(System.in).nextInt();
                b=false;
            }catch(Exception e){
                System.out.println("not int error, try again");
            }
        }while(b);
        return i;
    }
    
    public String inputString(){
        boolean b = true;
        String s = "";
        do{
            try{
                s = new Scanner(System.in).nextLine();
                b = false;
            }catch(Exception e){
                System.out.println("not string error, try again");
            }
        }while(b);
        return s;
    }
    
    @Override
    public void printOutput(){
        System.out.print("Emp#:" + empNum + ", ");
        super.printOutput();
        String SSNP;
        String SalaryP;
        if ("000000000".equals(SSN) || SSN == null || "".equals(SSN)) SSNP = "";
        else SSNP = SSN;
        if (salary == 0) SalaryP = "";
        else SalaryP = ""+salary;
        System.out.print(", SSN:" + SSNP + ", Salary:" + SalaryP);
    }
    
    public String getSSN(){
        return SSN;
    }
    
    public int getSalary(){
        return salary;
    }
    
    public int getEmpNum(){
        return empNum;
    }
    
    public void setSSN(String newSSN) throws SSNCharacterException, SSNLengthException{
        boolean b = true;
        do{
            try{
                if (newSSN.length()!=9){
                throw new SSNLengthException("SSN lenght error");
                }
                for (int i = 0; i < newSSN.length(); i++){
                    if (!Character.isDigit(newSSN.charAt(i))){
                        throw new SSNCharacterException("SSN not digit error");
                    }
                }
                SSN = newSSN;
                b = false;
            }
            catch(SSNLengthException | SSNCharacterException e){
                System.out.println(e.getMessage() + ",you entered  try again...");
                newSSN = this.inputString();
                if (newSSN.equals("break")){b=false;}
            }
        }while(b);
    }
    
    public void setSalary(int newSalary){
        salary = newSalary;
    }
    
    public void setEmpNum(int newEmpNum){
        empNum = newEmpNum;
    }

}
