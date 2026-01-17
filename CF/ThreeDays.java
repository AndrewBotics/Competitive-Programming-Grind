// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ThreeDays {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = str.length();
        PrintWriter pw = new PrintWriter(System.out);

        int[][] list = new int[10][n];
        for (int i = 0; i<n; i++){
            list[str.charAt(i)-'0'][i]++;
        }

        int[][] index = new int[10][n+1];
        for (int i = 1; i<=n; i++){
            for (int j = 0; j<10; j++){
                index[j][i] = index[j][i-1]+list[j][i-1];
            }
        }
        //for (int[] l : index) pw.println(Arrays.toString(l));

        int ret = 0;
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n; j++){
                boolean works = true;
                for (int k = 0; k<10&&works; k++) if ((index[k][j+1]-index[k][i])%2==1) works = false;
                if (works) ret++;
            }
        }
        pw.println(ret);
		pw.close();
	}
}
