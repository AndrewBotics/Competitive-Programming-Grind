// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CreatingStringsII {
    public static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String str = s.next();
        char[] ch = str.toCharArray();
        int n = ch.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ch){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //pw.println(map);
        long ans = factorial(str.length());
        for (char c : map.keySet()){
            ans = (ans*modInverse(factorial(map.get(c)), MOD))%MOD;
        }
        //pw.println(map);
        pw.println(ans);
		pw.close();
	}
    public static long factorial(long n){
        long ret = 1;
        for (int i = 2; i<=n; i++) ret = (ret*i)%MOD;
        return ret;
    }
    public static long modExp(long base, long exp, long mod){
        long ret = 1;
        while (exp>0){
            if (exp%2==1) ret = (ret*base)%mod;
            base = (base*base)%mod;
            exp /= 2;
        }
        return ret;
    }
    public static long modInverse(long n, long mod) {
        return modExp(n, mod-2, mod);
    }
}
