package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        ArrayList <String> zipCodes = new ArrayList<>();

        zipCodes.add("11217");
        zipCodes.add("11218");
        zipCodes.add("10016");

      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("incognito");
      WebDriver driver = new ChromeDriver(options);

      for(int i=0; i< zipCodes.size(); i++){

      driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
      Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@icon='location']")).click();

        driver.findElement(By.xpath("//*[@id='location-search']")).clear();
        driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCodes.get(i));
        driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();

        Thread.sleep(2000);

    ArrayList<WebElement> workshopName = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

    if(i==0) {
        workshopName.get(1).click();
    } else if(i==1){
        workshopName.get(2).click();
    } else if(i==2) {
        workshopName.get(3).click();
          }//end of conditional statement

          Thread.sleep(3000);

        //capturing the text from the element where the address is in and storing in a string variable
          //or defining a variable for the element where the address is and capturing the text
          String address = driver.findElement(By.xpath("//*[class='infoContainer-12kv1']")).getText();

          //defining a variable for splitting address variable by line. Storing each line from the address variable as an array
          String[] addressSplit = address.split("\\R ");
          System.out.println(addressSplit[1] + " " + addressSplit[2]);

          //scroll down to in-person chart (schedule)
          JavascriptExecutor jse = (JavascriptExecutor) driver;
          jse.executeScript("scroll 0, 600");

          //Capture chart
          String chart = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
          System.out.println(chart);
//*[@class='scheduleContainerMobile-1RfmF'] // i see TWO of them (online and in person schedule, so should it be Elements? and how do i index?

      }//end of for loop

            //quit chrome
          driver.quit();

    }//end of class
}//end of main

//github test test test