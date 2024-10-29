package com.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    public static void main(String[] args) throws IOException{

        // Open the SUT via appium
        
        try{
            DriverRunner.getDriver();
        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

        // Run Tests
        
        Executor executor = new TestExecutor(MainTest.class);

        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
    }
}