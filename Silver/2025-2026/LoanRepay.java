// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LoanRepay {
	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("loan.in"));
        //PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw = new PrintWriter("loan.out");
        long n = s.nextLong();
        long k = s.nextLong();
        long m = s.nextLong();

        long lo = 1;
        long hi = 1000000000000L;
        while (lo<hi){
            long mid = (lo+hi+1)/2;
            if (computeDays(mid, n, k, m)) lo = mid;
            else hi = mid-1;
        }
        pw.println(lo);
		pw.close();
	}
    public static boolean computeDays(long x, long n, long k, long m){
        long curr = 0;
        while (curr<n && k>0){
            long y = (n-curr)/x;
            if (y<m) {
                long temp = (n-curr+m-1)/m;
                return temp<=k;
            }
            long max = n-x*y;
            long days = (max-curr)/y+1;
            if (days>k) days = k;
            curr += y*days;
            k -= days;
        }
        return curr>=n;
    }
}
