// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ZeroOneEasy {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            long x = s.nextInt();
            long y = s.nextInt();
            char[] a = s.next().toCharArray();
            char[] b = s.next().toCharArray();
            long ct = 0;
            for (int i = 0; i<n; i++){
                if (a[i]!=b[i]) ct++;
            }

            if (ct%2==1) pw.println(-1);
            else if (ct==2){
                int l;
                int r;
                for (l = 0; a[l]==b[l];) l++;
                for (r=n-1; a[r]==b[r];) r--;
                if (l+1==r) pw.println(Math.min(x, 2*y));
                else pw.println(Math.min((r-l)*x, y));
            }
            else {
                pw.println(ct/2*y);
            }
        }
		pw.close();
	}
}
