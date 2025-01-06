package com.example;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import com.example.po.CreateNote;
import com.example.po.ListNotes;
import com.example.po.ListNotesEmpty;
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

    }

    @Override
    public void v_NewNote() {

        System.out.println("I'm on vertex NEW NOTE");

    }

    @Override
    public void v_ListNotes() {

        System.out.println("I'm on vertex LIST NOTES");

    }

    @Override
    public void v_NoteDetails() {

        System.out.println("I'm on vertex NOTE DETAILS");

    }

    @Override
    public void v_NoteEdition() {

        System.out.println("I'm on vertex NOTE EDITION");

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
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
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
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
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
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
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
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
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
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
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
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            createdNoteOnList.SelectFirstNote();   

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_GoBackFromDetails() {

        System.out.println("I'm on edge GO BACK FROM DETAILS");

        try {
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            noteToEdit.GoBack();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteSelectedNote() {

        System.out.println("I'm on edge DELETE SELECTED NOTE");

        try {
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            noteToEdit.CancelDiscard();
            noteToEdit.DiscardNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_EditNote() {

        System.out.println("I'm on edge EDIT NOTE");

        try {
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            noteToEdit.EditNote();

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
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            NoteEdition edit = noteToEdit.EditNote();
            edit.GoBack();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteEditedNote() {

        System.out.println("I'm on edge DELETE EDITED NOTE");

        try {
            String text = "Teste 1";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            NoteEdition edit = noteToEdit.EditNote();
            edit.CancelDiscard();
            edit.DiscardNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveEditedNote() {

        System.out.println("I'm on edge SAVE EDITED NOTE");

        try {
            String text1 = "Teste 1";
            String text2 = "Teste 2";
            driver = DriverRunner.createDriver();
            OpenPage openPage = new OpenPage(driver);
            ListNotesEmpty listNotes = openPage.checkFirstDialog();
            listNotes.IsListNotesEmpty();
            CreateNote newNote = listNotes.CreateNewNote();
            newNote.EnterText(text1);
            NoteDetails createdNote = newNote.SaveNewNote();
            ListNotes createdNoteOnList = createdNote.GoBack(); 
            NoteDetails noteToEdit = createdNoteOnList.SelectFirstNote();
            NoteEdition edit = noteToEdit.EditNote();
            edit.EnterText(text2);
            edit.SaveEditedNote();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

}
