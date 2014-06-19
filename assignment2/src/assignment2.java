import java.util.Scanner;

public class assignment2 {
	public static void main(String[] args) {

		double monSales = 0, tueSales = 0, wedSales = 0, thuSales = 0, friSales = 0, satSales = 0, sunSales = 0;
		int mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0, sun = 0;
		double monAve = 0, tueAve = 0, wedAve = 0, thuAve = 0, friAve = 0, satAve = 0, sunAve = 0;
		boolean keepGoing = true;

		while (keepGoing == true) {

			Scanner sc = new Scanner(System.in);
			double sales;
			System.out.println("Enter the amount of Sale");

			while (!sc.hasNextDouble()) {
				System.out.println("Invalid Input.  Please Input Sales Amount");
				sc.next();
			}
			sales = sc.nextDouble();

			Scanner sc1 = new Scanner(System.in);
			int day;

			do {
				System.out
						.println("Enter the number corresponding to the day of the week");
				System.out.println("For Monday: 1");
				System.out.println("For Tuesday: 2");
				System.out.println("For Wednesday: 3");
				System.out.println("For Thursday: 4");
				System.out.println("For Friday: 5");
				System.out.println("For Saturday: 6");
				System.out.println("For Sunday: 7");
				System.out.println("Results or to quit: 8");

				while (!sc1.hasNextInt()) {
					System.out
							.println("Invalid Input.  Please Input correct number");
					sc1.next();
				}
				day = sc1.nextInt();
			} while (!isValid(day));

			if (day == 1) {

				monSales = sales;
				mon++;
				monSales = monSales + sales;
				monAve = monSales / mon;
			}

			else if (day == 2) {

				tueSales = sales;
				tue++;
				tueSales = tueSales + sales;
				tueAve = tueSales / tue;
			}

			else if (day == 3) {

				wedSales = sales;
				wed++;
				wedSales = wedSales + sales;
				wedAve = wedSales / wed;

			}

			else if (day == 4) {

				thuSales = sales;
				thu++;
				thuSales = thuSales + sales;
				thuAve = thuSales / thu;
			}

			else if (day == 5) {

				friSales = sales;
				fri++;
				friSales = friSales + sales;
				friAve = friSales / fri;
			}

			else if (day == 6) {

				satSales = sales;
				sat++;
				satSales = satSales + sales;
				satAve = satSales / sat;

			}

			else if (day == 7) {

				sunSales = sales;
				sun++;
				sunSales = sunSales + sales;
				sunAve = sunSales / sun;

			}

			else if (day == 8) {

				double[] salesArray = { monSales, tueSales, wedSales, thuSales,
						friSales, satSales, sunSales };

				double[] salesAverage = { monAve, tueAve, wedAve, thuAve,
						friAve, satAve, sunAve };

				double salesMax = salesArray[0];

				for (int counter = 1; counter < salesArray.length; counter++) {
					if (salesArray[counter] > salesMax) {
						salesMax = salesArray[counter];

					}

				}
				System.out
						.println("Total Sales by day:  Mon, Tue, Wed, Thu, Fri, Sat, Sun");
				// System.out.println(Arrays.toString(salesArray));
				for (double number : salesArray) {
					System.out.println(number);
				}
				System.out
						.println("Average Sales by day:  Mon, Tue, Wed, Thu, Fri, Sat, Sun");
				// System.out.println(Arrays.toString(salesAverage));
				for (double number1 : salesAverage) {
					System.out.println(number1);
				}
				if (salesMax == monSales) {
					System.out.println("Best Day is Monday:  Total Sales  "
							+ salesMax + "  Average Sale  " + monAve);
				} else if (salesMax == tueSales) {
					System.out.println("Best Day is Tuesday:  Total Sales  "
							+ salesMax + "  Average Sale  " + tueAve);

				} else if (salesMax == wedSales) {
					System.out.println("Best Day is Wednesday:  Total Sales  "
							+ salesMax + "  Average Sale  " + wedAve);
				} else if (salesMax == thuSales) {
					System.out.println("Best Day is Thursday:  Total Sales  "
							+ salesMax + "  Average Sale  " + thuAve);
				} else if (salesMax == friSales) {
					System.out.println("Best Day is Friday:  Total Sales  "
							+ salesMax + "  Average Sale  " + friAve);
				} else if (salesMax == satSales) {
					System.out.println("Best Day is Saturday:  Total Sales  "
							+ salesMax + "  Average Sale  " + satAve);
				} else {
					System.out.println("Best Day is Sunday:  Total Sales  "
							+ salesMax + "  Average Sale  " + sunAve);
				}
				keepGoing = false;
			}

		}
	}

	private static boolean isValid(int day) {
		int minValue = 1;
		int maxValue = 8;

		if (day < minValue || day > maxValue) {
			System.out.println("INVALID INPUT");
			return false;
		} else {
			return true;
		}
	}
}
