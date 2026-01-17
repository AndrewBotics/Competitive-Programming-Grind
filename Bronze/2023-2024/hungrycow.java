import java.io.*;
import java.util.*;

public class hungrycow {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		long t = s.nextLong();
		long remaining = 0, total = 0, last = 0;
		for (int i = 0; i<n; i++){
			long d = s.nextLong();
			long b = s.nextLong();
			total += b;
			remaining -= d - last;
			last = d;
			remaining = Math.max(remaining, 0) + b;
		}
		long d = t+1;
		remaining -= d - last;
		remaining = Math.max(remaining, 0);
		pw.println(total-remaining);
		pw.close();
	}
}