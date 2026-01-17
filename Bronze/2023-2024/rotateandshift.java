import java.io.*;
import java.util.*;

public class rotateandshift {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int k = s.nextInt();
		int t = s.nextInt();
		int[] a = new int[k+1];
		for (int i = 0; i<k; i++){
			a[i] = s.nextInt();
		}
		a[k] = n;
		int[] ans = new int[n];
		for (int i = 0; i<n; i++){
			ans[i] = i;
		}
		for (int i = 0; i<k; i++){
			for (int j = a[i]; j<a[i+1]; j++){
				int tPrime = t-(j-a[i]+1);
				int end = j;
				if (tPrime >= 0){
					int inc = 1 + tPrime / (a[i+1]-a[i]);
					end = (j + inc * (a[i+1]-a[i])) % n;
				}
				ans[end] = j;
			}
		}
		for (int i : ans){
			if (i!=ans[0]) pw.print(" ");
			pw.print(i);
		}
		pw.close();
	}
}