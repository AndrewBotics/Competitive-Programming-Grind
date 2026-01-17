// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SetOrDecrease {
    public static long n;
    public static long threshold;
    public static long[] nums;
    public static long[] pref;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        long t = Long.parseLong(br.readLine());
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            threshold = -Long.parseLong(st.nextToken());
            nums = new long[(int)n];
            for (long i = 0; i<n; i++){
                nums[(int)i] = Long.parseLong(st2.nextToken());
                threshold += nums[(int)i];
            }
            Arrays.sort(nums);
            //pw.println(Arrays.toString(nums));
            //pw.println(threshold);

            pref = new long[(int)n+1];
            for (long i = n-1; i>=0; i--) pref[(int)i] = pref[(int)i+1] + nums[(int)i];

            long l = 0;
            long r = (long) 1e18;
            long ans = 0;
            while (l<=r){
                long mid = l+(r-l)/2;
                if (check(mid)){
                    r=mid-1;
                    ans = mid;
                }
                else l=mid+1;
            }
            pw.println(ans);
        }
		pw.close();
	}
    public static boolean check(long mid){
        for (long i = 0; i<=Math.min(mid, n-1); i++){
            long smol = nums[0]-mid+i;
            if (pref[(int)(n-i)]-smol*i+mid-i>=threshold) return true;
        }
        return false;
    }
}
