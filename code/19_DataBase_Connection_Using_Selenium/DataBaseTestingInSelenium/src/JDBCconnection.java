import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String URL ="jdbc:mysql://localhost:8080/databasetesting";
		String userName ="root";
		String password ="test@671";
		String query = "select * from crediential where scenarion = 'zerobalancecase'";
		
		//getConnection(String url,String user, String password)
		Connection connection = DriverManager.getConnection(URL, userName, password);
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("userName"));
			System.out.println(resultSet.getString("password"));
		}
		
		WebDriver driver = new ChromeDriver();
		driver.get("selsforce.com");
		
		driver.findElement(By.cssSelector(".username")).sendKeys(resultSet.getString("userName"));
		driver.findElement(By.cssSelector(".password")).sendKeys(resultSet.getString("password"));
		
		driver.close();
	}

}
