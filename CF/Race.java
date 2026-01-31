// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Race {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        for (int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();

            int x = Math.min(b, c);
            int y = Math.max(b, c);
            if (a<x || a>y) pw.println("YES");
            else pw.println("NO");
        }
		pw.close();
	}
}
