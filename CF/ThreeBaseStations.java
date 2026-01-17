// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ThreeBaseStations {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) nums[i] = s.nextInt()*2;
        Arrays.sort(nums);

        int low = 0;
        int high = 2000000000;
        while (low<high){
            int mid = low+(high-low)/2;
            if (works(mid, nums)) high = mid;
            else low = mid+1;
        }
        pw.printf("%.6f\n", (high/2.0));
        int[] ans = ans(high, nums);
        for (int i = 0; i<3; i++) pw.printf("%.6f ", (ans[i]/2.0));
		pw.close();
	}
    public static boolean works(int mid, int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<nums.length && nums[0]+mid*2>=nums[left]) left++;
        while (right>=0 && nums[nums.length-1]-mid*2<=nums[right]) right--;
        if (left>=right) return true;
        return (nums[right]-nums[left]<=mid*2);
    }
    public static int[] ans(int mid, int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<nums.length && nums[0]+mid*2>=nums[left]) left++;
        while (right>=0 && nums[nums.length-1]-mid*2<=nums[right]) right--;
        //System.out.println(left+" "+right);
        if (left>right) return new int[]{nums[0]+mid, nums[nums.length-1]-mid, 0};
        return new int[]{nums[0]+mid, nums[left]+mid, nums[nums.length-1]-mid};
    }
}
