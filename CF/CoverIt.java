// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CoverIt {
    public static List<Integer>[] nodes;
    public static boolean[] travelled;
    public static boolean[] isRed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
		    StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            nodes = new ArrayList[n+1];
            travelled = new boolean[n+1];
            isRed = new boolean[n+1];
            for (int i = 1; i<=n; i++) nodes[i] = new ArrayList<>();
            for (int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                nodes[b].add(a);
            }

            PriorityQueue<Integer> q = new PriorityQueue<>();
            PriorityQueue<Integer> next = new PriorityQueue<>();
            q.add(1);
            boolean colorRed = true;
            while (!q.isEmpty()){
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (!travelled[curr]){
                        isRed[curr] = colorRed;
                        travelled[curr] = true;
                        for (int i : nodes[curr]) next.offer(i);
                    }
                }
                colorRed = !colorRed;
                q = new PriorityQueue<>(next);
                next = new PriorityQueue<>();
            }
            //pw.println(Arrays.toString(nodes));
            //pw.println(Arrays.toString(isRed));
            //pw.println(Arrays.toString(travelled));
            
            int ct = 0;
            for (int i = 1; i<=n; i++) if (isRed[i]) ct++;
            if (ct<n-ct){
                pw.println(ct);
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i<=n; i++) if (isRed[i]) sb.append(i).append(" ");
                pw.println(sb);
            }
            else {
                pw.println(n-ct);
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i<=n; i++) if (!isRed[i]) sb.append(i).append(" ");
                pw.println(sb);
            }
        }

		pw.close();
	}
}
