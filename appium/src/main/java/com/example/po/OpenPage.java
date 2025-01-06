package com.example.po;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;


public class OpenPage extends BasePage {

    // Driver instanciation
    public OpenPage(AndroidDriver d) {
        super(d);
        System.out.println("I'm on Open Page");
        if(d == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    RemoteWebElement firstAccessDialogText = (RemoteWebElement)d.findElement(By.xpath("//android.widget.TextView[@text=\"Notepad\"]"));
    RemoteWebElement androidDialog = (RemoteWebElement)d.findElement(By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View"));
    RemoteWebElement closeDialogButton = (RemoteWebElement)d.findElement(By.xpath("//android.widget.Button"));

    // PAGE ACTIONS
    public ListNotesEmpty checkFirstDialog() {
        System.out.println("Checking android dialog...");
        System.out.println("first access dialog: " + firstAccessDialogText.isEnabled());
        if (firstAccessDialogText.isDisplayed() || androidDialog.isDisplayed()) {
            System.out.println("Closing android dialog.");
            closeDialogButton.click();
        } else {
            System.out.println("There is no dialog to be closed.");
        }
        return new ListNotesEmpty(d);
    }
}
