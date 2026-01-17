// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FJOperation {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            int m = s.nextInt();
            long boreVal = 0;
            int[] nums = new int[n];
            for (int i = 0; i<n; i++){
                nums[i] = (s.nextInt())%m;
                if (m-nums[i]<nums[i]) nums[i] = nums[i]-m;
            }
            //System.out.println(Arrays.toString(nums));
            Arrays.sort(nums);
            int mid = nums.length/2;
            for (int num : nums){
                boreVal += Math.abs(num-nums[mid]);
            }
            System.out.println(boreVal);
        }
	}
}
