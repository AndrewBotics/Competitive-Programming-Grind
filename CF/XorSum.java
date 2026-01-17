// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class XorSum {
    public static long mod = 998244353L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nums = new long[n+1];
        for (int i = 1; i<=n; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        long ret = 0;
        for (int bit = 0; bit<32; bit++){
            long len = 0;
            long parity_sum[][] = {{0, 1},{0, 0}};
            int parity = 0;

            for (int i = 1; i<=n; i++){
                if (((nums[i]>>bit)&1)!=0) parity = (parity+1)&1;
                long dist = parity_sum[1-parity][0];
                long occ = parity_sum[1-parity][1];

                len = (len+occ*i-dist)%mod;
                if (len<0) len += mod;

                parity_sum[parity][0] += i;
                parity_sum[parity][1]++;
            }
            ret = (ret+len*(1L<<bit))%mod;
        }
        pw.println(ret);
		pw.close();
	}
}
