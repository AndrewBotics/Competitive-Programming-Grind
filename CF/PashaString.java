// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class PashaString {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String str = s.next();
        int m = s.nextInt();
        int n = str.length();
        int[] pf = new int[n/2+2];
        for (int i = 0; i<m; i++){
            int a = s.nextInt();
            if (a<=n/2) pf[a]++;
            else pf[n-a+1]++;
        }

        StringBuilder ret = new StringBuilder(str);
        int ct = 0;
        for (int i = 1; i<=n/2; i++){
            ct+=pf[i];
            if (ct%2==1) {
                char c = ret.charAt(i-1);
                ret.setCharAt(i-1, ret.charAt(n-i));
                ret.setCharAt(n-i, c);
            }
        }
        pw.println(ret);
		pw.close();
	}
}
