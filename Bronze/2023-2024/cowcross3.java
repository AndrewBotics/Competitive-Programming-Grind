import java.util.*;
import java.io.*;

class cowcross3 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));
		int n = s.nextInt();
		int[][] cows = new int[n][2];
		for (int i = 0; i < n; i++) {
			cows[i][0] = s.nextInt();
			cows[i][1] = s.nextInt();
		}
		cows = twosort(cows);
		int time = cows[0][0];
		for (int i = 0; i<n; i++){
			if (i!=n-1) time = Math.max(time+cows[i][1], cows[i+1][0]);
			else time = Math.max(time+cows[i][1], cows[i][0]);
		}
		pw.println(time);
		pw.close();
	}
	static int[][] twosort(int[][] a) {
		int[][] ret = new int[a.length][2];
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) b[i] = a[i][0];
		Arrays.sort(b);
		for (int i = 0; i < a.length; i++) ret[i][0] = b[i];
		for (int i = 0; i < a.length; i++) {
			boolean found = false;
			for (int j = 0; j < a.length; j++) {
				if (!found && a[j][0] == ret[i][0]) {
					ret[i][1] = a[j][1];
					a[j][0] = -1;
					found = true;
				}
			}
		}
		return ret;
	}
}