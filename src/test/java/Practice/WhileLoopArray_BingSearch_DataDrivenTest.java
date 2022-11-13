package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class WhileLoopArray_BingSearch_DataDrivenTest {

    public static void main(String[] args) throws InterruptedException {

        String [] sports = new String[]{"Basketball","tennis","Soccer"};

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();


        int i=0;

        while (i< sports.length) {


            //navigate to the google site
            driver.navigate().to("https://www.bing.com");

            //maximize my window
            //for mac
            driver.manage().window().fullscreen();

            //sleep statement
            Thread.sleep(3000);

            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports[i]);
            //hit submit on the bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("My favorite sports are " + sports[i] + " and the search number is " + splitResult[0]);

            i++;

        }//end of while loop

        //quit the driver to end the session
        driver.quit();


    }// end of main
}//end of java class
