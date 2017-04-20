import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SenateEvacuation {

    private static PrintStream out;
    public static final String NAME = "C-small-practice.in";
    public static final String NAME1 = "sample.txt";
    public static void main(String[] args) throws IOException {
	out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File(NAME1);
	Scanner in = new Scanner(file);
	
	int T = in.nextInt();
	for (int i = 1; i <= T; i++) {
	    int N = in.nextInt();
	    int[] arr = new int[N];
	   int sum = 0;
	    for (int j = 0; j < N; j++) {
		arr[j] = in.nextInt();
		sum += arr[j];
	    }
	    String result = solve(arr,sum);
	    System.out.println("Case #" + i + ": " + result);
	}	
	in.close();
	out.close();
	System.exit(0);
    }

    public static int[] twoLargest(int values[]){
	int[] result = new int[2];
	int largestA = -1;
	int largestB = -1;
	int locationA =-1;
	int locationB = -1;
	for(int i = 0; i < values.length; i++){
	        if(values[i] > largestA){
	            largestB = largestA;
	            largestA = values[i];
	            locationB = locationA;
	            locationA = i;
	            
	        }
	        else{
	            if (values[i] > largestB) {
	            largestB = values[i];
	            locationB = i;
	            }
	        }
	     }
	result[0] = locationA;
	result[1] = locationB;
	return result;
    }
    
    public static String solve(int[] arr, int sum){
	StringBuilder sb = new StringBuilder("");
	int[] largestLocation = new int[2];
	for (int i = 0; i < sum-1; i = i+2) {
	    sb.append(" ");
	    largestLocation = twoLargest(arr);
	    char tempcharA = (char) ('A' + largestLocation[0]);
	    char tempcharB = (char) ('A' + largestLocation[1]);
	    arr[largestLocation[0]]--;
	    arr[largestLocation[1]]--;
	    sb.append(tempcharA + "" + tempcharB);
	}
	for (int i = 0; i < arr.length; i++) {
	    if(arr[i] != 0){
		char c = (char) ('A' + i);
		sb.append(" " + c);
	    }
	}
	return sb.reverse().toString();
    }
}