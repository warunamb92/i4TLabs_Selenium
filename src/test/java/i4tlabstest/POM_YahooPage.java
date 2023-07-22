package i4tlabstest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_YahooPage {


   WebElement element=null;

    public static WebElement moreOption(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.id("root_8"));
        return element;
    }

    //public static WebElement yCategory(WebDriver driver)
   // {
  //       WebElement element=driver.findElement(By.id("root_8"));
  //       return element;
 //   }

     public static WebElement homeButton(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.id("uh-tb-home"));
        return element;
    }

    
     public static WebElement searchBar(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.name("p"));
        return element;
    }

    public static WebElement searchButton(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.id("ybar-search"));
        return element;
    }

    public static List<WebElement> yahooSearchResults(WebDriver driver) 
    {
         return driver.findElements(By.id("results"));
    }

     public static WebElement moreOptionPanel(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.id("mrt-node-Col1-0-Everything"));
        return element;
    }

       public static WebElement yPanel(WebDriver driver)
    {
       
        WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/dl[3]"));
        return element;
    }


    

    
  
   



    
}
