package com.seleniumcrm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random ranDom = new Random();
		int randomInt = ranDom.nextInt(5000);
		return randomInt;
	}

	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM() {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");	
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
	String requiredDate = sim.format(cal.getTime());
		return requiredDate;
	}
	
}
