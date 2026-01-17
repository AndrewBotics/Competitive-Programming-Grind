// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class TwoKnights {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (long i = 1; i<=n; i++){
            System.out.println((i*i)*(i*i-1)/2 - 4*(i-1)*(i-2));
        }
    }
}
