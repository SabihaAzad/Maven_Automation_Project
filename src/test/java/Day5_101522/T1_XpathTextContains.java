package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to the yahoo homepage
        driver.navigate().to("https://www.yahoo.com");

        //maximize my window for mac
        driver.manage().window().fullscreen();

        //click on the sign in button
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        //wait 2 secs
        Thread.sleep(2000);

        //navigate to the yahoo homepage
        driver.navigate().to("https://www.yahoo.com");

        //wait 1 sec
        Thread.sleep(1000);

        //click on the bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();

        //wait 2 secs
        Thread.sleep(2000);

        //quit chrome
        driver.quit();

    }
}//end of class


