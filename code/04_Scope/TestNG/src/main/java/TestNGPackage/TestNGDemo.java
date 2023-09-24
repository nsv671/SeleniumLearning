package TestNGPackage;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestNGDemo {
	@AfterTest(groups= {"smoke"})
	public void lastExecution() {
		System.out.println("I will excute last");
	}
	@Test
	public void testNGDemoMethod() {
		System.out.println("Run via TestNG Library");
	}
	
	@Test
	public void testNGDemoMethod2() {
		System.out.println("Run via TestNG Library Method 2");
	}
	@AfterSuite(timeOut=4000)
	public void afterSuite() {
		System.out.println("I am number 1 from the END for the test execution");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("i will execute BEFORE every test case method execution");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I will be executing AFTER every test case method execution");
	}
}
