package demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
	
	 static DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z");
	 static DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma 'ET'");
	     
	    static ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
	    static ZoneId etZoneId = ZoneId.of("America/New_York");
	    

	public static void main(String[] args) {

		Date today1 = new Date(1557394200000L); 
		//
		Date today2 = new Date(1557408600000L); 
		LocalDateTime currentDateTime1 = LocalDateTime.ofInstant(today1.toInstant(), ZoneId.systemDefault());

        ZonedDateTime currentISTime1 = currentDateTime1.atZone(istZoneId);                //India Time
        ZonedDateTime currentETime1 = currentISTime1.withZoneSameInstant(etZoneId);       //ET Time
         
        System.out.println(globalFormat.format(currentISTime1));
        System.out.println(etFormat.format(currentETime1));
        
		LocalDateTime currentDateTime2 = LocalDateTime.ofInstant(today2.toInstant(), ZoneId.systemDefault());

        ZonedDateTime currentISTime2 = currentDateTime2.atZone(istZoneId);                //India Time
        ZonedDateTime currentETime2 = currentISTime2.withZoneSameInstant(etZoneId);       //ET Time
         
        System.out.println(globalFormat.format(currentISTime2));
        System.out.println(etFormat.format(currentETime2));

	}

}
