import java.util.Scanner;

/**
 * Write a description of class assignment1 here.
 * 
 * 
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class assignment1 {
	public static void main(String[] args) {
		double counter = 0;
		double counterTotal = 0;
		double counterAverage = 0;
		double num = 0.0;
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("Input a number or asterisk to quit");

			if (input.hasNextDouble()) {
				counter++;
				num = input.nextDouble();
				counterTotal = counterTotal + num;
				counterAverage = counterTotal / counter;

			} else if (input.next().equals("*")) {

				keepGoing = false;
				System.out.println("You entered  " + counter + "  numbers");
				System.out.println("Total Number of Digits Entered  =  "
						+ counterTotal);
				System.out.println("The average of the numbers is  "
						+ counterAverage);

			}

			else {

				System.out
						.println("Your entry is invalid. Please input * or a numeric value");
			}
		}

	}
}
