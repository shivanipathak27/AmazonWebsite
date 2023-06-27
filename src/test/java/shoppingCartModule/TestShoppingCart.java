package shoppingCartModule;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class TestShoppingCart {
		    private ShoppingCart shoppingCart;

	 @BeforeClass
	  public void setUp() {
		        shoppingCart = new ShoppingCart();
		        shoppingCart.setUp();
		    }

	 @Test
	   public void testAddToCart() {
		        shoppingCart.addToCart("B075FCRGKD"); //used ASIN of Amazon Product
		        shoppingCart.addToCart("B0C813QLSM"); 
		    }
		
	 @Test
	   public void testIncreaseQuantity() {
		        shoppingCart.increaseQuantity("B0C5HZQVSX", 3); 
		    }

	 @Test
	  public void testAddSameItemMultipleTimes() {
		        shoppingCart.addToCart("B0C813QLSM"); 
		    }

	 @Test
	  public void testAddMultipleItems() {
		        shoppingCart.addToCart("B0C5D5WZKN"); 
		    }

	  @Test
	  public void testRemoveItem() {
		        shoppingCart.removeItem("B0C813QLSM"); 
		    }

	 @Test
	  public void testViewItemDetails() {
		        shoppingCart.viewItemDetails("B0C5HZQVSX"); 
		    }

	  @Test
	  public void testClearCart() {
		        shoppingCart.clearCart();
		    }

	 @AfterClass
	 public void tearDown() {
		        shoppingCart.tearDown();
		    }
}
