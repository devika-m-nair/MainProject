package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getCurrentDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String formateddate=sdf.format(date);
		return formateddate;
	}
	

}
