import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.id("checkBoxOption1")).click();
		String selectedLableText = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]")).getText();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example")); 
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(selectedLableText);
		
		driver.findElement(By.id("name")).sendKeys(selectedLableText);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(selectedLableText)) {
			System.out.println("alert windoe contains the "+selectedLableText);
		}else {
			System.out.println("something went wrong while execution");
		}
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.close();
	}

}
