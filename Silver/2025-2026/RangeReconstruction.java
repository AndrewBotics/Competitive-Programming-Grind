// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RangeReconstruction {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] ans = new int[n];
        int[][] diffs = new int[n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n-i; j++) diffs[i][j] = s.nextInt();
        }
        //for (int[] arr : diffs) pw.println(Arrays.toString(arr));
        for (int i = n-2; i>=0; i--){
            ans[i] = ans[i+1] + diffs[i][1];
            if (!works(i, n, ans, diffs)) ans[i] = ans[i+1]-diffs[i][1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans[0]);
        for (int i = 1; i<n; i++) sb.append(" ").append(ans[i]);
        pw.println(sb);
		pw.close();
	}
    public static boolean works(int i, int n, int[] ans, int[][] diffs){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = i; j<n; j++){
            max = Math.max(max, ans[j]);
            min = Math.min(min, ans[j]);
            if (max-min!=diffs[i][j-i]) return false;
        }
        return true;
    }
}
