import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		
		Thread.sleep(4000);
		driver.close();
	}

}
