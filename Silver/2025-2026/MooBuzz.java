// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MooBuzz {
    public static long[] pos = {1, 2, 4, 7, 8, 11, 13, 14};
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("moobuzz.in"));
        PrintWriter pw = new PrintWriter("moobuzz.out");
        long n = s.nextLong();
        long cycles = (n-1)/8L;
        int ind = (int)((n-1)%8L);
        pw.println(cycles*15L+pos[ind]);
		pw.close();
	}
}
