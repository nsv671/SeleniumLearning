import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		
		HashMap<String, Object> chromePreference = new HashMap<String, Object>();
		chromePreference.put("profile.default_content_settings.popups",0);
		chromePreference.put("download.default_directory",projectPath+"\\downloads");
		
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", downloadPath);
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("prefs", chromePrefs);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePreference);
		WebDriver driver = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver.manage().window().maximize();
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(projectPath+"\\fileUploadScript\\FileUpload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		
//		Runtime.getRuntime().exec(projectPath+"\\fileDownloadScript\\FileUpload.exe");
		
		Thread.sleep(5000);
		File file = new File(System.getProperty("user.dir")+"\\downloads\\ilovepdf_pages-to-jpg.zip");
		
		if(file.exists()) {
			System.out.println("File downloaded successfully");
			if(file.delete())
				System.out.println("File successfully got deleted");
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
