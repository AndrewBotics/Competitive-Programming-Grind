import java.io.*;
import java.util.*;

public class candycanefeast {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int m = s.nextInt();
		long[] cows = new long[n];
		for (int i = 0; i<n; i++){
			cows[i] = s.nextInt();
		}
		for (int going = 0; going<m; going++){
			long cane = s.nextInt();
			long upTo = 0;
			for (int i = 0; i<n && upTo<cane; i++){
				if (cows[i]>upTo){
					long eaten = Math.min(cane - upTo, cows[i] - upTo);
					cows[i] += eaten;
					upTo += eaten;
				}
			}
		}
		for (long i : cows) pw.println(i);
		pw.close();
	}
}