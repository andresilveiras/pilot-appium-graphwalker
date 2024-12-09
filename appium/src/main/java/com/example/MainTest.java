package com.example;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import io.appium.java_client.android.AndroidDriver;


@GraphWalker(value = "random(edge_coverage(100))")
public class MainTest extends ExecutionContext implements NotepadTest{

    AndroidDriver driver;
    Navigation navigation = new Navigation();

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */

   @Override
    public void v_Start() {

        System.out.println("I'm on vertex START");

        try{
            driver = DriverRunner.getDriver();
        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

        /*
        try{
            driver = DriverRunner.getDriver();

            this.driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Clicked to close the introduction window");

            this.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Notepad\"]"));
            System.out.println("Found title Notepad");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
            */

    }

    @Override
    public void v_NewNote(){

        System.out.println("I'm on vertex NEW NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.CreateNewNote();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_ListNotes(){

        System.out.println("I'm on vertex LIST NOTES");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.IsListNotesEmpty();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }


    @Override
    public void v_NoteDetails(){

        System.out.println("I'm on vertex NOTE DETAILS");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_NoteEdition(){

        System.out.println("I'm on vertex NOTE EDITION");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.EditNote();

        }catch(MalformedURLException exc){
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
    public void e_ViewListNotes(){

        System.out.println("I'm on edge VIEW LIST NOTES");

        try{
            driver = DriverRunner.getDriver();
            
            navigation.CheckFirstDialog();
            navigation.IsListNotesEmpty();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_CreateNote(){

        System.out.println("I'm on edge CREATE NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.CreateNewNote();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_GoBackFromCreation(){

        System.out.println("I'm on edge GO BACK FROM CREATION");

        try{
            driver = DriverRunner.getDriver();
    
            navigation.CheckFirstDialog();
            navigation.CreateNewNote();
            navigation.GoBack();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DiscardNewNote(){

        System.out.println("I'm on edge DISCARD NEW NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.CreateNewNote();
            navigation.DiscardChanges();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveNewNote(){

        System.out.println("I'm on edge SAVE NEW NOTE");

        try{
            driver = DriverRunner.getDriver();

            String text = "Teste 1";
            navigation.CheckFirstDialog();
            navigation.CreateNewNote();
            navigation.EnterText(text);
            navigation.SaveChanges();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    // Note Details

    @Override
    public void e_SelectNote(){

        System.out.println("I'm on edge SELECT NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_GoBackFromDetails(){
        
        System.out.println("I'm on edge GO BACK FROM DETAILS");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.GoBack();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteSelectedNote(){
        
        System.out.println("I'm on edge DELETE SELECTED NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.DiscardChanges();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_EditNote(){
        
        System.out.println("I'm on edge EDIT NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.EditNote();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }


    // Note Edition

    @Override
    public void e_GoBackFromEdition(){
        
        System.out.println("I'm on edge GO BACK FROM EDITION");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.EditNote();
            navigation.GoBack();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DeleteEditedNote(){
        
        System.out.println("I'm on edge DELETE EDITED NOTE");

        try{
            driver = DriverRunner.getDriver();

            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.EditNote();
            navigation.DiscardChanges();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveEditedNote(){
        
        System.out.println("I'm on edge SAVE EDITED NOTE");

        try{
            driver = DriverRunner.getDriver();

            String text = "Teste 2";
            navigation.CheckFirstDialog();
            navigation.SelectNote();
            navigation.EditNote();
            navigation.EnterText(text);
            navigation.SaveChanges();

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

}
