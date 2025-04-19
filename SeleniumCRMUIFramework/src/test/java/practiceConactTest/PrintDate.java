package practiceConactTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PrintDate {

	public static void main(String[] args) {
		
		Date dateObj = new Date();
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateObj);
		
		System.out.println(dateObj.toString());
		System.out.println("Actual Date  " +actDate);
		
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,-30);
	
		String requiredDate = sim.format(cal.getTime());
		System.out.println("required Date " +requiredDate);
	}
}
