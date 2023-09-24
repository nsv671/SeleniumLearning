package SeleniumFrameworkDesign.locator;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	String URL = "https://rahulshettyacademy.com/client/";
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginInto(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo() {
		driver.get(URL);
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
