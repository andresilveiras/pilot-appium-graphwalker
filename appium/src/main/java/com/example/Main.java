package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/*
 * First project of mobile application test automation using MBT (Model-Based Test)
 * Automation tool: Appium (v 2.12.0)
 * MBT Tool: GraphWalker (v4.3.3)
 * 
 * Author: André Silveira
 */

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args){

        // Open the SUT via appium
        
        try{
            appiumSetup();
        }catch(Exception exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

        // Test Cases

    }
    
    /* 
     * ******************************************* 
     * CLASS OF SETUP CAPABILITIES FOR APPIUM V2
     * ******************************************* 
     */

    public static void appiumSetup() throws MalformedURLException{

        // Define variables for appium device capabilities

        String deviceName = "moto g(20)";
        String deviceUdid = "0076732961";
        String deviceOS = "Android";
        String deviceOSVersion = "11";
        String deviceAutomation = "uiautomator2";

        // Now the SUT - system under test - capabilities

        //this is the path of where the SUT is located in your machine, not in the device
        String appPath = "Documents/GitHub/appium/appium/src/main/resources/notepad.apk";
        String appPackage = "com.farmerbb.notepad";
        String appActivity1 = "com.farmerbb.notepad.android.NotepadActivity";

        String appiumServerURL = "http://127.0.0.1:4723";

        // Setting up the capabilities

        UiAutomator2Options capability = new UiAutomator2Options()

        // DEVICE SETUP
        .setDeviceName(deviceName)
        .setUdid(deviceUdid)
        .setAutomationName(deviceAutomation)
        .setPlatformName(deviceOS)
        .setPlatformVersion(deviceOSVersion)

        // SUT SETUP
        .setApp(appPath)
        .setAppPackage(appPackage)
        .setAppActivity(appActivity1);

        // Connect Capabilities to Appium Server
        URL url = new URL(appiumServerURL);
        AndroidDriver driver = new AndroidDriver(url, capability);

        // Print when the SUT is oppened up successfully by appium :)
        System.out.println("Application started!");

    }

}
