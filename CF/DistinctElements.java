// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DistinctElements {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long prev = Long.parseLong(st.nextToken());
            List<Long> nums = new ArrayList<>();
            nums.add(1L);
            long ct = 1;
            for (int i = 1; i<n; i++){
                long a = Long.parseLong(st.nextToken());
                int diff = (int)(a-prev);
                if (diff>nums.size()) nums.add(++ct);
                else nums.add(nums.get(nums.size()-diff));
                prev = a;
            }
            StringBuilder sb = new StringBuilder();
            for (long i : nums) sb.append(i).append(" ");
            pw.println(sb);
        }
		pw.close();
	}
}
