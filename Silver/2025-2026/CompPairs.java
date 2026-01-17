// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CompPairs {
    public static long sum;
    public static HashMap<Integer, Integer> map;
    public static HashSet<Integer> list;
    public static HashMap<Integer, Integer> aPair;
    public static HashMap<Integer, Integer> bPair;
    public static HashMap<Integer, Boolean> visited;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        map = new HashMap<>();
        for (int i = 0; i<n; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            map.put(y, x);
        }
        list = new HashSet<>(map.keySet());
        aPair = new HashMap<>();
        bPair = new HashMap<>();
        visited = new HashMap<>();
        for (int i : list){
            int dA = a-i;
            int dB = b-i;
            if (i!=a-i && list.contains(dA)) aPair.put(i, dA);
            if (i!=b-i && list.contains(dB)) bPair.put(i, dB);
        }
        
        for (int i : list){
            if (!visited.getOrDefault(i, false)){
                boolean aW = aPair.get(i)!=null;
                boolean bW = bPair.get(i)!=null;
                if (aW && !bW) dfs(i, true);
                else if (bW && !aW) dfs(i, false);
            }
        }

        if (a%2==0 && map.getOrDefault(a/2, -1)>0) sum += map.get(a/2)/2;
        if (a!=b && b%2==0 && map.getOrDefault(b/2, -1)>0) sum += map.get(b/2)/2;
        pw.println(sum);
        
		pw.close();
	}
    public static void dfs(int ind, boolean isA){
        if (visited.getOrDefault(ind, false)) return;
        visited.put(ind, true);
        if (isA && aPair.get(ind)!=null) {
            int aP = aPair.get(ind);
            int min = Math.min(map.get(ind), map.get(aP));
            sum += min;
            map.put(ind, map.get(ind)-min);
            map.put(aP, map.get(aP)-min);
            dfs(aP, false);
        }
        else if (!isA && bPair.get(ind)!=null){
            int bP = bPair.get(ind);
            int min = Math.min(map.get(ind), map.get(bP));
            sum += min;
            map.put(ind, map.get(ind)-min);
            map.put(bP, map.get(bP)-min);
            dfs(bP, true);
        }
    }
}
