// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MakeableValues {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i<n; i++){
            coins[i] = s.nextInt();
        }

        // this part upsolved from usaco guide internal sol
        int[][] dp = new int[k+1][k+1];
        dp[0][0] = 1;
        for (int a : coins){
            int[][] next = new int[k+1][k+1];
            for (int i = 0; i<=k; i++) System.arraycopy(dp[i], 0, next[i], 0, k+1);
            for (int i = 0; i<=k; i++){
                for (int j = 0; j<=k; j++){
                    if (i>=a) next[i][j] |= dp[i-a][j];
                    if (j>=a) next[i][j] |= dp[i][j-a];
                }
            }
            dp = next;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i<=k; i++){
            if (dp[i][k-i]==1) ret.add(i);
        }
        pw.println(ret.size());
        for (int i : ret){
            pw.print(i+" ");
        }
		pw.close();
	}
}
