package Selenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestDemo {
	
	@Test
	public void titleCheck() throws IOException {
		// TODO Auto-generated method stub
		MutableCapabilities capabilities = new MutableCapabilities();
		WebDriver driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/"), capabilities);

	}

}