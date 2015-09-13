/*
 * Paul Hafycz
 * 9/12/15
 * QB Rater Program
 * This program takes in 5 inputs from the user 
 * (Touchdowns, Yards, Interceptions, completions and attempts)
 * and takes this data and computes the Passer Rating using a 
 * equation
 */

package MainPackage;

import java.util.Scanner;


public class QbRater
{
	public static void main(String[] args)
	{
		Scanner attempt = new Scanner(System.in);//Gets input for attempts
		System.out.println("How Many Attempts");
		double attempt1 = attempt.nextDouble();//Converts the to a double 
		Scanner comps = new Scanner(System.in);//Gets input for completions
		System.out.println("How Many Completions");
		double comps1 = comps.nextDouble();//Converts that to a double
		Scanner ints = new Scanner(System.in);//gets input for interceptions
		System.out.println("How Many Interceptions");
		double ints1 = ints.nextDouble();//converts that to a double
		Scanner touchd = new Scanner(System.in);//gets input for touchdowns 
		System.out.println("How Many Touchdowns");
		double touchd1 = touchd.nextDouble();//converts that to a double
		Scanner yards = new Scanner(System.in);//gets input for yards
		System.out.println("How Many Yards");
		double yards1 = yards.nextDouble();//converts that to a double
		
		double passRating = Calc(attempt1, comps1, ints1, touchd1, yards1);//Commits the calc method with all the inputs that were just given
		System.out.println("The Passer Rating of you QB is " + passRating);//This prints out the final result
	}
	
	/*
	 * This whole method is based off of the calculations in the wikipedia article
	 * I take in all the data and return the final answer
	 */
	public static double Calc(double att, double comp, double intercept, double tds, double yds)
	{
		double a = ((comp / att) - .3) * 5;
		double b = ((yds / att)-3) *.25;
		double c = (tds / att) * 20;
		double d = 2.375 - ((intercept / att) * 25);
		if (a <= 0) 
			a=0;
		else if (a > 2.375)
			a= 2.375;
		if (b <= 0)
			b=0;
		else if (b > 2.375)
			b=2.375;
		if (c <= 0)
			c=0;
		else if (c > 2.375)
			c = 2.375;
		if (d <= 0)
			d=0;
		else if (d > 2.375)
			d = 2.375;
		double e = ((a + b + c + d) / 6) * 100;
		return e;
	}
}
