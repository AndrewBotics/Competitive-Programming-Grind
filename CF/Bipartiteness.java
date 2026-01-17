// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Bipartiteness {
    public static List<Integer>[] connections;
    public static boolean[] isRed;
    public static boolean[] travelled;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        connections = new ArrayList[n];
        isRed = new boolean[n];
        travelled = new boolean[n];
        for (int i = 0; i<n; i++) connections[i] = new ArrayList<>();

        for (int i = 1; i<n; i++){
            int a = s.nextInt()-1;
            int b = s.nextInt()-1;
            connections[a].add(b);
            connections[b].add(a);
        }
        //pw.println(Arrays.toString(connections));

        traverse(0, true);
        //pw.println(Arrays.toString(isRed));

        long tot = 0;
        for (boolean b : isRed){
            if (b) tot++;
        }
        long n2 = n;
        pw.println(tot*(n2-tot)-n2+1);

		pw.close();
	}
    public static void traverse(int node, boolean red){
        if (travelled[node]) return;
        else travelled[node] = true;
        isRed[node] = red;
        red = !red;
        for (int i : connections[node]) traverse(i, red);
    }
}
