package com.example;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


public class Navigation {

    // DEFINING PAGE ELEMENTS

    // Elements of main page and first access dialogs

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Notepad\")")
    RemoteWebElement mainScreenTitle;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Bem-vindo ao Notepad!\n" + //
                "\n" + //
                "Para criar uma nota, clique no botão Nova Nota (sinal de mais).\"]")
    RemoteWebElement firstAccessDialogText;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\")")
    RemoteWebElement closeDialogButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Para editar uma nota salva, toque duas vezes no texto ou clique no botão Editar (lápis)\"]")
    RemoteWebElement firstNoteCreatedDialogText;


    // List Notes Screen

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(3)")
    RemoteWebElement addButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(3)")
    RemoteWebElement firstNoteOption;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Nenhuma nota encontrada\")")
    RemoteWebElement emptyListNotesLabel;


    // Create & Edit Notes Screen

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Digite para inserir texto\")")
    RemoteWebElement editionModeText;

    @AndroidFindBy(xpath="//android.widget.EditText/android.view.View")
    RemoteWebElement textField;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement firstHeaderButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
    RemoteWebElement secondHeaderButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(3)")
    RemoteWebElement moreOptionsHeaderButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Apagar nota\")")
    RemoteWebElement discardNoteText;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement firstDialogButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement secondDialogButton;

    // USER ACTIONS

    public void CheckFirstDialog(){
        System.out.println("Checking android dialog...");
        if(firstAccessDialogText.isDisplayed() || firstNoteCreatedDialogText.isDisplayed()){
            System.out.println("Closing android dialog.");
            closeDialogButton.click();
        }else{
            System.out.println("There is no dialog to be closed.");
        }
    }

    public void CreateNewNote(){
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Clicking on add notes button");
            addButton.click();
        }else{
            System.out.println("Action failed. Please go to home screen to create a note.");
        }
    }

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

    public void EnterText(String text){
        System.out.println("Checking if user is in edit mode...");
        if(editionModeText.isDisplayed() || textField.isDisplayed()){
            System.out.println("User is in edition mode. Entering text: " + text);
            textField.sendKeys(text);
        }else{
            System.out.println("Action failed. Please go to edition mode to enter a text.");
        }
    }

    public void SaveChanges(){
        System.out.println("Clicking to save changes...");
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Action failed. Please edit or create a new note to save changes.");
        }else{
            firstHeaderButton.click();
            CheckFirstDialog();
            System.out.println("Note was saved.");
        }
    }

    public void GoBack(){
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Action failed. Cannot go back from home screen.");
        }else{
            System.out.println("Going back...");
            backButton.click();
        }
    }

    public void SelectNote(){
        System.out.println("Selecting a note...");
        if(!IsListNotesEmpty()){
            System.out.println("Note selected: " + firstNoteOption.getText());
            firstNoteOption.click();
        }else{
            System.out.println("Action failed. Please create at least one note first.");
        }
    }

    public void EditNote(){
        System.out.println("Clicking to edit selected note...");
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Action failed. Please select a note to edit them.");
        }else{
            firstHeaderButton.click();
        }
    }

    public void DiscardChanges(){
        System.out.println("Clicking to discard changes...");

        // Check if user is in home screen
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Action failed. Please select or create a new note to discard them.");
        }else{
            secondHeaderButton.click();

            // Checking confirmation dialog
            if(discardNoteText.isDisplayed()){
                System.out.println("Confirming discard...");
                secondDialogButton.click();
            }else{
                System.out.println("Action failed. Discard was not completed due to lack of confirmation.");
            }
        }
    }

    public void CancelDiscard(){
        System.out.println("Clicking to discard changes...");

        // Check if user is in home screen
        if(mainScreenTitle.isDisplayed()){
            System.out.println("Action failed. Please select or create a new note to discard them.");
        }else{
            secondHeaderButton.click();

            // Checking confirmation dialog
            if(discardNoteText.isDisplayed()){
                System.out.println("Canceling discard confirmation...");
                firstDialogButton.click();
            }else{
                System.out.println("Action failed. Discard was not completed due to lack of confirmation.");
            }
        }
    }  

}
