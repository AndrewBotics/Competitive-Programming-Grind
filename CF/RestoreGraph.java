// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RestoreGraph {
    public static List<Integer>[] dists;
    public static List<Integer>[] connects;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int k = s.nextInt();
        dists = new ArrayList[n+1];
        for (int i = 0; i<=n; i++) dists[i] = new ArrayList<>();
        for (int i = 1; i<=n; i++) dists[s.nextInt()].add(i);
        //pw.println(Arrays.toString(dists));
    
        if (dists[0].size()!=1) {
            pw.println(-1);
        }
        else{
            int max = 0;
            for (int i = 1; i<n; i++){
                if (dists[i].size()>0) max = i;
            }

            boolean keepGoing = true;
            for (int i = 0; i<=max; i++){
                if (dists[i].size()==0) keepGoing = false;
            }
            
            if (keepGoing){
                connects = new ArrayList[n+1];
                for (int i = 1; i<=n; i++) connects[i] = new ArrayList<>();
                for (int i = 1; i<=max; i++){
                    int ind = 0;
                    for (int j : dists[i]) {
                        int curr = dists[i-1].get(ind);
                        ind = (ind+1)%dists[i-1].size();
                        connects[curr].add(j);
                        connects[j].add(curr);
                    }
                }
                for (int i = 1; i<=n; i++) if (connects[i].size()>k) keepGoing = false;
                if (keepGoing){
                    pw.println(n-1);
                    for (int i = 1; i<=n; i++) for (int j : connects[i]) if (i<j) pw.println(i+" "+j);
                }
            }
            if (!keepGoing) pw.println(-1);
        }

		pw.close();
	}
}
