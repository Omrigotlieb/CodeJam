import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MinimumScalarProduct {
    private static PrintStream out;
    public static final String NAME = "C-small-practice.in";
    public static final String NAME1 = "sample.txt";
    
    public static void main(String[] args) throws IOException {
	//Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File(NAME1);
	Scanner in = new Scanner(file);
	int t = in.nextInt();
	for (int i = 1; i <= t; i++) {
	    int n = in.nextInt(); 
	    ArrayList<Long> arrList1 = new ArrayList<Long>();
	    ArrayList<Long> arrList2 = new ArrayList<Long>();
	    for (int j = 0; j < n; j++) {
		arrList1.add((long) in.nextInt());
	    }
	    for (int j1 = 0; j1 < n; j1++) {
		arrList2.add((long) in.nextInt());
	    }
	    Collections.sort(arrList1);
	    Collections.sort(arrList2);
	    long sum = 0;
	    for (int k = 0; k < n; k++) {
		sum += arrList1.get(k)*arrList2.get(n-k-1);
	    }
	    System.out.println("Case #" + i + ": " + sum);
	}	
	in.close();
	out.close();
	System.exit(0);
    }
}
