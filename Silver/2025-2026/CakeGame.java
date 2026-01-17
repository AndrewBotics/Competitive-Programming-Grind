// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CakeGame {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            long[] pref = new long[n+1];
            for (int i = 1; i<=n; i++) pref[i] = pref[i-1]+s.nextInt();
            long min = Long.MAX_VALUE;
            for (int i = n/2+1; i<=n; i++){
                min = Math.min(min, pref[i]-pref[i-n/2-1]);
            }
            pw.println(min+" "+(pref[n]-min));
        }
		pw.close();
	}
}
