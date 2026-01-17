// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SublimeSeq {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int x = s.nextInt();
            int n = s.nextInt();
            pw.println(n%2==0?0:x);
        }
		pw.close();
	}
}
