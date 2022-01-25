package com.todomvc.tests;

import com.todomvc.pages.PolymerPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.security.Key;

public class PolymerTest extends TestBase {

    PolymerPage polymerPage= new PolymerPage();

    @Test
    public void test1(){
        polymerPage.getTab("JavaScript").click();
        polymerPage.getLink("Polymer").click();
        String toDoItem1= "My first to do item";
        String toDoItem2= "My second to do item";

        polymerPage.inputBox.sendKeys(toDoItem1+ Keys.ENTER);
        polymerPage.inputBox.sendKeys(toDoItem2+Keys.ENTER);
        Assert.assertTrue(polymerPage.createdItemElement(toDoItem1).isDisplayed(),"My first todo item not created");
        Assert.assertTrue(polymerPage.createdItemElement(toDoItem2).isDisplayed(),"My second todo item not created");

        WebElement btnForChanging = polymerPage.createdItemElement(toDoItem2);
        actions.doubleClick(btnForChanging).perform();

        for (int i = 0; i < toDoItem2.length(); i++) {
            polymerPage.editBox.sendKeys(Keys.BACK_SPACE);

        }

        String changedItem="I have change second Item";
        polymerPage.editBox.sendKeys(changedItem+Keys.ENTER);

        Assert.assertTrue(polymerPage.createdItemElement(changedItem).isDisplayed(), "my second tem not changed");



    }
}
