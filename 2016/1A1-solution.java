import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class TheLastWord {
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
	    String str = in.next(); 
	    String result = solve(str);
	    System.out.println("Case #" + i + ": " + result);
	}	
	in.close();
	out.close();
	System.exit(0);
    }

    public static String solve(String str){
	StringBuilder sb = new StringBuilder("");
	char first = str.charAt(0);
	sb.append(first);
	for (int i = 1; i < str.length(); i++) {
	    char temp = str.charAt(i);
	    if(temp >= first){
		sb.insert(0,temp);
		first = temp;
	    }else {
		sb.append(temp);
	    }
	}
	return sb.toString();
}
}
