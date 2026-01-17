// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class WillRobot {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        long ret = 0;
        for (int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            ret += nums[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i<n; i+=2){
            pq.add(nums[i]);
            pq.add(nums[i+1]);
            ret -= pq.poll();
        }
        pw.println(ret);
		pw.close();
	}
}
