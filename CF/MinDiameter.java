// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MinDiameter {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int[] sums = new int[2];
        for (int t = 0; t<2; t++){
            int n = Integer.parseInt(br.readLine());
            List<Integer>[] nodes = new ArrayList[n+1];
            for (int i = 1; i<=n; i++) nodes[i] = new ArrayList<>();
            for (int i = 1; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                nodes[b].add(a);
            }
            //pw.println(Arrays.toString(nodes));

            int farNode = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            int[] dists = new int[n+1];
            Arrays.fill(dists, -1);
            dists[1] = 0;
            while (!queue.isEmpty()){
                int curr = queue.poll();
                if (dists[curr]!=-1){
                    farNode = curr;
                    for (int i : nodes[curr]) {
                        if (dists[i]==-1) {
                            queue.add(i);
                            dists[i] = dists[curr]+1;
                        }
                    }
                }
            }
            //pw.println(Arrays.toString(dists));
            for (int i=0; i<dists.length; i++) if (dists[i]>dists[farNode]) farNode = i;
            //pw.println(farNode);

            queue = new ArrayDeque<>();
            queue.offer(farNode);
            dists = new int[n+1];
            Arrays.fill(dists, -1);
            dists[farNode] = 0;
            while (!queue.isEmpty()){
                int curr = queue.poll();
                if (dists[curr]!=-1){
                    farNode = curr;
                    for (int i : nodes[curr]) {
                        if (dists[i]==-1) {
                            queue.add(i);
                            dists[i] = dists[curr]+1;
                        }
                    }
                }
            }
            //pw.println(Arrays.toString(dists));
            for (int i=0; i<dists.length; i++) sums[t] = Math.max(sums[t], dists[i]);
        }
        //pw.println(Arrays.toString(sums));
        pw.println(Math.max(Math.max(sums[0], sums[1]), 1+(sums[0]+1)/2+(sums[1]+1)/2));
		pw.close();
	}
}
