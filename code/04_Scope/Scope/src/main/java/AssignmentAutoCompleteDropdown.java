import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentAutoCompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		String nation = "India";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(URL);

		driver.findElement(By.id("autocomplete")).sendKeys("Ind");

		Thread.sleep(3000);

		List<WebElement> listOfCountry = driver.findElements(By.cssSelector(".ui-menu-item div"));
		Actions actions = new Actions(driver);

		for (WebElement country : listOfCountry) {
			System.out.println(country);
			if (nation.equalsIgnoreCase(country.getText())) {
				System.out.println("----->" + country);
				actions.moveToElement(country).build().perform();
			}
		}

		Thread.sleep(4000);
		driver.close();
	}

}
