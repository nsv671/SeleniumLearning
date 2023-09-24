package SeleniumFrameworkDesign;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.locator.CartPage;
import SeleniumFrameworkDesign.locator.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=SeleniumFrameworkDesign.TestComponents.Retry.class)
	public void loginErrorTest() throws InterruptedException, IOException {
		landingPage.loginInto("testreg671@test.com", "Zxcvbnrgefm@671");
		String errorMessage = landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or @@@@password.",errorMessage);
	}
	
	@Test
	public void orderErrorTest() throws InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginInto("test671@test.com", "Zxcvbnm@671");
		CartPage cartPage = productCatalogue.addProductToCart(productName);
		boolean flag = cartPage.VerifyProductDisplay("ADIDAS ORIGINAL@");
		Assert.assertFalse(flag);
	}

}
