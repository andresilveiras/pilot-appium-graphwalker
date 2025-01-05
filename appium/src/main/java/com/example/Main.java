package com.example;

import java.io.IOException;

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