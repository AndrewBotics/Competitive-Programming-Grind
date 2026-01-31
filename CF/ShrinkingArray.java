// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ShrinkingArray {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i<n; i++){
                nums[i] = s.nextInt();
            }

            boolean works = false;
            for (int i = 1; i<n; i++){
                if (Math.abs(nums[i]-nums[i-1])<=1) works = true;
            }
            if (works) pw.println(0);
            else {
                if (n==2) pw.println(-1);
                else {
                    boolean canWork = false;
                    for (int i = 2; i<n; i++){
                        if (nums[i-1]>=nums[i] && nums[i-1]>=nums[i-2]) canWork = true;
                        if (nums[i-1]<=nums[i] && nums[i-1]<=nums[i-2]) canWork = true;
                    }
                    pw.println(canWork?1:-1);
                }
            }
        }
		pw.close();
	}
}
