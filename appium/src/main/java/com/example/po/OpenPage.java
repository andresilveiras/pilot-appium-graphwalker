package com.example.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OpenPage extends BasePage {

    // PAGE ELEMENTS

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bem-vindo ao Notepad!\n"
            + //
            "\n"
            + //
            "Para criar uma nota, clique no botão Nova Nota (sinal de mais).\"]")
    RemoteWebElement firstAccessDialogText;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(2)")
    RemoteWebElement androidDialog;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\")")
    RemoteWebElement closeDialogButton;

    // Driver instanciation

    public OpenPage(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS

    public ListNotes checkFirstDialog() {
        System.out.println("Checking android dialog...");
        System.out.println("first access dialog: " + firstAccessDialogText.isEnabled());
        if (firstAccessDialogText.isDisplayed() || androidDialog.isDisplayed()) {
            System.out.println("Closing android dialog.");
            closeDialogButton.click();
        } else {
            System.out.println("There is no dialog to be closed.");
        }
        return new ListNotes(d);
    }
    
}
