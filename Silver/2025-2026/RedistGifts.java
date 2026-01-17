// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RedistGifts {
    public static List<Integer>[] preferences;
    public static boolean[] traveled;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        preferences = new ArrayList[n+1];
        traveled = new boolean[n+1];
        for (int i = 1; i<=n; i++){
            preferences[i] = new ArrayList<>();
            boolean going = true;
            for (int j = 0; j<n; j++) {
                int a = s.nextInt();
                if (a==i) going = false;
                if (going) preferences[i].add(a);
            }
        }
        //pw.println(Arrays.toString(preferences));

        for (int i = 1; i<=n; i++){
            int curr = i;
            boolean going = true;
            for (int j : preferences[i]){
                if (going){
                    Arrays.fill(traveled, false);
                    traveled[i] = true;
                    if (makesCycle(j, i) && (preferences[i].indexOf(j)<preferences[i].indexOf(curr) || curr==i)) {
                        curr = j;
                        going = false;
                    }
                }
            }
            pw.println(curr);
        }
		pw.close();
	}
    public static boolean makesCycle(int curr, int reach){
        if (curr==reach) return true;
        else if (traveled[curr]) return false;

        traveled[curr] = true;
        boolean ret = false;
        for (int i : preferences[curr]) ret |= makesCycle(i, reach);
        return ret;
    }
}
