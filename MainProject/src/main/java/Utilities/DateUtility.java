package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getCurrentDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		String formateddate=sdf.format(date);
		return formateddate;
	}
	

}
