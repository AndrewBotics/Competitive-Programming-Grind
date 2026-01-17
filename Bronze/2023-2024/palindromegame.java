import java.io.*;
import java.util.*;

public class palindromegame {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		while (n>0){
			String x = s.next();
			if (x.charAt(x.length()-1)=='0') pw.println('E');
			else pw.println('B');
			n--;
		}
		pw.close();
	}
}