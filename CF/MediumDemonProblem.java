// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MediumDemonProblem {
    public static int[] nums;
    public static int[] visited;
    public static int[] len;
    public static boolean[] cycle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new int[n];
            for (int i = 0; i<n; i++) {
                nums[i] = Integer.parseInt(st.nextToken())-1;
            }
            visited = new int[n];
            len = new int[n];
            cycle = new boolean[n];
            for (int i = 0; i<n; i++){
                if (visited[i]==0) dfs(i);
            }
            int max = 0;
            for (int i = 0; i<n; i++) max = Math.max(max, len[i]);
            pw.println(max+2);
        }
		pw.close();
	}
    public static void dfs(int pos){
        visited[pos] = 1;
        int curr = nums[pos];
        if (visited[curr]==0) dfs(curr);
        else if (visited[curr]==1) {
            cycle[pos] = true;
            for (int i = curr; i!=pos; i=nums[i]) cycle[i] = true;
        }
        if (!cycle[pos]) len[pos] = len[curr] + 1;
        visited[pos] = 2;
    }
}
