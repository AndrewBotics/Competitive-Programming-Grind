import java.io.*;
import java.util.*;

public class maxproductivity {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int q = s.nextInt();
		int[] c = new int[n];
		for (int i = 0; i<n; i++) c[i] = s.nextInt();
		for (int i = 0; i<n; i++) c[i] -= s.nextInt();
		Arrays.sort(c);

		for (int i = 0; i<n; i++){
			int v = s.nextInt();
			int s1 = s.nextInt();
			int ans = -1;
			if (c[n-v]>s1) pw.println("YES");
			else pw.println("NO");
		}
		pw.close();
	}
}