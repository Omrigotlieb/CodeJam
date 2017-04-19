import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class NewLotteryGame{

    private static PrintStream out;
    //public static final String NAME = "B-small-practice.in";
    public static final String NAME1 = "sample.txt";
    public static void main(String[] args) throws IOException {
//	Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File(NAME1);
	Scanner in = new Scanner(file);
	
	int T = in.nextInt();
	for (int i = 1; i <= T; i++) {
	    int A = in.nextInt();
	    int B = in.nextInt();
	    int K = in.nextInt();
	    int result = solve(A,B,K);
	    System.out.println("Case #" + i + ": " + result);
	}	
	in.close();
	out.close();
	System.exit(0);
    }

    
    public static int solve(int A, int B, int K){
	int counter = 0;
	for (int i = 0; i < A; i++) {
	    for (int j = 0; j < B; j++) {
		if((i&j) < K){
		    counter++;
		}
	    }
	}
	return counter;
    }
}