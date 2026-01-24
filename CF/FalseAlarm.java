// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FalseAlarm {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int tt = s.nextInt();
        for (int t = 0; t<tt; t++){
            int n = s.nextInt();
            int x = s.nextInt();
            int min = -1;
            int max = -1;
            for (int i = 0; i<n; i++){
                int ne = s.nextInt();
                if (ne==1 && min==-1) min = i;
                if (ne==1) max = i;
            }
            pw.println(max-min<x?"YES":"NO");
        }

        pw.close();
    }
}

