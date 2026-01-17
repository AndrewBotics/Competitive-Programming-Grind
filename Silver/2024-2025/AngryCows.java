// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class AngryCows {
    static int k;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new File("angry.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] cows = new int[n];
        for (int i = 0; i<n; i++) cows[i] = Integer.parseInt(br.readLine());
        Arrays.sort(cows);
        //pw.println(Arrays.toString(cows));

        int lo = 0;
        int hi = cows[cows.length-1];
        while (lo<=hi){
            int mid = (lo+hi)/2;
            if (works(mid, cows)) hi = mid-1;
            else lo = mid+1;
        }
        pw.println(lo);
        //pw.println(Arrays.toString(cows));
		pw.close();
	}
    public static boolean works(int mid, int[] arr){
        int cur = -1;
        for (int i=0; i<k; i++){
            cur++;
            int curpos = arr[cur];
            while (true){
                cur += 1;
                if (cur > arr.length-1) break;
                if (arr[cur]-curpos > 2*mid){
                    cur--;
                    break;
                }
            }
            if (cur > arr.length-1){
                cur--;
                break;
            }
        }
        return cur == arr.length-1;
    }
}
