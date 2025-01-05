package com.example.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListNotes extends BasePage {

    // PAGE ELEMENTS:

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Notepad\")")
    RemoteWebElement mainScreenTitle;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(3)")
    RemoteWebElement addButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(3)")
    RemoteWebElement firstNoteOption;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Nenhuma nota encontrada\")")
    RemoteWebElement emptyListNotesLabel;

    // Driver instanciation

    public ListNotes(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS:

    // Check if the list notes is empty --> Stay in the same page

    public boolean IsListNotesEmpty(){
        System.out.println("Checking if the list notes is empty... ");
        if(mainScreenTitle.isDisplayed()){
            if(emptyListNotesLabel.isDisplayed()){
                System.out.println("The list is empty.");
            }else{
                System.out.println("The list is not empty.");
            }
            return emptyListNotesLabel.isDisplayed();
        }else{
            System.out.println("Action failed. Please go to home screen to check list notes.");
            return false;
        }
    }

    // Create new note --> Go to create note

    public CreateNote CreateNewNote(){
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Clicking on New Note button");
            addButton.click();
        }else{
            System.out.println("Action failed. Please go to home screen to create a note.");
        }
        return new CreateNote(d);
    }

    // Select Note --> Go to NOTE DETAILS

    public NoteDetails SelectFirstNote(){
        if(IsListNotesEmpty()){
            System.out.println("Selecting the first note...");
            firstNoteOption.click();
        }else{
            System.out.println("Action failed.");
        }
        return new NoteDetails(d);
    }
}
