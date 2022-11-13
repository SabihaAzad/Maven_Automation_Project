package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {

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

        //using find elements I want to click on 2nd link within the group which is News
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();

        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropDown = new Select(startMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");

        //use select command for month dropdown
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select startYearDropDown = new Select(startYear);
        //select by visible text
        startYearDropDown.selectByVisibleText("2023");

        //if Select tag is not available, then use .click() after using xpath locator such as:
        //driver.findElement(By.xpath("//*[@name='sy']")).click();
        //driver.findElement(By.xpath("//*[@text()='2023']")).click();


    }//end of main
}//end of java class
