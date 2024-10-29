package com.example;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


@GraphWalker(value = "random(edge_coverage(100))")
public class MainTest extends ExecutionContext implements NotepadTest{

    AndroidDriver driver = null;

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */

   @Override
    public void v_Start() {

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Notepad\"]"));
            System.out.println("Encontrou o titulo Notepad");
            driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Clicou para fechar a primeira janela");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_ListNotes(){}

    @Override
    public void v_NewNote(){}

    @Override
    public void v_NoteDetails(){}

    @Override
    public void v_NoteEdition(){}


    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */

    // New note

    @Override
    public void e_ViewListNotes(){}

    @Override
    public void e_CreateNote(){}

    @Override
    public void e_GoBackFromCreation(){}

    @Override
    public void e_DiscardNewNote(){}

    @Override
    public void e_SaveNewNote(){}

    // Note Details

    @Override
    public void e_SelectNote(){}

    @Override
    public void e_GoBackFromDetails(){}

    @Override
    public void e_DeleteSelectedNote(){}

    @Override
    public void e_EditNote(){}


    // Note Edition

    @Override
    public void e_GoBackFromEdition(){}

    @Override
    public void e_DeleteEditedNote(){}

    @Override
    public void e_SaveEditedNote(){}

}
