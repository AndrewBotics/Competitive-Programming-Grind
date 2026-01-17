// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class NezzarSymmetric {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            for (int i = 0; i<n*2; i++) {
                long a = Long.parseLong(st.nextToken());
                map.put(a, map.getOrDefault(a, 0)+1);
            }
            
            pw.println(ans(n, map));
        }
		pw.close();
	}
    public static String ans(int n, HashMap<Long, Integer> map){
        for (Long l : map.keySet()) if (map.get(l)!=2) return "NO";
        List<Long> nums = new ArrayList<>();
        for (Long l : map.keySet()) nums.add(l);
        Collections.sort(nums);
        nums.add(0, 0L);

        long suffix = 0;
        for (int i = n; i>=1; i--){
            if ((nums.get(i)-2*suffix)<0 || (nums.get(i)-2*suffix)%(2*i)!=0){
                return "NO";
            }

            long ai = (nums.get(i)-2*suffix)/(2*i);
            suffix += ai;
            if (ai<=0) return "NO";
        }
        return "YES";
    }
}
