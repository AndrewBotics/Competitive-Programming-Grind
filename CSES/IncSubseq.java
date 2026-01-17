// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class IncSubseq {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int[] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        pw.println(findLis(arr));
		pw.close();
	}
    public static int findLis(int[] a) {
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for (int i : a) {
            int pos = Collections.binarySearch(dp, i);
            pos = pos < 0 ? Math.abs(pos + 1) : pos;
            if (pos == dp.size()) {
                dp.add(i);
            } else {
                dp.set(pos, i);
            }
        }
        return dp.size();
    }
}
