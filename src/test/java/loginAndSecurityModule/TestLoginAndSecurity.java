package loginAndSecurityModule;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class  TestLoginAndSecurity {
			    private WebDriver driver;
			    
	@BeforeMethod
	 public void setUp() {
	     
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

			        
			        // Find and click on the "Login And Security" module
			        WebElement loginAndSecurityModule = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div/div[1]/img"));
			        loginAndSecurityModule.click();

			        
			    }

	@Test
	public void updateLoginInformation() {
			        // Find and click on the "Edit" button for Name
			        WebElement editNameButton = driver.findElement(By.xpath("//*[@id=\"auth-cnep-edit-name-button\"]"));
			        editNameButton.click();

			        
			        // Find the name field and update the value
			        WebElement nameField = driver.findElement(By.id("ap_customer_name"));
			        nameField.clear();
			        nameField.sendKeys("Shivani Automation Tester");

			        // Save the updated name
			        WebElement saveNameButton = driver.findElement(By.id("cnep_1C_submit_button"));
			        saveNameButton.click();

			        
			        // Find and click on the "Edit" button for Cell Phone Number
			        WebElement editCellPhoneNumberButton = driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
			        editCellPhoneNumberButton.click();

			       

			        // Find the cell phone number field and update the value
			        WebElement cellPhoneNumberField = driver.findElement(By.id("auth-cnep-edit-phone-number-widget"));
			        cellPhoneNumberField.clear();
			        cellPhoneNumberField.sendKeys("1234567890");

			        // Save the updated cell phone number
			        WebElement saveCellPhoneNumberButton = driver.findElement(By.xpath("//input[contains(@value,'Save changes')]"));
			        saveCellPhoneNumberButton.click();

			        

			        // Find and click on the "Delete" button for Cell Phone Number
			        WebElement deleteCellPhoneNumberButton = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
			        deleteCellPhoneNumberButton.click();

			        
			        WebElement confirmDeleteCellPhoneNumberButton = driver.findElement(By.xpath("//input[contains(@value,'Delete')]"));
			        confirmDeleteCellPhoneNumberButton.click();

			        
			    }

	 @AfterMethod
	 public void tearDown() {
		// Close the browser
	 driver.quit();
			    }
	 }
