package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mcalc_Scroll {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the browser
        options.addArguments("start-fullscreen");

        //define the Chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //go to mcalc site
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down to 800 pixels
        jse.executeScript("scroll(0,800)");

        //wait 3 seconds
        Thread.sleep(3000);

        //scroll up 400 pixels
        jse.executeScript("scroll (0,-400)");

        //wait 3 seconds
        Thread.sleep(3000);

        //store calculate button into webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));

        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);

        //wait 2 secs
        Thread.sleep(2000);

        //quit chrome
        driver.quit();

    }//end of main
}//end of java class
