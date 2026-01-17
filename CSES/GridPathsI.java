// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class GridPathsI {
    public static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i<n; i++) grid[i] = s.next().toCharArray();
        long[][] paths = new long[n][n];
        paths[0][0] = (grid[0][0]=='*' || grid[n-1][n-1]=='*')?0:1;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j]!='*'){
                    if (i>0) paths[i][j] = (paths[i][j]+paths[i-1][j])%MOD;
                    if (j>0) paths[i][j] = (paths[i][j]+paths[i][j-1])%MOD;
                }
            }
        }
        pw.println(paths[n-1][n-1]);
        //for (char[] arr : grid) pw.println(Arrays.toString(arr));
        //for (int[] arr : paths) pw.println(Arrays.toString(arr));
		pw.close();
	}
}
