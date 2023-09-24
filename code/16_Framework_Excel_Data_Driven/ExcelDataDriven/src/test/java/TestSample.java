import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDriven dataDriven = new DataDriven();
		
		ArrayList<?> testData = dataDriven.getData("TestData", "Add Profile");
		
		for(Object data : testData){
			System.out.println("testSample --> "+data);
		}
	}

}
