// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MinMaxSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n+1];
            int[] pos = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
                pos[nums[i]] = i;
            }

            int k;
            for (k = n/2; k>0; k--){
                if (pos[k]<pos[k+1] && pos[n-k+1]>pos[n-k]){}
                else break;
            }
            pw.println(k);
        }
		pw.close();
	}
}
