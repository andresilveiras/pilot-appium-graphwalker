package com.example;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.interactions.Actions;

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
            System.out.println("Found title Notepad");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_NewNote(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Nova Nota\"]"));
            System.out.println("Found title New Note");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_ListNotes(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Button"));
            System.out.println("Found button search on list notes view");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }


    @Override
    public void v_NoteDetails(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            System.out.println("Found button pencil on note details view");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void v_NoteEdition(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            System.out.println("Found button disquet on note edition view");

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

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Clicked to close the introduction window");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_CreateNote(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.widget.Button")).click();
            System.out.println("Clicked on + button to create a note");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void e_GoBackFromCreation(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")).click();
            System.out.println("Clicked on back button");

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_DiscardNewNote(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
            System.out.println("Clicked on trash button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    @Override
    public void e_SaveNewNote(){

        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//android.widget.EditText/android.view.View")).click();
            new Actions(driver).sendKeys("n").perform();
            System.out.println("Typed something");
            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();
            System.out.println("Clicked on disquet button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }

    }

    // Note Details

    @Override
    public void e_SelectNote(){}

    @Override
    public void e_GoBackFromDetails(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")).click();
            System.out.println("Clicked on back button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void e_DeleteSelectedNote(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
            System.out.println("Clicked on trash button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void e_EditNote(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();
            System.out.println("Clicked on pencil button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }


    // Note Edition

    @Override
    public void e_GoBackFromEdition(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")).click();
            System.out.println("Clicked on back button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void e_DeleteEditedNote(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
            System.out.println("Clicked on trash button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void e_SaveEditedNote(){
        try{
            driver = DriverRunner.getDriver();

            driver.findElement(AppiumBy.xpath("//android.widget.EditText/android.view.View")).click();
            new Actions(driver).sendKeys("s").perform();
            System.out.println("Typed something");
            driver.findElement(AppiumBy.xpath("//z0.h0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();
            System.out.println("Clicked on disquet button");
            

        }catch(MalformedURLException exc){
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }
    }

}
