package ActionItems;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Reusable_Library.Reusable_Annotations.driver;
import static Reusable_Library.Reusable_Annotations.logger;

public class ai_111022_Class1 extends Reusable_Annotations{

   @Test(priority = 1)
    public void TC1_BookAFlight() throws InterruptedException {
       driver.navigate().to("https://www.jetblue.com");
        Thread.sleep(2000);
       //ReusableActions_Loggers.clickAction(driver, "//a[text()='Accept All Cookies']", logger, "PopUp");
       ReusableActions_Loggers.clickAction(driver,"//*[@id='jb-autocomplete-1-search']", logger, "fromBox");
       ReusableActions_Loggers.clearAction(driver,"//*[@id='jb-autocomplete-1-search']", logger, "fromBox");
       ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='jb-autocomplete-1-search']", "Boston", logger, "fromBox");
       Thread.sleep(3000);
       ReusableActions_Loggers.clickAction(driver,"//*[@id='jb-autocomplete-1-option-item-0']", logger, "clickLocation");

       ReusableActions_Loggers.clickAction(driver, "//*[@id='jb-autocomplete-2-search']", logger, "toBox");
       ReusableActions_Loggers.sendKeysAction(driver, "//*[@id='jb-autocomplete-2-search']", "New York", logger, "toBox");
       ReusableActions_Loggers.clickAction(driver, "//*[@id='jb-autocomplete-2-option-item-2']", logger, "toBox");

       ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='flex flex-column relative']", 0, logger, "departBox");
       Thread.sleep(1000);
       ReusableActions_Loggers.clickAction(driver, "//*[@aria-label='depart Thursday, December 1, 2022']", logger, "departDate");
       Thread.sleep(1000);
       ReusableActions_Loggers.clickAction(driver, "//*[@aria-label='return Thursday, December 22, 2022']", logger, "arriveDate");
       ReusableActions_Loggers.clickAction(driver, "//*[@class='grid-submit-button']", logger, "SearchFlightButton");
       Thread.sleep(5000);
   }//end of test 1






}//end of class
