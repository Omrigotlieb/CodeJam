import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class StandingOvation {

    public static void main(String[] args) throws FileNotFoundException {
	//Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File("sample.txt");
	Scanner in = new Scanner(file);
	int t = in.nextInt();
	int result;
	for (int i = 1; i <= t; ++i) {
	      int size = in.nextInt();
	      String str = in.nextLine();
	      result = Solver(str.substring(1),size + 1);
	      System.out.println("Case #" + i + ": " + result);
	    }	
	in.close();
	out.close();
    }
    
    public static int Solver(String str,int size){
	int pplCounter = Integer.parseInt(str.charAt(0)+"");
	int friendsCounter = 0;    
	for (int i = 1; i < size; i++) {
	    int currentShy = Integer.parseInt(str.charAt(i)+"");
	    int diff =  i - pplCounter;
	    if(diff > 0){
		friendsCounter += diff;
		pplCounter += diff;
	    }
	    pplCounter += currentShy;
	}
	return friendsCounter;
    }
}
