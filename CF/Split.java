// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Split {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            int[] nums = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i<n; i++){
                nums[i] = s.nextInt();
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
            //pw.println(map);
            boolean works = true;
            for (int i : map.values()) if (i%k!=0) works = false;
            if (works){
                HashMap<Integer, Integer> curr = new HashMap<>();
                long ct = 0;
                int j = 0;
                for (int i = 0; i<n; i++){
                    curr.put(nums[i], curr.getOrDefault(nums[i], 0)+1);
                    while (curr.get(nums[i])>map.get(nums[i])/k) {
                        curr.put(nums[j], curr.get(nums[j])-1);
                        j++;
                    }
                    ct += i-j+1;
                }
                pw.println(ct);
            }
            else pw.println(0);
        }
		pw.close();
	}
}
