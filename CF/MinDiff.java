// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MinDiff {
    public static int n;
    public static long k;
    public static long[] nums;
    public static long[] prefix;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = s.nextInt();
        k = s.nextLong();
        nums = new long[n];
        for (int i = 0; i<n; i++) nums[i] = s.nextInt();
        Arrays.sort(nums);
        prefix = new long[n+1];
        for (int i = 0; i<n; i++) prefix[i+1] = prefix[i]+nums[i];
        //pw.println(Arrays.toString(prefix));

        long l = 0, r = 1000000000;
        while (l<r) {
            long mid = l+(r-l)/2;
            if (works(mid)) r = mid;
            else l = mid+1;
        }
        pw.println(l);
		pw.close();
	}
    public static boolean works(long mid){
        for (int lp = 0; lp<n; lp++){
            long target = nums[lp]+mid;
            int rp = upperBound(nums, target);
            long count = (long) lp*nums[lp]-prefix[lp]+(prefix[n]-prefix[rp]) - (long) (n-rp) * (nums[lp]+mid);
            if (count<=k) return true;
        }
        for (int rp = 0; rp<n; rp++){
            long target = nums[rp]-mid;
            int lp = upperBound(nums, target);
            long count = (long) lp * (nums[rp]-mid) - prefix[lp] + (prefix[n]-prefix[rp]) - (long) (n-rp) * nums[rp];
            if (count<=k) return true;
        }
        return false;
    }

    public static int lowerBound(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static int upperBound(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
