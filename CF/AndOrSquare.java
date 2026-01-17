// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class AndOrSquare {
    public static long[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new long[n];
        long[] bits = new long[22];
        for (int i = 0; i<n; i++) {
            long a = Long.parseLong(st.nextToken());
            int ind = 0;
            for (int j = 0; j<22; j++) if ((a&(1L<<j))!=0) bits[j]++;
        }

        //pw.println(Arrays.toString(bits));
        long ret = 0;
        for (int i = 0; i<n; i++){
            long curr = 0;
            for (int j = 0; j<22; j++){
                if (bits[j]!=0) {
                    curr |= (1L<<j);
                    bits[j]--;
                }
            }
            ret += curr*curr;
        }
        pw.println(ret);
		pw.close();
	}
}
