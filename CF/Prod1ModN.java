// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Prod1ModN {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] coprime = new int[n];
        coprime[1] = 1;
        long rem = 1;
        int ans = 1;
        for (int i = 2; i<n; i++){
            if (gcd(i, n)==1) {
                coprime[i] = 1;
                ans++;
                rem = (rem*i)%n;
            }
        }
        if (rem!=1) {
            ans--;
            coprime[(int) rem] = 0;
        }
        pw.println(ans);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<n; i++){
            if (coprime[i]==1) sb.append(i).append(" ");
        }
        pw.println(sb);
		pw.close();
	}
    private static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }
}
