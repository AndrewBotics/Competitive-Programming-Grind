// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SlidingWindowMedian {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<k; i++){
            nums.add(Integer.parseInt(st.nextToken()));
            q.offer(nums.get(nums.size()-1));
        }
        Collections.sort(nums);
        ans.append(nums.get((nums.size()-1)/2)).append(" ");
        for (int i = 0; i<n-k; i++){
            nums.add(Integer.parseInt(st.nextToken()));
            q.offer(nums.get(nums.size()-1));
            nums.remove(new Integer(q.poll()));
            Collections.sort(nums);
            ans.append(nums.get((nums.size()-1)/2)).append(" ");
            //pw.println(nums);
        }
        pw.println(ans);
        
		pw.close();
	}
}
