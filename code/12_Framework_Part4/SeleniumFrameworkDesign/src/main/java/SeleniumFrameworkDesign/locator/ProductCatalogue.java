package SeleniumFrameworkDesign.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "mb-3")
	List<WebElement> products;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement myOrders;

	By productBy = By.className("mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
//		Reporter.log(productName, true);
		WebElement productNeedToSelect = getProductList().stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
//		Reporter.log("Line 45 - "+productNeedToSelect.getText(), true);
		return productNeedToSelect;
	}

	public CartPage addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();

		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage goToOrdersPage() {
		myOrders.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		
		return ordersPage;
	}
}
