// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RoundDance {
    public static List<Integer>[] nums;
    public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            n = Integer.parseInt(br.readLine());
            nums = new ArrayList[n+1];
            for (int i = 1; i<=n; i++) nums[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++){
                int a = Integer.parseInt(st.nextToken());
                if (!nums[i].contains(a)) nums[i].add(a);
                if (!nums[a].contains(i)) nums[a].add(i);
            }

            int max = components();
            int edges = edges();
            int min = max;
            if (edges!=0) min -= edges/2-1;
            pw.println(min+" "+max);
            //pw.println(Arrays.toString(nums));
        }
		pw.close();
	}
    public static int components(){
        boolean[] traveled = new boolean[n+1];
        int ct = 0;
        for (int i = 1; i<=n; i++){
            if (!traveled[i]) {
                search1(i, traveled);
                ct++;
            }
        }
        return ct;
    }
    public static void search1(int i, boolean[] traveled){
        if (traveled[i]) return;
        traveled[i] = true;
        for (int j : nums[i]) search1(j, traveled);
    }
    public static int edges(){
        int ret = 0;
        for (int i = 1; i<=n; i++) if (nums[i].size()==1) ret++;
        return ret;
    }
}
