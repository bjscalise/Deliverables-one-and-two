import java.util.Scanner;

public class Lab1 {
	
/*Initially I had completed this lab and confined the inputs to 3-digit variables. After speaking with classmates I decided to rework this to allow the user to input larger or smaller numbers. The basic calculation to get the ones, tens and hundreds etc. has remained roughly the same as my first attempt but I had to do a whole lot of researching to get a function that can be used with up to ten digits. I initially had hard-coded modulus and division to get the different values at each digit so I needed to use a for loop in this one.*/

	public static void main(String[] args) {
		System.out.println("Try to find two numbers that have ones, tens, hundreds etc. that all add up to equal sums.");
		System.out.println("Your numbers can be 1-10 digits but they need to have the same amount of digits to work.");
		System.out.println("Please keep your numbers less than 2 billion as this could cause an error.");
		System.out.println("Ex 123 & 654 | 1+6=7, 2+5=7, 3+4=7 | 7=7=7: TRUE");
		input(); //Calls the input method.
	}

	private static void input() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		
		int num1 = 0; //Declare the two variables that will represent the users numbers and assign them a place-holder value. 
		int num2 = 0; 
		
		if(scanner.hasNextInt()) { //hasNextInt is used to ensure that the input is entered as an integer. 
			num1 = scanner.nextInt(); //If the user doesn't enter an integer then moves to the else branch and returns the user to the top of input()
			System.out.println("Please enter another number with the same amount of digits as the last.");
		} else {
			System.out.println("Number not entered, Please enter an integer: ");
			input();
		}
		
		if(scanner.hasNextInt()) { //The runs the same validation on the second input.
			num2 = scanner.nextInt();
		} else {
			System.out.println("Number not entered, Please enter a number: ");
			input();
		}
		
		/*This if/else will check that the two numbers have an equal amount of digits. If they aren't equal, the IF statement will be true and return       		them to the top of the input() method. If they are equal, it will call the calculate() method and begin pulling the numbers apart and adding 		them together.*/
		
		if(length(num1) != length(num2)) { 
			System.out.println("Lengths need to be equal. Please try again.");
			input();
		} else {
			calculate(num1, num2);
		}
		
		/*This if/else will take the result of the calculate() method and spit out a message. If the boolean value is true, it will give you the first 		prompt which means all of the digits held values that all added up to equal sums. If not, the second.*/
		if (calculate(num1, num2) == true ) {
			System.out.println("True. The two numbers that you entered have digits that add up to equal amounts.");
		} else {
			System.out.println("False. These two numbers do no have digits that add up to equal amounts.");
		}

	}
	private static boolean calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		
		/*This method finds the value in each digit and adds them to determine if they have equal sums. As I couldn't hard-code in anticipation of a 		certain amount of digits, I looked on stack overflow for other options. I thought the for loop was the best choice because I knew how many times 		it needed to be run (the value of length()).
		 * 
		I declare an integer variable lenght1 and assign it to the length of the first number using the length() method below. The loop with run for n   		iterations, n being the length of the first # entered by the user. */
		int length1 = length(num1);

		int sumcheck = (num1 % 10) + (num2 % 10); //num1 and num2 change with each iteration of this loop. This keeps track of the first sum (the one's 		digit) and lets the program know if it changes.
		for( int i = 0; i < length1; i++) {//i will increase by one each iteration until it equals the length of the first input (Length1).
			int x1 = num1 % 10; //Modulus will give you the remainder of dividing by 10 (the one's digit). 
			int x2 = num2 % 10;
			if((x1 + x2) != sumcheck) { //If the sum is different that the sumcheck we know that the digits add up to different sums. 
				return false; //Program returns False.
			} else {
				num1 = num1 /10; 
				num2 = num2/ 10; //This will move the decimal place back with each iteration of the for loop. Then, using the modulus to find the 				right-most digit, we can go from tens, hundreds, thousands etc. checking if there sums equal the sum of the one's digit (sumcheck) with 				every iteration of the loop.
				
			}
	}
		return true;
		
	}
	/*I found this method line on stack overflow and this is my understanding of what it is doing: The String.valueOF(number) returns and string with 	the value of # entered. The .length() can then be used on this String and get the length of the #.*/
	private static int length( int number) { 
		int length = String.valueOf(number).length();	
		return length;
		}
	}