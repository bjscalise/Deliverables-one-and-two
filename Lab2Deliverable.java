import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

/* I had initially tried to do this lab using a separate prompt for days, months, years (6 total inputs). I would then take the days from dateOne and subtract them from dateTwo (ditto with months and years). Then I would take the years and multiply by 365, months by 30 and get the total duration in days. Multiply the years by 12 and divide the days by 30 for months and similar calculations for years. I realized that this would be sloppy,imprecise, and inefficient so I started to look around Stack Overflow and found date/time formatters and the LocalDate / ChronoUnit tools that I used in this program. This was a lot simpler than I had thought as java basically had all of the tools that I needed to format inputs(as Strings) into dates and find the difference between the dates. I assume that these tools are more precise and account for leap years and months with 28, 30, 31 days.*/


public class Lab2Deliverable {
	public static void main(String[] args) {
	
		System.out.println("This program will determine the length of time between two dates.");
		System.out.println("Please note that only dates after 999 AD and before 10000 AD are accepted.");
		
		scanner(); //Call the scanner method.
	}

	private static void scanner() {
		// TODO Auto-generated method stub
	
		String dateOne; //These variables need to be strings so that they can be converted to LocalDate. 
		String dateTwo; 
		
		Scanner scanner = new Scanner(System.in);
				
				System.out.println("Please enter a date in the following format: dd-mm-yyy");
			
				dateOne = scanner.nextLine();
				
				System.out.println("Please enter a second date:");
				
				dateTwo = scanner.nextLine();
				
		/*The user is prompted to input two Strings in the SimpleDateFormat dd-mm-yyyy. What the SDF does is check that the inputs are in the proper 		format so that they can be compared later. They still remain strings once formatted. If they input anything that does not follow this format it 		will return the user to the first prompt and they will need to input the first date again.*/
		
		if (format(dateOne) == true) { //This is calling the format method for the first date. It will return 'true' if the input is valid.
		}
		else {
			System.out.println("Your date isn't correct, please start over from the beginning.");
			scanner(); //This calls the scanner method and brings the user back to the first prompt. This is because the first input is invalid.
		}
		
		if (format(dateTwo) == true){ //If we reach here then we know that both inputs are in the correct format and we can proceed.
			System.out.println("both dates are correct");
			calculate(dateOne, dateTwo); //This calls the calculate method and sends both formatted dates.
	    }
		else {
			System.out.println("Your second date isn't correct, please start over"); //Your second input was incorrect. Back to the beginning.
			scanner();
		}

	}

	private static void calculate(String dateOne, String dateTwo) {
		// TODO Auto-generated method stub
		
		/*The following code blocks are adapted from code that I found on Stack overflow when I was searching for functions to convert Strings to dates 		and calculate differences between them. This is my understanding of how they work: The two strings have been validated with format() and 		can now be converted to the LocalDate variable using the DateTimeformatter. This variable can be used with the ChronoUnit tools to find the 		difference between dates. There is no need to do these operations manually and they're all returned as positive integers.*/
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //DateTimeFormatter is declaring the format that I want these in.
		LocalDate localDateOne = LocalDate.parse(dateOne, formatter); //These are parsed into a LocalDate variable.
		LocalDate localDateTwo = LocalDate.parse(dateTwo, formatter); //The formatter needs MM to be upper-case or it recognizes it as minutes.
		
		//This function will find the difference in M,D,Y between the two dates. All values will be returned as integers.
		long diffInDays = ChronoUnit.DAYS.between(localDateOne, localDateTwo); 
		long diffInMonths = ChronoUnit.MONTHS.between(localDateOne, localDateTwo); 
		long diffInYears = ChronoUnit.YEARS.between(localDateOne, localDateTwo);  
		 
		System.out.println("There are " + diffInDays + " days between those two dates."); //Printing the results.
		System.out.println("There are " + diffInMonths + " months between those two dates.");
		System.out.println("There are " + diffInYears + " years between those two dates.");
	}

	private static boolean format(String date) {
		// TODO Auto-generated method stub
		
		/*I found SDF when I was checking how to find if a string was in a proper date format. This code is also adapted from code that I found on   		stack overflow. The try catch seems to be checking the input to the format and preventing the program from crashing with the ParseException 		when there are invalid inputs entered. It is going to return false if the input is invalid.*/
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		
		//Given this format, the program cannot accept dates before 1000AD or after 9999AD. You'll have to use a calendar.
		dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
        	System.out.println("incorrect format");
            return false;
        }
        return true; //If the compiler gets to this point it means that the inputs are valid. It will return true.
	}
}	
		

 