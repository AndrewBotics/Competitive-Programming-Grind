// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class NotAssigning {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            List<Edge>[] graph = new ArrayList[n+1];
            for (int i = 1; i<=n; i++) graph[i] = new ArrayList<>();
            for (int i = 1; i<n; i++){
                int a = s.nextInt();
                int b = s.nextInt();
                graph[a].add(new Edge(b, i));
                graph[b].add(new Edge(a, i));
            }
            boolean works = true;
            int outer = 0;
            for (int i = 1; i<=n; i++) {
                if (graph[i].size()>2) works = false;
                else if (graph[i].size()==1) outer = i;
            }
            if (works){
                int[] ret = new int[n];
                int prev = -1;
                int curr = outer;
                int prime = 2;
                while (true){
                    List<Edge> edges = graph[curr];
                    Edge next = edges.get(0);
                    if (next.n==prev) {
                        if (edges.size()==1) break;
                        else next = edges.get(1);
                    }
                    ret[next.v] = prime;
                    prev = curr;
                    curr = next.n;
                    prime = 5-prime;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i<n; i++) sb.append(ret[i]).append(" ");
                pw.println(sb);
            }
            else pw.println(-1);
        }
		pw.close();
	}
    static class Edge {
        public int n;
        public int v;
        public Edge(int node, int val){
            n = node;
            v = val;
        }
    }
}
