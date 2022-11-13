package ActionItems;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Reusable_Library.ReusableActions.setUpDriver;

public class ai_11032022_reusableMethods_UHC {

        WebDriver driver;
        @BeforeSuite
        public void SetChromeDriver(){
            //calling to setup my chrome driver
            driver = ReusableActions.setUpDriver();
        }//end of set driver method

        @Test(priority = 1)
        public void TestCase1() throws InterruptedException {
                //navigating to UHC website
                driver.navigate().to("https://www.uhc.com");
                //using click action to click on find a doctor link
                ReusableActions.clickAction(driver,"//*[@class='position-relative bg-blueDark color-white display-block width-100 lg-bg-white p-4 size-17 talign-center']", "findADoctor");
                //using scroll to view to go down to find a dentist
                ReusableActions.scrollByView(driver, "//*[@aria-label='Find a dentist Opens a new window']", "findADentist");
                //using click action to click on find a dentist
                ReusableActions.clickAction(driver, "//*[@aria-label='Find a dentist Opens a new window']", "findADentist");
            Thread.sleep(3000);
            //refreshing the page
            driver.navigate().refresh();
            Thread.sleep(3000);
            //switching tabs to work on the newly opened tab
            ReusableActions.switchToTabByIndex(driver,1 );
            //clicking on Employer and Individual Plan
            ReusableActions.clickAction(driver, "//*[text()='Employer and Individual Plans']", "Plan");
        }//end of test case 1

        @Test(priority = 2)
        public void TestCase2() throws InterruptedException {
            //clicking on search bar
            ReusableActions.clickAction(driver, "//*[@id='location']", "clickSearchBar");
            //typing in zipcode in the search bar
            ReusableActions.sendKeysAction(driver, "//*[@name='input']", "11204", "TypeZipCode");
            Thread.sleep(3000);
            //clicking continue after typing in zipcode
            ReusableActions.clickAction(driver, "//*[@type='submit']", "clickContinue");
            //clicking on National Options PPO 30
            ReusableActions.clickAction(driver, "//*[text()='*National Options PPO 30']", "ClickSpecificPlan");
            Thread.sleep(3000);
            //refreshing the page as needed
            driver.navigate().refresh();
            Thread.sleep(3000);
            //clicking on general dentist by index since two of the elements have the same class
            ReusableActions.clickActionByIndex(driver, "//*[@class='sc-TtZnY fogWKQ']",0, "GeneralDentist");
        }//end of test case 2

        @Test(priority = 3)
        public void TestCase3() throws InterruptedException {
            //Select command to select 5 miles from the dropdown menu
            ReusableActions.selectByText(driver, "//*[@id='distance']", "Within 5 Miles", "SelectByText");
            Thread.sleep(3000);
            //using refresh as needed
            driver.navigate().refresh();
            Thread.sleep(3000);
            //calling it again after the refresher
            ReusableActions.selectByText(driver, "//*[@id='distance']", "Within 5 Miles", "SelectByText");
            Thread.sleep(3000);
            //clicking on the first doctor from the list via index since elements are under same class
            ReusableActions.clickActionByIndex(driver, "//*[@class='sc-bXmHAB ITGjV providerName']/a", 0, "FirstDentistName");
            //clicking on save button also via index for elements under the same class
            ReusableActions.clickActionByIndex(driver, "//*[text() = 'Save']", 0, "clickSave");
            //capturing the text and storing into a string variable in order to print later
            String docAddress = ReusableActions.getTextActionByIndex(driver, "//*[@class='td c-4-dt-tbl']", 0, "captureDocAddress");
            //splitting the text from the address so the phone number is not included, by using the R operator \\R to split by line
            String[] docAddresssplit = docAddress.split("\\R");
            //capturing the miles and storing into string variable
            String docMiles = ReusableActions.getTextActionByIndex(driver, "//*[@data-test-id='distance-away']", 1, "captureDocMiles");
            //capturing the network and storing into string variable
            String docNetwork = ReusableActions.getTextActionByIndex(driver, "//*[@class='networkStatus icon-txt fwMed ']", 1, "captureDocNetwork");
            //printing out address, miles, and network
            System.out.println("Address: " + docAddresssplit[1]+ "\n" + docAddresssplit[2] + "\n" + "Miles = " + docMiles + "\n" + "Network = " + docNetwork);
            //close tab
            driver.close();
        }//end of test case 3


    @Test(priority = 4)
    public void TestCase4() {
        //switching back to parent tab
        ReusableActions.switchToTabByIndex(driver,0);
        //Clicking on search bar
        ReusableActions.clickAction(driver, "//*[@id='search-desktop']", "ClickSearchBar");
        //typing in doctor on the search bar
        ReusableActions.sendKeysAction(driver, "//*[@id='search-desktop']", "doctor", "ClickSearchBar");
        //clicking search button
        ReusableActions.clickAction(driver, "//*[@id='search__button-desktop']", "ClickSearch");
        //capturing search results and storing it into a string variable to print later
        String SearchNumbers = ReusableActions.getTextAction(driver, "//*[@class='search-results-count']", "GetTextSearchResult");
        //splitting the search results text in order to only get the numbers
        String[] SearchNumbersSplit = SearchNumbers.split("results");
        //printing the search results
        System.out.println("Search Results = " + SearchNumbersSplit[0]);
    }//end of test case 4

        @AfterSuite
        public void quitTheSession()
        {
           //quitting the driver
           driver.quit();

        }//end of after suite
    }//end of java class
