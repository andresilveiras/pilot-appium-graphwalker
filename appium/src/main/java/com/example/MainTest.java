package com.example;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import com.example.po.CreateNote;
import com.example.po.ListNotes;
import com.example.po.NoteDetails;
import com.example.po.NoteEdition;
import com.example.po.OpenPage;

import io.appium.java_client.android.AndroidDriver;

@GraphWalker(value = "random(edge_coverage(100))")
public class MainTest extends ExecutionContext implements NotepadTest {

    AndroidDriver driver;

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
     */
    @Override
    public void v_Start() {

        System.out.println("I'm on vertex START");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            openPage.checkFirstDialog();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void v_NewNote() {

        System.out.println("I'm on vertex NEW NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.CreateNewNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_ListNotes() {

        System.out.println("I'm on vertex LIST NOTES");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_NoteDetails() {

        System.out.println("I'm on vertex NOTE DETAILS");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            listNotes.SelectFirstNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_NoteEdition() {

        System.out.println("I'm on vertex NOTE EDITION");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            NoteDetails selectedNote = listNotes.SelectFirstNote();
            selectedNote.EditNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }


    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
     */
    // New note
    @Override
    public void e_ViewListNotes() {

        System.out.println("I'm on edge VIEW LIST NOTES");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_CreateNote() {

        System.out.println("I'm on edge CREATE NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            listNotes.CreateNewNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_GoBackFromCreation() {

        System.out.println("I'm on edge GO BACK FROM CREATION");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.GoBack();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DiscardNewNote() {

        System.out.println("I'm on edge DISCARD NEW NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.CancelDiscard();
            newNote.DiscardNewNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveNewNote() {

        System.out.println("I'm on edge SAVE NEW NOTE");

        try {
            String text = "Teste 1";
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            newNote.SaveNewNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    // Note Details
    @Override
    public void e_SelectNote() {

        System.out.println("I'm on edge SELECT NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                listNotes.SelectFirstNote(); 
            }            

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_GoBackFromDetails() {

        System.out.println("I'm on edge GO BACK FROM DETAILS");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(!listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
               selectedNote.GoBack();
            }  

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteSelectedNote() {

        System.out.println("I'm on edge DELETE SELECTED NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
               selectedNote.CancelDiscard();
               selectedNote.DiscardNote();
            } 

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_EditNote() {

        System.out.println("I'm on edge EDIT NOTE");

        try {
            String text = "Teste 2";
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
                selectedNote.EditNote();
            } 

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    // Note Edition
    @Override
    public void e_GoBackFromEdition() {

        System.out.println("I'm on edge GO BACK FROM EDITION");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
                NoteEdition noteToEdit = selectedNote.EditNote();
                noteToEdit.GoBack();
            } 

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteEditedNote() {

        System.out.println("I'm on edge DELETE EDITED NOTE");

        try {
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
                NoteEdition noteToEdit = selectedNote.EditNote();
                noteToEdit.CancelDiscard();
                noteToEdit.DiscardNote();
            } 

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveEditedNote() {

        System.out.println("I'm on edge SAVE EDITED NOTE");

        try {
            String text = "Teste 2";
            driver = DriverRunner.getDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotes listNotes = openPage.checkFirstDialog();
            if(listNotes.IsListNotesEmpty()){
                System.out.println("Action failed. There is no note to select.");
            }else{
                NoteDetails selectedNote = listNotes.SelectFirstNote(); 
                NoteEdition noteToEdit = selectedNote.EditNote();
                noteToEdit.EnterText(text);
            } 

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

}
