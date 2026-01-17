import java.io.*;
import java.util.*;

public class subsequence7 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("div7.in"));
		PrintWriter pw = new PrintWriter(new File("div7.out"));
		int n = s.nextInt();
		long[] cows = new long[n+1];
		for (int i = 1; i<=n; i++){
			cows[i] = (long) cows[i-1]+s.nextInt();
		}
		int ret = 0;
		for (int i = 0; i<n; i++){
			for (int j = i+1; j<=n; j++){
				if ((cows[j]-cows[i])%7==0) {
					if (j-i>ret) ret = j-i;
				}
			}
		}
		pw.println(ret);
		pw.close();
	}
}