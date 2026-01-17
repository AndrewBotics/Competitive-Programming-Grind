// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i<n; i++) nums.add(Integer.parseInt(st.nextToken()));
        Collections.sort(nums);

        int bot = 0;
        int top = n-1;
        int ct = 0;
        while (bot<top){
            if (nums.get(bot)+nums.get(top)<=x){
                ct++;
                bot++;
            }
            top--;
        }
        pw.println(n-ct);

        pw.close();
    }
}

