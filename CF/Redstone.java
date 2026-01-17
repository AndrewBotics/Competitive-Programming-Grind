// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Redstone {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int[] counts = new int[105];
            int n = s.nextInt();
            for (int i = 0; i<n; i++){
                counts[s.nextInt()]++;
            }
            //pw.println(Arrays.toString(counts));
            boolean ret = false;
            for (int i : counts){
                if (i>=2) ret = true;
            }
            pw.println(ret?"YES":"NO");
        }

        pw.close();
	}
}
