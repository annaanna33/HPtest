import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRSearchInGoogleTest {
    private WebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;



    @Test
    public void searchInGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

 // navigate to google.com

        driver.get ("http://google.com");

//  type "Happy Returns" in the search field
WebElement searchField = driver.findElement(By.xpath("//*[@class = 'gLFyf gsfi']"));
searchField.sendKeys("Happy Returns");

searchField.sendKeys(Keys.ENTER);


// Get for all non-ad links on search result page. Since we use findElement instead of findElements, it will get the first
// element from the list.
var links = driver.findElement(By.cssSelector(".r>a"));
links.click();

// get Title of the webpage opened by clicking the first link on the page
var title = driver.getTitle();

//Assert that the page opened is Happy Returns 

Assert.assertEquals(title, "Happy Returns makes returns beautiful for retailers, shoppers, and the planet with software and reverse logistics");


        Thread.sleep(7000);
        driver.quit();



    }


}
