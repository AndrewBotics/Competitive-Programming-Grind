// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ConsecSub {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = n-1; i>=0; i--){
            dp.put(arr[i], dp.getOrDefault(arr[i]+1, 0)+1);
        }

        int ind = 0;
        int max = 0;
        for (int i : dp.keySet()){
            if (dp.get(i)>max) {
                ind = i;
                max = dp.get(i);
            }
        }
        pw.println(max);
        for (int i = 0; i<n; i++){
            if (arr[i]==ind) {
                pw.print((i+1)+" ");
                ind++;
            }
        }

		pw.close();
	}
}
