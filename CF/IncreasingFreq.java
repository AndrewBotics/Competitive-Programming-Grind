// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class IncreasingFreq {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int[] dp = new int[500001];
        int n = s.nextInt();
        int k = s.nextInt();
        int max = 0;
        int ct = 0;
        for (int i = 0; i<n; i++){
            int c = s.nextInt();
            if (c==k) ct++;
            else dp[c] = Math.max(dp[c], ct)+1;
            max = Math.max(max, dp[c]-ct);
        }
        pw.println(max+ct);
		pw.close();
	}
}
