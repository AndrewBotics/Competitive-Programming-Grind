// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Firecrackers {
    public static int m;
    public static int d;
    public static int d2;
    public static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a<b) d = b-1;
            else d = n-b;
            d2 = Math.abs(a-b)-1;

            st = new StringTokenizer(br.readLine());
            nums = new int[m];
            for (int i = 0; i<m; i++) nums[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(nums);

            int lo = 0;
            int hi = Math.min(d2, m);
            while (lo<hi){
                int mid = (lo+hi+1)/2;
                if (works(mid)) lo = mid;
                else hi = mid-1;
            }
            pw.println(lo);
            //pw.println(d+" "+d2);
        }
		pw.close();
	}
    public static boolean works(int mid){
        int t = d;
        for (int i = mid-1; i>=0; i--){
            t--;
            if (nums[i]>t) return false;
        }
        return true;
    }
}
