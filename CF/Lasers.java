// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Lasers {
	public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            long n = s.nextLong();
            long m = s.nextLong();
            long x = s.nextLong();
            long y = s.nextLong();
            pw.println(n+m);
            for (int i = 0; i<n; i++) s.nextInt();
            for (int i = 0; i<m; i++) s.nextInt();
        }
		pw.close();
	}
}
