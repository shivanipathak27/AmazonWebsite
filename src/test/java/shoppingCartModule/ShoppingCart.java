package shoppingCartModule;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

	public class ShoppingCart { 
	    private WebDriver driver;

	    public void setUp() {
	   
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	      
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-notifications");

	     
	        driver = new ChromeDriver(options);

	        // Maximize the browser window
	        driver.manage().window().maximize();
	    }

	    public void addToCart(String itemName) {
	        // Navigate to the product page
	        driver.get("https://www.amazon.ca/dp/" + itemName);

	        // Click on the "Add to Cart" button
	        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	        addToCartButton.click();

	    
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        // Print the cart details
	        System.out.println("Item added to cart: " + itemName);
	        System.out.println("----------------------");
	    }

	    public void increaseQuantity(String itemName, int quantity) {
	        // Navigate to the cart page
	        driver.get("https://www.amazon.ca/gp/cart/view.html");

	        // Find the quantity input field for the item
	        WebElement quantityInput = driver.findElement(By.xpath("//input[@name='quantityBox']"));

	        // Clear the existing quantity and enter the new quantity
	        quantityInput.clear();
	        quantityInput.sendKeys(String.valueOf(quantity));

	        // Press Enter to update the quantity
	        quantityInput.submit();

	        // Print the updated cart details
	        System.out.println("Quantity updated for item: " + itemName);
	        System.out.println("New quantity: " + quantity);
	        System.out.println("----------------------");
	    }

	    public void removeItem(String itemName) {
	        // Navigate to the cart page
	        driver.get("https://www.amazon.ca/gp/cart/view.html");

	        // Find the "Delete" link for the item
	        WebElement deleteLink = driver.findElement(By.xpath("//input[@name='submit.delete.' and @value='Delete']"));

	        // Click on the "Delete" link
	        deleteLink.click();

	        // Print the updated cart details
	        System.out.println("Item removed from cart: " + itemName);
	        System.out.println("----------------------");
	    }

	    public void clearCart() {
	        // Navigate to the cart page
	        driver.get("https://www.amazon.ca/gp/cart/view.html");

	        // Find all the items in the cart
	        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@data-name='Active Items']//div[@class='sc-list-item-content']"));

	        // Remove each item from the cart
	        for (WebElement cartItem : cartItems) {
	            WebElement deleteCheckbox = cartItem.findElement(By.xpath(".//input[@type='checkbox']"));
	            deleteCheckbox.click();
	        }

	        // Click on the "Delete" button to clear the cart
	        WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
	        deleteButton.click();

	        // Print the updated cart details
	        System.out.println("Cart cleared");
	        System.out.println("----------------------");
	    }

	    public void viewItemDetails(String itemName) {
	        // Navigate to the cart page
	        driver.get("https://www.amazon.ca/gp/cart/view.html/");

	        // Find the item link in the cart
	        WebElement itemLink = driver.findElement(By.xpath("//a[contains(@href, '/dp/') and contains(@href, '" + itemName + "')]"));

	        // Click on the item link to view the details
	        itemLink.click();

	   
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	        // Print the item details
	        System.out.println("Item details for: " + itemName);
	        System.out.println("URL: " + driver.getCurrentUrl());
	        System.out.println("----------------------");
	    }

	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public static void main(String[] args) {
	        ShoppingCart shoppingCart = new ShoppingCart();
	        shoppingCart.setUp();

	        // Add items to the cart
	        shoppingCart.addToCart("B075FCRGKD"); //here i used ASIN code of product
	        shoppingCart.addToCart("B0C813QLSM"); 

	        // Increase the quantity of an item
	        shoppingCart.increaseQuantity("B0C5HZQVSX", 3);

	        // Add the same item multiple times
	        shoppingCart.addToCart("B0C813QLSM"); 

	        // Add multiple items of different types
	        shoppingCart.addToCart("B0C5D5WZKN"); 

	        // Remove an item from the cart
	        shoppingCart.removeItem("B0C813QLSM"); 

	        // View item details
	        shoppingCart.viewItemDetails("B0C5HZQVSX"); 

	        // Clear the cart
	        shoppingCart.clearCart();

	        shoppingCart.tearDown();
	    }


}
