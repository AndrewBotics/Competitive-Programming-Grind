// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class p1709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) b[i] = Integer.parseInt(st.nextToken());
            
            int ct = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<n; i++){
                for (int j = 1; j<n; j++){
                    if (a[j-1]>a[j]){
                        int temp = a[j-1];
                        a[j-1] = a[j];
                        a[j] = temp;
                        ct++;
                        sb.append(1).append(" ").append(j).append("\n");
                    }
                }
            }

            for (int i = 1; i<n; i++){
                for (int j = 1; j<n; j++){
                    if (b[j-1]>b[j]){
                        int temp = b[j-1];
                        b[j-1] = b[j];
                        b[j] = temp;
                        ct++;
                        sb.append(2).append(" ").append(j).append("\n");
                    }
                }
            }
            
            for (int i = 0; i<n; i++){
                if (a[i]>b[i]) {
                    sb.append(3).append(" ").append(i+1).append("\n");
                    ct++;
                }
            }
            pw.println(ct);
            pw.print(sb);
        }
		pw.close();
	}
}
