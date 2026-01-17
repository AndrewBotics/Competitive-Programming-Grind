// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class TransformPairs {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            pw.println(solve(s.nextLong(), s.nextLong(), s.nextLong(), s.nextLong()));
        }
		pw.close();
	}
    public static long solve(long a, long b, long c, long d){
        long ops = 0;
        while (true){
            if (a==c && b==d){
                return ops;
            }
            if (c<d){
                long temp = b;
                b = a;
                a = temp;

                temp = d;
                d = c;
                c = temp;
            }
            if (a>c || b>d || d==0) {
                return -1;
            }
            if (b==d && (c-a)%d==0){
                ops += (c-a)/d;
                return ops;
            }
            ops += (c-a)/d;
            c%=d;
        }
    }
}
