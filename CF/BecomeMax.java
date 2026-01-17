// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BecomeMax {
    public static int[] nums;
    public static int max;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            nums = new int[n];
            max = 0;
            List<Integer> maxes = new ArrayList<>();
            for (int i = 0; i<n; i++){
                nums[i] = s.nextInt();
            }
            long l = 0;
            long r = (long)1e9;
            while (r-l>1){
                long mid = l+(r-l)/2;
                if (good(nums, n, k, (int)mid)) l = mid;
                else r = mid;
            }
            pw.println(l);
        }

		pw.close();
	}
    public static boolean good(int[] nums, int n, int k, int x){
        for (int i = 0; i<n; i++){
            int have = k;
            for (int j = i; j<n; j++){
                int need = x-(j-i);
                if (nums[j]>=need) return true;
                int used = Math.max(0, need-nums[j]);
                if (used>have) break;
                have -= used;
            }
        }
        return false;
    }
}
