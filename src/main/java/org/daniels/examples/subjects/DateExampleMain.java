package org.daniels.examples.subjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExampleMain {

	public static void main(String[] args) {
		Date currentDate = Calendar.getInstance().getTime();
		
		String formatedDate = String.format("%1$tFT%1$tT", currentDate);
		System.out.println(formatedDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println(dateFormat.format(currentDate));
		

	}

}
