// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LISReverse {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i<n; i++){
                int a = s.nextInt();
                map.put(a, map.getOrDefault(a, 0)+1);
            }
            int sin = 0;
            int dou = 0;
            for (int i : map.values()) {
                if (i==1) sin++;
                else dou++;
            }
            pw.println(dou+(sin+1)/2);
        }
		pw.close();
	}
}
