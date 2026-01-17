// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SubseqAdd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(nums);
            if (nums[0]!=1) {
                pw.println("NO");
            }
            else {
                int[] dp = new int[10000];
                dp[1] = 1;
                boolean searching = true;
                for (int i = 1; i<n && searching; i++){
                    if (dp[nums[i]]==0){
                        pw.println("NO");
                        searching = false;
                    }
                    if (searching) for (int j = 5000; j>=nums[i]; j--){
                        dp[j] |= dp[j-nums[i]];
                    }
                }
                if (searching) pw.println("YES");
            }
        }
		pw.close();
	}
}
