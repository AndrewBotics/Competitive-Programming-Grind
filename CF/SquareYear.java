// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SquareYear {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        for (int i = 0; i<n; i++){
            int st = s.nextInt();
            int rt = (int) Math.round(Math.sqrt(st));
            if (st==0) pw.println(0+" "+0);
            else if (rt*rt==st) pw.println(1+" "+(rt-1));
            else pw.println(-1);
        }
		pw.close();
	}
}
