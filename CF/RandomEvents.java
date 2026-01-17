// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RandomEvents {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

            int lastCorrectPos = n-1;
            while (lastCorrectPos>=0 && a[lastCorrectPos]==lastCorrectPos+1) lastCorrectPos--;

            double notProb = 1.0;
            if (lastCorrectPos==-1) notProb = 0.0;
            for (int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken())-1;
                double p = 1-Double.parseDouble(st.nextToken());
                if (r>=lastCorrectPos) notProb *= p;
            }
            pw.printf("%.6f\n", 1-notProb);
        }
		pw.close();
	}
}
