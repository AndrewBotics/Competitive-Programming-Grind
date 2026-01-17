// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        List<Integer> peaks = new ArrayList<>();
        for (int i = 0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            int ind = -1;
            int curr = Integer.MAX_VALUE;
            for (int p = 0; p<peaks.size(); p++){
                if (peaks.get(p)>x){
                    if (ind==-1 || curr>peaks.get(ind)) {
                        ind = p;
                        curr = peaks.get(ind);
                    }
                }
            }
            if (ind==-1) peaks.add(x);
            else peaks.set(ind, x);
        }
        System.out.println(peaks.size());
    }
}

