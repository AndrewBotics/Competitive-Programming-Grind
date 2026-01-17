// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FJFavorite {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int m = s.nextInt();
            int[] mods = new int[n];
            for (int i = 0; i<n; i++){
                mods[i] = s.nextInt()%m;
            }
            Arrays.sort(mods);

            int[] mods2 = new int[2*n];
            for (int i = 0; i<n; i++){
                mods2[i] = mods[i];
                mods2[i+n] = mods2[i]+m;
            }
            
            long[] prefix = new long[2*n+1];
            for (int i = 0; i<2*n; i++) prefix[i+1] = prefix[i]+mods2[i];
            //pw.println(Arrays.toString(prefix));

            long ans = Long.MAX_VALUE;
            for (int i = 0; i<n; i++){
                ans = Math.min(ans, prefix[i+n]-prefix[i+n-n/2]-prefix[i+n/2]+prefix[i]);
            }
            pw.println(ans);
        }
		pw.close();
	}
}
