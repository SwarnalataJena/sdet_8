package genericLirbrary;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * author Swarna
 * @author USER
 *
 */
public class JavaUtility {
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int rndm=r.nextInt(2000);
		return rndm;
	}
	
	public static String manageDate()
	{
		Date d=new Date();
		String stringdate = d.toString();
//		Thu Sep 08 16:06:45 IST 2022
//		0    1  2    3       4   5
		String[] sarr = stringdate.split(" ");
		String time=sarr[3];
		String currentdate=sarr[2];
		String currentMonth=sarr[1];
		String currentYear=sarr[5];
		return time+" "+currentdate+":"+currentMonth+":"+currentYear;
		
	}
	

}
