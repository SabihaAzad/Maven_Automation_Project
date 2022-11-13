package ActionItems;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ai_10202022 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> zipCode = new ArrayList<>();

        zipCode.add("11217");
        zipCode.add("10305");
        zipCode.add("10016");

        //Declaring a chromedriver
        WebDriverManager.chromedriver().setup();
        //defining ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //adding pre-condition for incognito mode
        options.addArguments("incognito");
        //defining the chromedriver as driver and adding the chrome options
        WebDriver driver = new ChromeDriver(options);

        for(int i=0; i<zipCode.size(); i++){

            //navigating the driver to weight watchers website (find a workshop)
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            Thread.sleep(2000);

            //asking the driver to open up fullscreen when launching
            driver.manage().window().fullscreen();

            Thread.sleep(2000);

         driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();

         WebElement zipSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
                 zipSearch.click();
                 zipSearch.clear();
                zipSearch.sendKeys(zipCode.get(i));

      driver.findElement(By.xpath("//*[@class='ww button primary cta-1JqRp']")).click();

         Thread.sleep(4000);

            //creating an array list and defining the WebElement variable
            ArrayList<WebElement> location = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

            if(i==0) {
                location.get(0).click();
            } else if(i==1) {
               location.get(1).click();
            } else if(i==2) {
                location.get(2).click();
            }//end of conditional statements

            Thread.sleep(3000);

            String address = driver.findElement(By.xpath("//*[contains(@class,'infoContainer-12kv1')]")).getText();

            String[] addressSplit = address.split("\\R");
            System.out.println(addressSplit[1] + " " + addressSplit[2]);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,600)");

            Thread.sleep(2000);

            //capture chart
            String chart = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainerMobile-1RfmF')]")).getText();
            System.out.println(chart);

        }//end of for loop

        //quit chrome
        driver.quit();

    }//end of class
}//end of main
