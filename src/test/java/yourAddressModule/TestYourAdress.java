package yourAddressModule;



import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

		public class TestYourAdress {
		    private WebDriver driver;

		    @BeforeMethod
		    public void setUp() {
		        // Set the path to the ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		        
		        driver = new ChromeDriver();

		        // Maximize the browser window
		        driver.manage().window().maximize();

		        // Navigate to Amazon homepage
		        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fs%3Fk%3Damazon%2Blogin%2Bto%2Bmy%2Baccount%26hvadid%3D556129898822%26hvdev%3Dc%26hvlocphy%3D9001030%26hvnetw%3Dg%26hvqmt%3De%26hvrand%3D14270058374076683946%26hvtargid%3Dkwd-364435124097%26hydadcr%3D3321_10311071%26tag%3Dgoogcana-20%26ref%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

		        // Wait for the sign-in page to load
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		        // Find and fill in the email field
		        WebElement emailField = driver.findElement(By.id("ap_email"));
		        emailField.sendKeys("shiv01tester@gmail.com");

		        // Find and click on the "Continue" button
		        WebElement continueButton = driver.findElement(By.id("continue"));
		        continueButton.click();

		        // Find and fill in the password field
		        WebElement passwordField = driver.findElement(By.id("ap_password"));
		        passwordField.sendKeys("Shivani@123");

		        // Find and click on the "Sign-In" button
		        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
		        signInButton.click();

		        // Find the "Hello, Sign in" element
		        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));

		        // Perform mouse hover action on the element
		        Actions actions = new Actions(driver);
		        actions.moveToElement(accountElement).perform();

		        // Find and click on the "Your Account" option in the drop-down menu
		        WebElement yourAccountOption = driver.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		        yourAccountOption.click();

		        
		    }

		    @Test
		    public void addNewAddress() {
		        // Find and click on the "Address" module
		        WebElement addressModule = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div"));
		        addressModule.click();

		       

		        // Find and click on the "Add Address" button
		        WebElement addAddressButton = driver.findElement(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div/div"));
		        addAddressButton.click();

		        

		        // Fill in the address details
		        WebElement countryField = driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId"));
		        countryField.sendKeys("Canada");

		        WebElement fullNameField = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
		        fullNameField.sendKeys("Shivani Pathak");

		        WebElement addressField = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
		        addressField.sendKeys("123 Main St");

		        WebElement cityField = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
		        cityField.sendKeys("Toronto");

		        // Select province from drop-down menu
		        WebElement provinceField = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span"));
		        provinceField.sendKeys("Ontario");

		        WebElement postalCodeField = driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
		        postalCodeField.sendKeys("M1A 1A1");

		        WebElement phoneNumberField = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
		        phoneNumberField.sendKeys("1234567890");

		        // Check the option to make address as default
		        WebElement makeDefaultCheckbox = driver.findElement(By.id("address-ui-widgets-makeThisMyDefaultCheckbox"));
		        makeDefaultCheckbox.click();

		        // Add additional delivery instructions
		        WebElement deliveryInstructionsField = driver.findElement(By.id("address-ui-widgets-landmark"));
		        deliveryInstructionsField.sendKeys("Building access code: 1234");

		        // Click on "Add address" button to save the address
		        WebElement addAddressSubmitButton = driver.findElement(By.xpath("//span[contains(text(),'Add address')]"));
		        addAddressSubmitButton.click();

		        

		       
		    }

		    @AfterMethod
		    public void tearDown() {
		        // Close the browser
		        driver.quit();
		    }
		

	


}
