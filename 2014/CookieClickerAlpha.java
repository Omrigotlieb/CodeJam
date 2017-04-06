import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CookieClickerAlpha {

    public static void main(String[] args) throws FileNotFoundException {
	//Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File("sample.txt");
	Scanner in = new Scanner(file);
	int t = in.nextInt();
	//System.out.println("t is: " + t);
	for (int i = 1; i < t+1; i++) {
	    	double C = in.nextDouble();
	  //  	System.out.println("C is: " + C);
	    	double F = in.nextDouble();
	    	double X = in.nextDouble();
	    	double result = solver(X,F,C);
	    	System.out.printf("Case #" + i + ": %.7f \n",result);
	    	
	    }
	in.close();
	out.close();
    }

	public static double solver(double X, double F, double C){	    	
	    double minSeconds = X/2;
	    for (double i = 1; i < X; i++) {
		double tempSeconds = 0;
		for (double j = 1; j < i; j++) {
		tempSeconds +=  C/(2 + F*j);
		}
		tempSeconds += X/(2 + F*i) + C/2;
		minSeconds = Math.min(minSeconds,tempSeconds);
	    }	    
	    return minSeconds;
	}
}