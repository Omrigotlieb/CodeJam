import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MagicTrick {

    public static void main(String[] args) throws FileNotFoundException {
	//Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
	PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	System.setOut(out);
	File file = new File("sample.txt");
	Scanner in = new Scanner(file);
	int t = in.nextInt();
	String result;
	for (int i = 1; i < t+1; ++i) {
	    int answer = in.nextInt();
	    HashSet<Integer> hs = new HashSet<Integer>();
	    for (int j = 1; j < 5; j++) {
		for (int j2 = 1; j2 < 5; j2++) {
		    if(j == answer){
			hs.add(in.nextInt());
			continue;
		    }
		    in.nextInt();
		}
	    }
	    int answer2 = in.nextInt();
	    HashSet hs2 = new HashSet();
	    for (int j = 1; j < 5; j++) {
		for (int j2 = 1; j2 < 5; j2++) {
		    if(j == answer2){
			hs2.add(in.nextInt());
			continue;
		    }
		    in.nextInt();
		}
	    }
	    int counter = 0;
	    int temp = 0;
	    for(Integer num: hs){
		if(hs2.contains(num)){
		    counter++;
		    temp = num;
		}
	    }
	    if (counter > 1){
		counter = 2;
	    }
	    switch(counter){
	    case 0:
		System.out.println("Case #" + i + ": " + "Volunteer cheated!");
		break;
	    case 1:
		System.out.println("Case #" + i + ": " + temp);
		break;
	    case 2:
		System.out.println("Case #" + i + ": " + "Bad magician!");
		break;
	    }
	}	
	in.close();
	out.close();
    }
}