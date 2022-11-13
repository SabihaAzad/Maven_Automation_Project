package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Loggers {

    static int timeout = 10;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-fullscreen");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clearAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            logger.log(LogStatus.PASS, "Successfully cleared element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to clear element : " + elementName + "for reason" + e);
        }//end of catch
    }//end of clear method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to click on element : " + elementName + "for reason" + e);
        getScreenShot(driver, elementName, logger);
        }//end of catch
    }//end of click Action method

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on element by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to click on element by index : " + elementName + "for reason" + e);
        }//end of catch
    }//end of click action by index

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hovered over element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to hover over element : " + elementName + "for reason" + e);
        }//end of catch
    }//end of mouse hover

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            //verify the element successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to send keys to : " + elementName + "for reason" + e);
        }//end of catch
    }//end of send keys action method

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture a text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for :" + elementName + "for reason" + e);
        }//end of catch
        return textOutput;
    }//end of Get Text Action

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }//end of conditional statements
    }//end of compareExpectedAndActualText


    public static String getTextActionByIndex(WebDriver driver, String xpath, int number, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            ArrayList <WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            textOutput = element.get(number).getText();
            logger.log(LogStatus.PASS, "Successfully capture a text by index on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text by index for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to get text by index : " + elementName + "for reason" + e);
        }//end of catch
        return textOutput;
    }//end of Get Text Action By Index

        public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.submit();
                logger.log(LogStatus.PASS, "Successfully submit on " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL, "Unable to submit on element: " + elementName + "for reason" + e);
            }//end of catch
        }//end of submit action

    public static void selectByText(WebDriver driver, String xpath, String userData, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userData);
            logger.log(LogStatus.PASS, "Successfully selected element by text " + elementName);
        }catch(Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select visible text for : " + elementName + "for reason" + e);
        }//end of catch
    }//End of select by visible text

    public static void selectByValue(WebDriver driver, String xpath, String value, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(value);
            logger.log(LogStatus.PASS, "Successfully selected element by value " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select by value: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select element by value : " + elementName + "for reason" + e);
        }//end of catch
    }//end of select by value

    public static void selectByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(index);
            logger.log(LogStatus.PASS, "Successfully selected element by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select by index: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select element by value for : " + elementName + "for reason" + e);
        }//end of catch
    }//end of select by index method

    public static void switchToTabByIndex(WebDriver driver, int index) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
         }//end of switchToTabByIndex

    public static void scrollByView(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch(Exception e) {
            System.out.println("Unable to scroll by view..." + elementName + e);
        }//end of catch
    }//end of scrollByView Method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of catch
    }//end of getScreenshot method


    }//end of class
