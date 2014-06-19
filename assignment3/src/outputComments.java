import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class outputComments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		String c = "//";

		String d = "(\"//\")";
		/*
		 * the slash sign "\" was inserted on string d to include the inner
		 * quotation marks as part of the string
		 */

		try {
			// scan initial document
			Scanner scan = new Scanner(new File(
					"C:\\Users\\canlasd\\workspace\\comments.txt"));
			// use printstream to generate new files
			PrintStream File = new PrintStream(
					"C:\\Users\\canlasd\\workspace\\nocomments.txt");
			PrintStream File2 = new PrintStream(
					"C:\\Users\\canlasd\\workspace\\withcomments.txt");

			// check if there are strings available
			while (scan.hasNextLine()) {
				// initialize string name with the scanned line
				name = scan.nextLine();

				if (!name.contains(c) || name.contains(d)) {
					/*
					 * prints the line into the nocomments.txt if the string
					 * does not contain // or if the line contains ("//"). The
					 * name.contains(d) was added to make sure any valid code
					 * that uses // is not included in the comment file.
					 */
					File.println(name);

				} else if (name.contains(c)) {
					// prints the line into the withcomments.txt if the string
					// contains //
					File2.println(name);
				}

			}
			scan.close();
			File.close();
			File2.close();

			// catch errors

		} catch (IOException e) {
			System.out.println("IO Error\n  " + e);
		}
	}

}
