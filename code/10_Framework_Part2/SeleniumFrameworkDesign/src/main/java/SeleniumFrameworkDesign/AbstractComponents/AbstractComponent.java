package SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) throws InterruptedException{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		Thread.sleep(2000);
	}

}
