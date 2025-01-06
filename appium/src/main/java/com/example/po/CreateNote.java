package com.example.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateNote extends BasePage {

    // PAGE ELEMENTS

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Nova Nota\")")
    RemoteWebElement newNoteTitle;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Digite para inserir texto\")")
    RemoteWebElement typeText;

    @AndroidFindBy(xpath="//android.widget.EditText")
    RemoteWebElement textField;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement saveButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
    RemoteWebElement trashButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(2)")
    RemoteWebElement androidDialog;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Apagar nota\")")
    RemoteWebElement discardNoteText;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement cancelConfirmationButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement agreeConfirmationButton;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Para editar uma nota salva, toque duas vezes no texto ou clique no botão Editar (lápis)\")")
    RemoteWebElement firstSavedNoteText;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\")")
    RemoteWebElement closeButton;

    // Driver instanciation

    public CreateNote(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS

    // Enter text --> Stay in the same page

    public void EnterText(String text){
        System.out.println("Checking if user is in edit mode...");
        if(typeText.isDisplayed() || textField.isDisplayed()){
            System.out.println("User is in edition mode. Entering text: " + text);
            //textField.click();
            textField.sendKeys(text);
        }else{
            System.out.println("Action failed. Please go to edition mode to enter a text.");
        }
    }

    // Go back --> Go to list notes

    public ListNotes GoBack(){
        System.out.println("Go back from note creation...");
        if(newNoteTitle.isDisplayed()){
            System.out.println("Going back...");
            backButton.click();
        }else{
            System.out.println("New Note title not found."); 
        }
        return new ListNotes(d);
    }

    // Discard -- Cancel confirmation --> Stay in the same page

    public void CancelDiscard(){
        System.out.println("Clicking to discard new note...");
        if(newNoteTitle.isDisplayed()){
            trashButton.click();
            // Checking confirmation dialog
            if(discardNoteText.isDisplayed() || androidDialog.isDisplayed()){
                System.out.println("Canceling discard confirmation...");
                cancelConfirmationButton.click();
            }else{
                System.out.println("Action failed. Discard was not confirmed.");
            }
        }else{
            System.out.println("Action failed. Please select or create a new note to discard them.");            
        }   
    }  

    // Discard -- Confirm discard --> Go to list notes

    public ListNotes DiscardNewNote(){
        System.out.println("Clicking to discard new note...");
        if(newNoteTitle.isDisplayed()){
            trashButton.click();
            // Checking confirmation dialog
            if(discardNoteText.isDisplayed() || androidDialog.isDisplayed()){
                System.out.println("Confirming discard...");
                agreeConfirmationButton.click();
            }else{
                System.out.println("Action failed. Discard was not confirmed.");
            }
        }else{
            System.out.println("Action failed. Please select or create a new note to discard them.");            
        } 
        return new ListNotes(d);
    }    

    // Save --> Go to NOTE DETAILS

    public NoteDetails SaveNewNote(){
        System.out.println("Clicking to save new note...");
        if(newNoteTitle.isDisplayed()){
            saveButton.click();
            // Checking confirmation dialog
            System.out.println("Checking if the android dialog popped up.");
            if(firstSavedNoteText.isDisplayed() || androidDialog.isDisplayed()){
                System.out.println("Closing android dialog...");
                closeButton.click();
            }else{
                System.out.println("Android dialog not displayed.");
            }
        }else{
            System.out.println("Action failed. Please select or create a new note to discard them.");            
        } 
        return new NoteDetails(d);
    }
    
}
