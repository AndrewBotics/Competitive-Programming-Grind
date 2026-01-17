// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class KarenCoffee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] temps = new int[200002];
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            temps[Integer.parseInt(st.nextToken())]++;
            temps[Integer.parseInt(st.nextToken())+1]--;
        }

        int[] ans = new int[200002];
        for (int i = 1; i<200002; i++){
            temps[i] += temps[i-1];
            ans[i] += ans[i-1]+(temps[i]>=k?1:0);
        }

        for (int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            pw.println(-ans[Integer.parseInt(st.nextToken())-1]+ans[Integer.parseInt(st.nextToken())]);
        }
        pw.close();
    }
}
