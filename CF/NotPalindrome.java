// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class NotPalindrome {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int a = s.nextInt();
            int b = s.nextInt();
            char[] nums = s.next().toCharArray();
            int z = 0;
            int o = 0;
            for (int i = 0; i<a; i++){
                if (nums[i]=='0') z++;
                else o++;
            }
            int max = a/2-o%2;
            int min = a/2-Math.min(z, o);
            //pw.println(min+" "+max);
            pw.println((min<=b && b<=max && b%2==min%2)?"YES":"NO");
        }
        pw.close();
    }
}
