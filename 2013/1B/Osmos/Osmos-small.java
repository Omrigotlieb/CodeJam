import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Osmos-small {

    private static PrintStream out;
    public static final String NAME = "C-small-practice.in";
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
	    int N = in.nextInt();
	    int[] arr = new int[N];
	    for (int j = 0; j < N; j++) {
		arr[j] = in.nextInt();
	    }
	    Arrays.sort(arr);
	    int result = solve(arr,A,0);
	    System.out.println("Case #" + i + ": " + result);
	}	
	in.close();
	out.close();
	System.exit(0);
    }

    
    public static int solve(int[] arr, int A,int location){
	int N = arr.length;
	if(N == location) return 0;
	if(A == 1) return arr.length;
	int counter = 0;
	for (int i = location; i < N ; i++) {
	    if(A > arr[i]){
		A += arr[i];
	    } else {
		int temp = 1;
		int tempA = A + (A-1);
		while(tempA < arr[i]){
		    tempA += tempA - 1;
		    temp++;
		    
		}
		return counter += Math.min(temp + solve(arr,tempA,i), 1 + solve(arr,A,i+1));
	    }
	}
	return counter;
    }
}