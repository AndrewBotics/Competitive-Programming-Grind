// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CountingRectangles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long[][] rects = new long[1001][1001];
            for (int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rects[a][b]+=((long)a)*b;
            }
            //for (int[] arr : rects) pw.println(Arrays.toString(arr));
            //pw.println();

            long[][] pf = new long[1001][1001];
            for (int i = 1; i<1001; i++){
                for (int j = 1; j<1001; j++){
                    pf[i][j] = pf[i-1][j]+pf[i][j-1]-pf[i-1][j-1]+rects[i][j];
                }
            }

            for (int i = 0; i<q; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                pw.println(pf[c-1][d-1]-pf[c-1][b]-pf[a][d-1]+pf[a][b]);
            }
        }
		pw.close();
	}
}
