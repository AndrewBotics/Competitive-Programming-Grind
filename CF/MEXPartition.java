// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MEXPartition {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i<n; i++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            pw.println(mex(set));
        }
		pw.close();
	}
    public static int mex(HashSet<Integer> set){
        for (int i = 0; i<101; i++) if (!set.contains(i)) return i;
        return -1;
    }
}
