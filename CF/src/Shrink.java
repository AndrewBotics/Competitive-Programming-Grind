// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Shrink {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            if (n%2==0){
                for (int i = 1; i<n; i+=2) pw.print(i+" ");
                for (int i = n; i>=2; i-=2) pw.print(i+" ");
            }
            else {
                for (int i = 1; i<=n; i+=2) pw.print(i+" ");
                for (int i = n-1; i>=2; i-=2) pw.print(i+" ");
            }
            pw.println();
        }
        pw.close();
    }
}

