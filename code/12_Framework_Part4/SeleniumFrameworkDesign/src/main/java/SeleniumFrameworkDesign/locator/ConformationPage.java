package SeleniumFrameworkDesign.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ConformationPage extends AbstractComponent{
	WebDriver driver;
	
	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement conformationMessage;
	
	public String getConformationMessage() {
		return conformationMessage.getText();
	}
}