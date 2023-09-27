package coreJave2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DemoDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		
		SimpleDateFormat dateFormater1 = new SimpleDateFormat("MM-dd-YYYY");
		SimpleDateFormat dateFormater2 = new SimpleDateFormat("MM-dd-YYYY HH:MM:SS");
		SimpleDateFormat dateFormater3 = new SimpleDateFormat("HH:MM:SS DD-MM-YYYY");
		
		System.out.println(dateFormater1.format(date));
		System.out.println(dateFormater2.format(date));
		System.out.println(dateFormater3.format(date));
//		System.out.println(date.toLocaleString());
		System.out.println(date.toString());
	}

}
