/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpt310assignment5;

/**
 *
 * @author home
 */
import java.io.*;
import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
         System.out.println("Please enter the sentense ");
        Scanner scan=new Scanner(System.in);
        
       String sentense=scan.nextLine();
       
      // double num=Math.log10(0.0000000000000000000046465555);
     //  System.out.println(num);
               
       
       
      Correct co=new Correct();
       
       co.start(sentense);
    //  co.printWord();
      co.printSequence();
       //co.print();
      
    }

}
