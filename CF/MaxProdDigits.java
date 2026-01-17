// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MaxProdDigits {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String a = s.next();
        String b = s.next();
        while (a.length()<b.length()) a = '0'+a;

        String ret = "";
        boolean eq = true;
        for (int i = 0; i<=b.length(); i++){
            String curr = b.substring(0, i);
            if (i<b.length() && eq) {
                eq &= a.charAt(i)==b.charAt(i);
                if (eq) continue;
            }
            if (i<b.length()) curr += (char) (b.charAt(i)-1);
            while (curr.length()<b.length()) curr += '9';
            if (prod(curr)>prod(ret)) ret = curr;
        }
        int i = 0;
        while (i<ret.length() && ret.charAt(i)=='0') i++;
        ret = ret.substring(i);
        pw.println(ret);
		pw.close();
	}
    public static long prod(String str){
        int i = 0;
        while (i<str.length() && str.charAt(i)=='0') i++;
        str = str.substring(i);

        if (str.equals("")) return -1;
        long ret = 1;
        for (char c : str.toCharArray()) ret *= c-'0';
        return ret;
    }
}
