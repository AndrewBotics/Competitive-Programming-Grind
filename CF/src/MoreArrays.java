// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MoreArrays {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        for (int tt=0; tt<t; tt++){
            int n = s.nextInt();
            int ct = 1;
            int prev = s.nextInt();
            for (int i = 1; i<n; i++){
                int curr = s.nextInt();
                if (curr-prev>1) {
                    prev = curr;
                    ct++;
                }
            }
            pw.println(ct);
        }
        pw.close();
    }
}

