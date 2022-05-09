package presentationLayer;
import java.util.Scanner;
public class ScanIt {
	static Scanner inputScanner =  new Scanner(System.in);
	public String next()
	{
		String outputString = inputScanner.next();
		return outputString;
	}
	
	public String nextLine()
	{
		String outputString = inputScanner.nextLine();
		return outputString;
	}
	
	public int nextInt()
	{
		String tempString = inputScanner.next();
		int outputInt;
		try {
			outputInt = Integer.parseInt(tempString);
		} catch (Exception e) {
			outputInt = -1;
		}
		return outputInt;
	}
	
	public Double nextDouble()
	{
		String tempString = inputScanner.next();
		double outputDouble;
		try {
			outputDouble = Double.parseDouble(tempString);
		} catch (Exception e) {
			outputDouble = -1;
		}
		return outputDouble;
	}
}
