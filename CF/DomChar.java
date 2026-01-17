// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DomChar {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            String str = s.next();
            boolean[] checks = new boolean[7];
            for (int i = 0; i<n-1; i++) if (str.substring(i, i+2).equals("aa")) checks[0] = true;
            for (int i = 0; i<n-2; i++) if (str.substring(i, i+3).equals("aba")) checks[1] = true;
            for (int i = 0; i<n-2; i++) if (str.substring(i, i+3).equals("aca")) checks[2] = true;
            for (int i = 0; i<n-3; i++) if (str.substring(i, i+4).equals("abca")) checks[3] = true;
            for (int i = 0; i<n-3; i++) if (str.substring(i, i+4).equals("acba")) checks[4] = true;
            for (int i = 0; i<n-6; i++) if (str.substring(i, i+7).equals("abbacca")) checks[5] = true;
            for (int i = 0; i<n-6; i++) if (str.substring(i, i+7).equals("accabba")) checks[6] = true;
            if (checks[0]) pw.println(2);
            else if (checks[1]) pw.println(3);
            else if (checks[2]) pw.println(3);
            else if (checks[3]) pw.println(4);
            else if (checks[4]) pw.println(4);
            else if (checks[5]) pw.println(7);
            else if (checks[6]) pw.println(7);
            else pw.println(-1);
        }
		pw.close();
	}
}
