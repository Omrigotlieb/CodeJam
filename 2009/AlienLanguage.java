import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.*;  


public class AlienLanguage {
    private static PrintStream out;
    public static final String NAME = "C-small-practice.in";
    public static final String NAME1 = "sample.txt";
    
    public static void main(String[] args) throws IOException {
	//Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File(NAME1);
	Scanner in = new Scanner(file);
	int L = in.nextInt();
	int D = in.nextInt();
	int N = in.nextInt();
	in.nextLine();
	String[] dict = new String[D];
	for (int i = 0; i < dict.length; i++) {
	    dict[i] = in.nextLine();
		}
	for (int i = 1; i <= N; i++) {
	    int counter = 0;
	    String patternString = in.nextLine();
	    patternString = patternString.replaceAll("\\(", "\\[");
	    patternString = patternString.replaceAll("\\)", "\\]");
	    Pattern pattern = Pattern.compile(patternString);
	    for(String s : dict){
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()){
		    counter++;
		}
	    }
	    System.out.println("Case #" + i + ": " + counter);
	}	
	in.close();
	out.close();
	System.exit(0);
    }
}
