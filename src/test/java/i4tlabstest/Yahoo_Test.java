package i4tlabstest;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;



public class Yahoo_Test {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver before test
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void YahooTest() throws InterruptedException {

        // Task 01-------------------------------------------------------------------------
        // Navigate to the Yahoo website and maximize the browser
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        // Click on More option 
        POM_YahooPage.moreOption(driver).click();

        // wait
        Thread.sleep(3000);

        //Task 02 and 03-------------------------------------------------------------------------
        
         String getAllText= POM_YahooPage.moreOptionPanel(driver).getText();
        //System.out.println(getAllText);
        
        String[] words = getAllText.split("\\s+"); // Split the word list

        int countwords = 0;
        for (String word : words) {
            if (word.startsWith("Y")){ // Consider only words starts with Y
                countwords++;
            }
        }
        
        System.out.println("Number of items under Y category: " + countwords);


        // Task 04-------------------------------------------------------------------------------
        WebElement ySectionSize =POM_YahooPage.yPanel(driver);
        Dimension dim=ySectionSize.getSize();
        System.out.println("Size of the Y category list height and width : "+ dim);
    

        // Search something on the yahoo search bar and check the results ---------Task 05/06----
        POM_YahooPage.homeButton(driver).click(); // click on the home button 
      
        POM_YahooPage.searchBar(driver).sendKeys("Google"); // search the word in search bar
        POM_YahooPage.searchButton(driver).click();
        Thread.sleep(3000);

        List<WebElement> searchResults = POM_YahooPage.yahooSearchResults(driver);  // take the all the results into a list 
        String searchQuery = "Google";

         boolean isSearchResultPresent = searchResults.stream().anyMatch(result -> result.getText().contains(searchQuery)); // check wheather the search results contains the search word
        // once the search results is present  then asset will true and pass the test. 
        Assert.assertTrue(isSearchResultPresent);


    }

   

    @AfterMethod
    public void closebrowser() {
        // Close browser after each test
        driver.quit();
    }
}
