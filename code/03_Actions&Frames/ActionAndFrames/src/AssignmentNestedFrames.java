import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNestedFrames {
	public static void main(String[] args) {
		String URL = "https://the-internet.herokuapp.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		String frameContent = driver.findElement(By.id("content")).getText();
		
		System.out.println(frameContent);
		
		driver.close();
	}
}
