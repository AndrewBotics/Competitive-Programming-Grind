// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class YearCow {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int k = s.nextInt();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i<n; i++) set.add(s.nextInt()/12+1);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int ans = list.get(list.size()-1);
        ArrayList<Integer> dists = new ArrayList<>();
        for (int i = 1; i<list.size(); i++) dists.add(list.get(i)-list.get(i-1)-1);
        Collections.sort(dists);
        k--;
        if (dists.size()>=k){
            for (int i = dists.size()-k; i<=dists.size()-1; i++) {
                ans -= dists.get(i);
            }
        }
        else {
            for (int i = 0; i<=dists.size()-1; i++){
                ans -= dists.get(i);
            }
        }

        pw.println(ans*12);
        
		pw.close();
	}
}
