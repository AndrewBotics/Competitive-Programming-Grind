// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MaximalBinaryMatrix {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int k = s.nextInt();
        if (k>n*n) pw.println(-1);
        else {
            int[][] nums = new int[n][n];
            int row = 0;
            int col = 0;
            while (k>0){
                if (row==col) {
                    nums[row][col]++;
                    k--;
                }
                else {
                    if (k>1) {
                        nums[row][col]++;
                        nums[col][row]++;
                        k-=2;
                    }
                }
                row++;
                if (row==n) {
                    col++;
                    row = col;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int[] num : nums) {
                for (int x : num) sb.append(x).append(" ");
                sb.append("\n");
            }
            pw.println(sb.toString());
        }
		pw.close();
	}
}
