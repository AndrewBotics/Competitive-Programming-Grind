// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CoveredPoints {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = s.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            long a = s.nextLong();
            long b = s.nextLong();
            map.put(a, map.getOrDefault(a, 0)+1);
            map.put(b+1, map.getOrDefault(b+1, 0)-1);
        }
        //pw.println(map);

        List<Long> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);
        //pw.println(nums);

        long pos = 0;
        long delta = 0;
        long[] tots = new long[n+1];
        for (long i : nums){
            if (delta<=n) tots[(int)delta] += i-pos;
            pos = i;
            delta += map.get(i);
            //pw.println(pos+" "+delta);
        }
        //pw.println(pos+" "+delta);
        //pw.println(Arrays.toString(tots));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++) sb.append(tots[i]).append(" ");
        pw.println(sb);

		pw.close();
	}
}
