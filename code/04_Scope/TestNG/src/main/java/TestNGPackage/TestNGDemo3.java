package TestNGPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNGDemo3 {
	@Test(dataProvider="getData")
	public void webLoginCarLoan(String username, String password) {
		//Selenium web login test case
		System.out.println("Web Login Car Loan Test Case");
		System.out.println("*********"+username+"*********");
		System.out.println("*********"+password+"*********");
	}
	
	@Parameters({"URL", "APIKey/Password"})
	@Test
	public void mobileLoginCarLoan(String urlName, String key) {
		//Appuim mobile login test case
		System.out.println("Mobile Login Car loan Test Case");
		System.out.println("*******************"+urlName+"*******************");
		System.out.println("*******************"+key+"*******************");
	}
	
	@Test(enabled = false)
	public void loginAPICarLoan() {
		//Rest API automation
		System.out.println("API Login Car Loan Test Case");
	}
	
	@Test(groups= {"smoke"})
	public void mobileSigninCarLoan() {
		//Appuim mobile login test case
		System.out.println("Mobile SIGNIN Car loan Test Case");
	}
	
	@Test(dependsOnMethods= {"webLoginCarLoan","mobileLoginCarLoan"})
	public void mobileSignOffCarLoan() {
		//Appuim mobile login test case
		System.out.println("Mobile SignOff Car loan Test Case");
	}
	
	@BeforeTest
	public void firstExecution() {
		System.out.println("I will be Executing first");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Execute before any test case method execute in this class file");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Execute after all the test case method run in this class file");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		//data set-1
		data[0][0] = "Set1DataUserName";
		data[0][1] = "Set1DataPassword";
		
		//data set-2
		data[1][0] = "Set2DataUserName";
		data[1][1] = "Set2DataPassword";
		
		//data set-1
		data[2][0] = "Set3DataUserName";
		data[2][1] = "Set3DataPassword";
		
		return data;
	}
}
