import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//date 
		GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
       
        System.out.println(getRandomTime());
        Random random = new Random();
       
            LocalDateTime time = LocalDateTime.of(LocalDate.now(), 
                    LocalTime.of(random.nextInt(24), random.nextInt(60),
                    random.nextInt(60), random.nextInt(999999999 + 1)));
            System.out.println(time);
            
            System.out.println(getRandomSecurityName());
            System.out.println(getRandomTradeType());
            System.out.println(randomIdentifier());
            
            //generate float decimal point 
            Random r = new Random();
            float min = 100.0f, max = 200000.00f;

            float random1 = min + r.nextFloat() * (max - min);
            System.out.println(random1);
            
            //whole number price and ticks
            Random rand = new Random();

            int  n = rand.nextInt(9)*100;
            System.out.println(n);
            
            int ticks = rand.nextInt(9)*10;
            System.out.println(ticks);
    }
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	final static java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final static Set<String> identifiers = new HashSet();

	public static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
    public static Timestamp getRandomTime(){

    	  Random r = new Random();
    	  int Low = 100;
    	  int High = 1500;
    	  int Result = r.nextInt(High-Low) + Low;
    	  int ResultSec = r.nextInt(High-Low) + Low;

    	  Calendar calendar = Calendar.getInstance();
    	  calendar.add(Calendar.MINUTE, - Result);
    	  calendar.add(Calendar.SECOND, - ResultSec);

    	  java.sql.Timestamp ts = new java.sql.Timestamp(calendar.getTimeInMillis());
    	  return ts;
    	}
    
    static String getRandomSecurityName(){
        int r = (int) (Math.random()*10);
        String name = new String [] {"India","USA","UK","Russia","abc","xyz","name","wqs","wat","cat"}[r];
        return name;
    }
    static String getRandomTradeType(){
        int r = (int) (Math.random()*2);
        String name = new String [] {"Buy","Sell"}[r];
        return name;
    }
    
}
