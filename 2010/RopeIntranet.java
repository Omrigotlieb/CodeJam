import java.util.*;
import java.io.*;

public class RopeIntranet {

	final static String FNAME = "A-small-practice";

	//public BufferedReader in;
	public Scanner in;
	public PrintWriter out;

	void open() throws IOException {
	//	in = new BufferedReader( new FileReader( new File( FNAME + ".in" ) ) );
		File file = new File( FNAME + ".in" );
		in = new Scanner(file);
		//out = new PrintWriter( new File( FNAME + ".out" ) );
		out = new PrintWriter( new File( "output.txt" ) );
	}

	void close() throws IOException {
		out.close();
	}

	void run() throws IOException {
		
				
		int n = in.nextInt();
		
		for ( int test = 1; test <= n; test ++ ) {
		    int counter = 0;
		    Map<Integer,Integer> tm = Collections.synchronizedMap(
			    new TreeMap<Integer,Integer>());
		    int windows = in.nextInt();
			for (int i = 0; i < windows; i++) {
			    tm.put(in.nextInt(), in.nextInt());
			}
			for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
			    Integer key = entry.getKey();
			    Integer value = entry.getValue();
			    for(Map.Entry<Integer, Integer> entry1 : tm.entrySet()) {
				    Integer key1 = entry1.getKey();
				    Integer value1 = entry1.getValue();
				    if(key1 > key && value > value1){
					counter++;
				    }
			    }
			}
			out.println( "Case #" + test + ": " + counter);
		}
	}

	public static void main( String[] args ) throws IOException {
		new Thread() {

			public void run() {
				try {
					RopeIntranet solution = new RopeIntranet();
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
