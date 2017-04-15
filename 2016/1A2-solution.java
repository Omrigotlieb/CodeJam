import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;


public class RankAndFile {
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
	    int N = in.nextInt();
	    int[] arr = new int[2600];
	    for (int j = 0; j < 2*N-1; j++) {
		for (int j2 = 0; j2 < N; j2++) {
		    arr[in.nextInt()] ^= 1;
		}
	    }
	    System.out.print("Case #" + i + ": ");
	    for (int j = 0; j < arr.length; j++) {
		if(arr[j] == 1){
		    System.out.print(j + " ");
		}
	    }
	    System.out.println();
	    
	    
	}	
	in.close();
	out.close();
	System.exit(0);
    }


    

}
