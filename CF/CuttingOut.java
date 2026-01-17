// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CuttingOut {
    public static int[] freq = new int[200001];
    public static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            freq[Integer.parseInt(st.nextToken())]++;
        }
        //pw.println(Arrays.toString(freq));

        int lo = 0;
        int hi = n;
        while (lo<hi){
            int mid = (lo+hi+1)/2;
            if (works(mid)) lo = mid;
            else hi = mid - 1;
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i<=200000; i++) for (int j = 0; j<freq[i]/lo; j++) ret.add(i);
        for (int i = 0; i<k; i++) sb.append(ret.get(i)).append(" ");
        pw.println(sb);
		pw.close();
	}
    public static boolean works(int x){
        int ret = 0;
        for (int i = 1; i<=200000; i++) ret += freq[i]/x;
        return ret>=k;
    }
}
