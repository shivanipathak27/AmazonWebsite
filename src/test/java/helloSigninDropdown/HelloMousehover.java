package helloSigninDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class HelloMousehover {
	    private WebDriver driver;
	    private Actions actions;

	    @BeforeClass
	    public void setUp() {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "chromedriver.com");

	        // Create a new instance of ChromeDriver
	        driver = new ChromeDriver();

	   
	        actions = new Actions(driver);

	        // Navigate to Amazon homepage
	        driver.get("https://www.amazon.ca");
	    }

	    @Test
	    public void testAccountDropdown() {
	        // Find the "Hello, Sign in" element
	        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));

	        // Perform mouse hover action on the element
	        actions.moveToElement(accountElement).perform();

	        
	        // Find and click on the desired option in the drop-down menu
	        WebElement accountListOption = driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
	        accountListOption.click();

	        
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }


}
