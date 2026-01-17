// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DistinctValueSubarraysII {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        long ct = 0;
        for (int i = 0; i<n; i++){
            int c = Integer.parseInt(st.nextToken());
            q.offer(c);
            map.put(c, map.getOrDefault(c, 0)+1);
            while (map.size()>k){
                int curr = q.poll();
                map.put(curr, map.getOrDefault(curr, 0)-1);
                if (map.get(curr)==0) map.remove(curr);
            }
            ct += q.size();
        }
        pw.println(ct);
		pw.close();
	}
}
