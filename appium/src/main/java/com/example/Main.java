package com.example;

/*
 * First project of mobile application test automation using MBT (Model-Based Test)
 * Automation tool: Appium (v 2.12.0)
 * MBT Tool: GraphWalker (v4.3.3)
 * 
 * Author: André Silveira @ https://github.com/andresilveiras
 */

import java.net.MalformedURLException;

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    public static void main(String[] args){

        // Open the SUT via appium
        
        try{
            DriverRunner.getDriver();
        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

        // Run Tests


        
    }

}
