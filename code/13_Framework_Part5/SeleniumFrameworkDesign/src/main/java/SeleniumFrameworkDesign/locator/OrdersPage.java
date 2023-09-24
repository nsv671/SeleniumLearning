package SeleniumFrameworkDesign.locator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tbody tr td:nth-child(3)")
	List<WebElement> orderLists;
	
	public boolean verifyOrderDisplay(String productName) {
		return orderLists.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
	}
	
}
