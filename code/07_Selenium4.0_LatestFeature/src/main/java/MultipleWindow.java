import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String mainURL = "https://rahulshettyacademy.com/angularpractice/";
		String secondaryURL = "https://rahulshettyacademy.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(mainURL);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();
		String parentWindow = iterator.next();
		String chieldWindow = iterator.next();
		
		//changing window to parent window
		driver.switchTo().window(chieldWindow);
		driver.get(secondaryURL);
		
		WebElement course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1);
		String courseName =course.getText();
		System.out.println(courseName);
		
		//changing window to parent window
		driver.switchTo().window(parentWindow);
		
		WebElement inputName = driver.findElement(By.cssSelector("input[name='name']"));
		inputName.sendKeys(courseName);
		
		//Taking Element screenshot
		File file = inputName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("inputName.png"));
		
		//Taking Window screenshot
		File windowScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(windowScreenshot, new File("windowScreenshot.png"));
		
		//Getting height and with of the element
		int height = inputName.getRect().getDimension().height;
		int width = inputName.getRect().getDimension().width;
		
		System.out.println("Height - " + height);
		System.out.println("Width - " + width);
		
		driver.quit();
	}

}
