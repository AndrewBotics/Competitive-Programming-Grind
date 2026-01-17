// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MergeSortPrep {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<List<Integer>> sequences = new ArrayList<>();
        for (int i = 0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            int lo = 0;
            int hi = sequences.size();
            while (lo<hi){
                int mid = (lo+hi)/2;
                if (sequences.get(mid).get(sequences.get(mid).size()-1)<a) hi = mid;
                else lo = mid+1;
            }
            if (lo == sequences.size()) sequences.add(new ArrayList<>(Collections.singletonList(a)));
            else sequences.get(lo).add(a);
        }
        for (List<Integer> i : sequences){
            for (int j : i) pw.print(j+" ");
            pw.println();
        }
		pw.close();
	}
}
