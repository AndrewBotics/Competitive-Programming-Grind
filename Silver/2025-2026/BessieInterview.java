// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BessieInterview {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) {
            nums[i] = s.nextInt();
        }

        HashMap<Long, List<Long>> map = new HashMap<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i<k; i++) pq.add(0L);
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i<n; i++){
            long curr = pq.poll();
            long val = nums[i];
            if (map.get(curr+val)==null) map.put(curr+val, new ArrayList<Long>());
            map.get(curr+val).add(curr);
            pq.offer(curr+val);
        }

        long ans = pq.poll();
        pw.println(ans);

        HashSet<Long> answers = new HashSet<>();
        LinkedList<Long> q = new LinkedList<>();
        answers.add(ans);
        q.add(ans);
        while (!q.isEmpty()){
            long curr = q.poll();
            if (map.containsKey(curr)){
                for (long prev : map.get(curr)){
                    if (!answers.contains(prev)){
                        answers.add(prev);
                        q.add(prev);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<k; i++){
            if (answers.contains((long)nums[i])) sb.append("1");
            else sb.append("0");
        }
        pw.println(sb);
		pw.close();
	}
}
