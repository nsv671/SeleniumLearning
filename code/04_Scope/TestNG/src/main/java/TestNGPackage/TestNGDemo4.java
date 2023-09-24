package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class TestNGDemo4 {
	@Test
	public void webLoginHomeLoan() {
		//Selenium web login test case
		System.out.println("Web Login Home Loan Test Case");
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		//Appuim mobile login test case
		System.out.println("Mobile Login Home loan Test Case");
	}
	
	@Test(groups= {"smoke"})
	public void loginAPIHomeLoan() {
		//Rest API automation
		System.out.println("API Login Home Loan Test Case");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am number 1 in the test case to execute");
	}
}