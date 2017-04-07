import java.util.*;
import java.io.*;

public class AllYourBase {

    final static String FNAME = "A-small-practice";
    public Scanner in;
    public PrintStream out;

    void open() throws IOException {
	//	in = new BufferedReader( new FileReader( new File( FNAME + ".in" ) ) );
	File file = new File( FNAME + ".in" );
	in = new Scanner(file);
	//	out = new PrintWriter( new File( FNAME + ".out" ) );
	out = new PrintStream(new FileOutputStream("output.txt"));
    }

    void close() throws IOException {
	out.close();
    }

    void run() throws IOException {
	int T = in.nextInt();
	in.nextLine();
	for ( int test = 1; test <= T; test ++ ) {
	    String line = in.nextLine();
	    long secondsTillWar = solve(line);   
	    out.println("Case #" + test + ": " + secondsTillWar);
	}
    }

    public static long solve(String str){
	HashMap dict = new HashMap();
	StringBuilder sb = new StringBuilder("");
	dict.put(str.charAt(0), '1');   
	boolean flag = true;
	char[] letters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	int counter = 2;
	for (int i = 0; i < str.length(); i++) {
	    char c = str.charAt(i);
	    if(!dict.containsKey(c)) {
		if(flag){
		    dict.put(c, '0');
		    flag = false;
		} else {
		    dict.put(c, letters[counter]);  
		    counter++;
		}	
	    }
	
	}
	for (int i = 0; i < str.length(); i++) {
	    sb.append(dict.get(str.charAt(i)));
	}
	String temp = sb.toString();
    long result = Long.parseLong(temp,counter);
    return result;
}

public static void main( String[] args ) throws IOException {
    new Thread() {

	public void run() {
	    try {
		AllYourBase solution = new AllYourBase();
		solution.open();
		solution.run();
		solution.close();
	    } catch ( Exception e ) {
		throw new RuntimeException( e );
	    }
	}
    }.start();
}
}
