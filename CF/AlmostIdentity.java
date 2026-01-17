// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class AlmostIdentity {
    public static int[] DER = new int[]{1, 0, 1, 2, 9};
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int a = s.nextInt();
        int b = s.nextInt();
        long ret = 0;
        long curr = 1;
        for (int i = 0; i<=b; i++){
            ret += curr*DER[i];
            curr = curr*(a-i)/(i+1);
        }
        pw.println(ret);
		pw.close();
	}
}
