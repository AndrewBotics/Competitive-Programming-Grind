// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class TrailingZeros {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();

        long[] pows = new long[11];
        long curr = 5;
        long all = 0;
        while (curr<=n){
            all += n/curr;
            curr *= 5;
        }
        System.out.println(all);
    }
}

