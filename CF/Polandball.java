// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Polandball {
    public static List<Integer>[] connected;
    public static boolean[] traversed;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        connected = new ArrayList[n+1];
        for (int i = 1; i<=n; i++) connected[i] = new ArrayList<>();
        traversed = new boolean[n+1];
        for (int i = 1; i<=n; i++){
            int a = s.nextInt();
            connected[i].add(a);
            connected[a].add(i);
        }

        int ct = 0;
        for (int i = 1; i<=n; i++){
            if (!traversed[i]) {
                floodFill(i);
                ct++;
            }
        }
        pw.println(ct);

		pw.close();
	}
    public static void floodFill(int i){
        if (traversed[i]) return;
        traversed[i] = true;
        for (int x : connected[i]) floodFill(x);
    }
}
