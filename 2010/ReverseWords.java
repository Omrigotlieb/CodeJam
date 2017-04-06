import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class ReverseWords {
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
	in.nextLine();
	for (int i = 1; i <= t; i++) {
	    String inputString = in.nextLine();
	    String[] str = inputString.split("\\s+");
	    System.out.print("Case #" + i + ": ");
	    for (int word = str.length - 1; word >= 0; word--) {
		System.out.print(str[word] + " ");
	    }
	    System.out.println();
	}	
	in.close();
	out.close();
	System.exit(0);
    }

    public static String solve(int[] items, int credit){
	HashMap hs = new HashMap();
	String str = "";
	for (int i = 0; i < items.length; i++) {
	    if(hs.containsKey(credit - items[i])){
		str = hs.get(credit - items[i]) + " " +   ++i;
		return str;
	    }
	    hs.put(items[i],i + 1);
	}
	return str;
    }
}
