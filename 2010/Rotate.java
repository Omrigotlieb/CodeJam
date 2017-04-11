import java.util.*;
import java.io.*;

public class Rotate {

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
		for ( int test = 1; test <= T; test ++ ) {
		    int N = in.nextInt();
		    int K = in.nextInt();
		    in.nextLine();
		    char[][] matrix = new char[N][N];
		    boolean empty = true;
		    for (int i = 0; i < N; i++) {
			String line = in.nextLine();
			for (int j = 0; j < N; j++) {
			    matrix[i][j] = line.charAt(j);
			    if(matrix[i][j] != '.'){
				empty = false;
			    }
			}
		    }
		    if(empty){
			out.println( "Case #" + test + ": Neither");
		    } else {
			String answer = whoWon(gravity(rotate(matrix)),K);    
			out.println( "Case #" + test + ": " + answer);
		}
		}
	}

	public static char[][] rotate(char[][] matrix){
	    int len = matrix.length;
	    char[][] result = new char[len][len]; 
	    for (int i = 0; i < len; i++) {
		for (int j = 0; j < len; j++) {
		    result[i][j] = matrix[len-1-j][i];
		}
	    }
	return result;
	}
	
	public static char[][] gravity(char[][] matrix){
	    int len = matrix.length;
	    char[][] result = new char[len][len];
	    System.arraycopy(matrix, 0, result, 0, len);
	    for (int j = 0; j < len; j++) {
		for (int i = 1; i < len; i++) {
		    if(result[i][j] == '.'){
			for (int k = i; k > 0 ; k--) {   
			    result[k][j] = result[k-1][j];
			}
			result[0][j] = '.';
		    }
		}
	    }

	    for (int i = 0; i < result.length; i++) {
		for (int j = 0; j < result.length; j++) {
		}
	    }
	return result;
	}
	
	
	public static String whoWon(char[][] matrix,int k){
	    int len = matrix.length;
	    boolean Rwon = false;
	    boolean Bwon = false;

	    //Check rows
	    for (int i = 0; i < len; i++) {
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb1 = new StringBuilder("");
		for (int j = 0; j < len; j++) {
		    sb.append(matrix[i][j]);
		    sb1.append(matrix[j][i]);
		}
		Rwon |= sb.toString().matches(".*[R]{" + k + ",}.*");
		Bwon |= sb.toString().matches(".*[B]{" + k + ",}.*");
		Rwon |= sb1.toString().matches(".*[R]{" + k + ",}.*");
		Bwon |= sb1.toString().matches(".*[B]{" + k + ",}.*");
	    }
	    
	    
	  //Check diagonals
	    for (int i = len-k; i >= 0; i--) {
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb1 = new StringBuilder("");
		for (int l = i, j = 0; l < len; l++, j++) {
		    sb.append(matrix[l][j]);
		    sb1.append(matrix[l][len-1-j]);
		}
		Rwon |= sb.toString().matches(".*[R]{" + k + ",}.*");
		Bwon |= sb.toString().matches(".*[B]{" + k + ",}.*");
		Rwon |= sb1.toString().matches(".*[R]{" + k + ",}.*");
		Bwon |= sb1.toString().matches(".*[B]{" + k + ",}.*");
	    }
	    
	    if(Rwon && Bwon){
		return "Both";
	    }
	    if(Rwon){
		return "Red";
	    }
	    if(Bwon){
		return "Blue";
	    }
	    return "Neither";
	}
	public static void main( String[] args ) throws IOException {
		new Thread() {

			public void run() {
				try {
					Rotate solution = new Rotate();
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
