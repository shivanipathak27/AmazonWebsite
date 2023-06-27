package sortFilterAndPaginationModule;



//import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

		public class SortFilterPaginationModule {
		    private WebDriver driver;
		    private WebDriverWait wait;

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

		       
		       // wait = new WebDriverWait(driver, 10);
		    }

		    public void searchProduct(String searchQuery) {
		        // Navigate to the Amazon homepage
		        driver.get("https://www.amazon.ca");

		        // Find the search input field
		        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));

		     
		        searchInput.sendKeys(searchQuery);

		        // Submit the search form
		        searchInput.submit();

		        
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-component-type='s-search-result']")));

		        
		        Set<String> productNames = new HashSet<String>();

		        // Process search results from multiple pages
		        while (true) {
		            // Find all the product elements on the current page
		            List<WebElement> productElements = driver.findElements(By.cssSelector("div[data-component-type='s-search-result']"));

		            
		            for (WebElement productElement : productElements) {
		                WebElement productName = productElement.findElement(By.cssSelector("span.a-size-medium"));
		                String name = productName.getText();

		                if (productNames.contains(name)) {
		                    continue; 
		                }
		                productNames.add(name);

		                WebElement productImage = productElement.findElement(By.cssSelector("img"));
		                String imageUrl = productImage.getAttribute("src");

		                WebElement productPrice = productElement.findElement(By.cssSelector("span.a-offscreen"));
		                String price = productPrice.getText();

		                WebElement productRating = productElement.findElement(By.cssSelector("span.a-icon-alt"));
		                String rating = productRating.getText();

		                WebElement productReviewCount = productElement.findElement(By.cssSelector("span.a-size-base"));
		                String reviewCount = productReviewCount.getText();

		                // Print the product information
		                System.out.println("Product Name: " + name);
		                System.out.println("Image URL: " + imageUrl);
		                System.out.println("Price: " + price);
		                System.out.println("Rating: " + rating);
		                System.out.println("Review Count: " + reviewCount);
		                System.out.println("----------------------");
		            }

		            // Check if there is a next page available
		            WebElement nextPageButton = driver.findElement(By.cssSelector("a[aria-label='Next']"));
		            if (!nextPageButton.isEnabled()) {
		                break; // No next page, exit the loop
		            }

		            // Navigate to the next page
		            nextPageButton.click();

		            
		            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-component-type='s-search-result']")));
		        }

		        // Close the browser
		        driver.quit();
		    }

		    public static void main(String[] args) {
		    	SortFilterPaginationModule amazonSearch = new SortFilterPaginationModule();
		    	amazonSearch.setUp();
		    	amazonSearch.searchProduct("iphone 14");
		    }
		





}
