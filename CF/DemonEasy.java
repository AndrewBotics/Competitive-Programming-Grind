// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DemonEasy {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i<n; i++){
                nums[i] = s.nextInt()-1;
            }
            int ct = 0;
            int[] prev = new int[n];
            Arrays.fill(prev, 1);
            while (true){
                ct++;
                int[] curr = new int[n];
                for (int i = 0; i<n; i++){
                    curr[nums[i]] += prev[i];
                    if (curr[nums[i]]>1) curr[nums[i]]--;
                }
                if (Arrays.equals(prev, curr)) break;
                prev = curr;
            }
            pw.println(ct+1);
        }
		pw.close();
	}
}
