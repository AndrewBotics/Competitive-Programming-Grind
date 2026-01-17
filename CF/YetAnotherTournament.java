// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class YetAnotherTournament {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int m = s.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i<n; i++) nums.add(s.nextInt());
            List<Integer> original = new ArrayList<>(nums);
            Collections.sort(nums);

            int sum = 0;
            int k = n;
            for (int i = 0; i<n; i++){
                if (sum+nums.get(i)>m) {
                    k = i;
                    break;
                }
                else sum += nums.get(i);
            }
            //pw.println(k);

            if (k==n) pw.println(1);
            else if (k==0) pw.println(n+1);
            else if (sum-nums.get(k-1)+original.get(k)<=m) pw.println(n-k);
            else pw.println(n-k+1);
        }
		pw.close();
	}
}
