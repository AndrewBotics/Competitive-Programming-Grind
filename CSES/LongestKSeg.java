// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LongestKSeg {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int maxInd = 0;
        int ind = 0;
        for (int i = 0; i<n; i++){
            int c = Integer.parseInt(st.nextToken());
            map.put(c, map.getOrDefault(c, 0)+1);
            q.offer(c);
            while (map.size()>k){
                int prev = q.poll();
                map.put(prev, map.get(prev)-1);
                if (map.get(prev)==0) map.remove(prev);
                ind++;
            }
            if (q.size()>maxLen){
                maxInd = ind;
                maxLen = q.size();
            }
        }
        pw.println((maxInd+1)+" "+(maxInd+maxLen));
		pw.close();
	}
}
