// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Convention {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter pw = new PrintWriter(new File("convention.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cows = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) cows[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cows);
        //pw.println(Arrays.toString(cows));

        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo!=hi){
            int mid = (lo+hi)/2;
            if (works(mid, m, c, cows)) hi = mid;
            else lo = mid+1;
        }
        pw.println(lo);
        pw.close();
    }
    public static boolean works(int mid, int m, int c, int[] arr){
        int currCow = 1;
        int currBus = 1;
        int n = arr.length-1;
        while (currCow<=n && currBus<=m){
            int currCap = 0;
            int currDist = 0;
            int prevCow = currCow;
            while (currCow<=n && currCap<c && currDist<=mid){
                currCap++;
                currDist += arr[currCow] - arr[prevCow];
                if (currDist>mid) break;

                prevCow = currCow;
                currCow++;
            }
            currBus++;
        }
        return currCow==n+1;
    }
}

