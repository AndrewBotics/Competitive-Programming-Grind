import java.io.*;
import java.util.*;

public class watchingmooloo {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int k = s.nextInt();
		long[] days = new long[n];
		for (int i = 0; i<n; i++) days[i] = s.nextLong();
		long ans = 0;
		long curr = k+1;
		for (int i = 0; i<n-1; i++){
			if (days[i+1]-days[i]>k){
				ans += curr;
				curr = k+1;
			}
			else {
				curr += days[i+1]-days[i];
			}
		}
		ans += curr;
		pw.println(ans);
		pw.close();
	}
}