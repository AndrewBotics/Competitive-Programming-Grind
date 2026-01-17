// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BovineAcrobatics {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        int tot = 0;
        for (int i = 0; i<n; i++) tree.put(s.nextInt(), s.nextInt());
        
        while (m>0 && tree.size()>1){
            List<Integer> curr = new ArrayList<>();
            int min = tree.get(tree.firstKey());
            curr.add(tree.firstKey());
            Integer next = tree.ceilingKey(curr.get(curr.size()-1)+k);
            while (next!=null){
                min = Math.min(min, tree.get(next));
                curr.add(next);
                next = tree.ceilingKey(curr.get(curr.size()-1)+k);
            }

            int tr = Math.min(m, min);
            for (int i : curr) {
                tree.put(i, tree.get(i)-tr);
                if (tree.get(i)==0) tree.remove(i);
            }
            m -= tr;
            tot+=tr*curr.size();
        }
        pw.println(tot);
		pw.close();
	}
}
