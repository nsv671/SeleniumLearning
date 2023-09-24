package SeleniumFrameworkDesign.locator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProductList;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutElement;
	
	public boolean VerifyProductDisplay(String productName) {
		return cartProductList.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
	}
	
	public CheckOutPage goTOheckout() {
		checkoutElement.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
}
