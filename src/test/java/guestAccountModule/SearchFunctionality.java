package guestAccountModule;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

		public class SearchFunctionality {
		
		
			    private WebDriver driver;

			    public void setUp() {
			        // Set the path to the ChromeDriver executable
			        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			        
			       
			        ChromeOptions options = new ChromeOptions();
			        options.addArguments("--disable-infobars");
			        options.addArguments("--disable-notifications");

			        // Create a new instance of ChromeDriver
			        driver = new ChromeDriver(options);

			        // Maximize the browser window
			        driver.manage().window().maximize();
			    }

			    public void searchProduct(String searchQuery) {
			        // Navigate to the Amazon homepage
			        driver.get("https://www.amazon.ca");

			        // Find the search input field
			        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));

			        // Enter the search query
			        searchInput.sendKeys(searchQuery);

			        // Submit the search form
			        searchInput.submit();

			       
			        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

			        // Find all the product elements on the search results page
			        List<WebElement> productElements = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

			        
			        for (WebElement productElement : productElements) {
			            WebElement productImage = productElement.findElement(By.xpath(".//img"));
			            String imageUrl = productImage.getAttribute("src");

			            WebElement productName = productElement.findElement(By.xpath(".//span[@class='a-size-medium']"));
			            String name = productName.getText();

			            WebElement productPrice = productElement.findElement(By.xpath(".//span[@class='a-offscreen']"));
			            String price = productPrice.getText();

			          
			            WebElement productRating = productElement.findElement(By.xpath(".//span[@class='a-icon-alt']"));
			            String rating = productRating.getText();

			            WebElement productReviewCount = productElement.findElement(By.xpath(".//span[@class='a-size-base']"));
			            String reviewCount = productReviewCount.getText();

			            // Print the product information
			            System.out.println("Product Name: " + name);
			            System.out.println("Image URL: " + imageUrl);
			            System.out.println("Price: " + price);
			            System.out.println("Rating: " + rating);
			            System.out.println("Review Count: " + reviewCount);
			            System.out.println("----------------------");
			        }
			    }

			    /*public void tearDown() {
			        // Close the browser
			        if (driver != null) {
			            driver.quit();
			      */  
			    

			    public static void main(String[] args) {
			    	SearchFunctionality SearchFunctionality = new SearchFunctionality();
			    	SearchFunctionality.setUp();
			    	SearchFunctionality.searchProduct("iphone 14");
			    	//SearchFunctionality.tearDown();
	 }
}
