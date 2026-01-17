// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SheikhEasy {
    public static long[] prefixSum;
    public static long[] prefixXor;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            prefixSum = new long[n+1];
            prefixXor = new long[n+1];
            for (int i = 0; i<n; i++){
                long b = Long.parseLong(st.nextToken());
                prefixSum[i+1] = prefixSum[i]+b;
                prefixXor[i+1] = prefixXor[i]^b;
            }
            br.readLine();
            //pw.println(Arrays.toString(prefixSum));
            //pw.println(Arrays.toString(prefixXor));
            long best = cost(1, n);
            int lo = 1;
            int hi = n;
            while (lo<hi){
                int mid = lo+(hi-lo)/2;
                boolean works = false;
                for (int i = 1; i+mid-1<=n && !works; i++){
                    if (cost(i, i+mid-1)==best) works = true;
                }

                if (works) hi = mid;
                else lo = mid+1;
            }
            for (int i = 1; i+lo-1<=n; i++){
                if (cost(i, i+lo-1)==best){
                    pw.println(i+" "+(i+lo-1));
                    break;
                }
            }
        }
		pw.close();
	}
    public static long cost(int i, int j){
        return prefixSum[j]-prefixSum[i-1]-(prefixXor[j]^prefixXor[i-1]);
    }
}
