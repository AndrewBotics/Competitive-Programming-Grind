// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SpacedOut {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i<n; i++) for (int j = 0; j<n; j++) nums[i][j] = s.nextInt();
        int[][] hors = new int[2][n];
        int[][] vers = new int[2][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                hors[i%2][j] += nums[i][j];
                vers[j%2][i] += nums[i][j];
            }
        }
        //pw.println(Arrays.toString(hors[0]));
        //pw.println(Arrays.toString(hors[1]));
        //pw.println(Arrays.toString(vers[0]));
        //pw.println(Arrays.toString(vers[1]));
        int horCt = 0;
        int verCt = 0;
        for (int i = 0; i<n; i++){
            horCt += Math.max(hors[0][i], hors[1][i]);
            verCt += Math.max(vers[0][i], vers[1][i]);
        }
        pw.println(Math.max(horCt, verCt));
		pw.close();
	}
}
