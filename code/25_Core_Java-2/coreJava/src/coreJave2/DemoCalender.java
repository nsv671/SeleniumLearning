package coreJave2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DemoCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss");
		System.out.println(dateFormat.format(calendar.getTime()));
		System.out.println(calendar.get(Calendar.MONTH)); //for January it is 0
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.AM_PM));
		System.out.println(calendar.getTime());
	}

}
