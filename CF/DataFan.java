// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DataFan {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = s.nextInt();
        while (t-->0){
            StringBuilder sb = new StringBuilder();
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i<n; i++) nums[i] = s.nextInt();
            char[] bits = s.next().toCharArray();
            int zero = 0;
            int one = 0;
            for (int i = 0; i<n; i++) {
                if (bits[i]=='0') zero ^= nums[i];
                else one ^= nums[i];
            }

            int[] indexNums = new int[n+1];
            for (int i = 0; i<n; i++) indexNums[i+1] = indexNums[i]^nums[i];
            //pw.println(Arrays.toString(indexNums));

            int c = s.nextInt();
            while (c-->0){
                //pw.println(Arrays.toString(bits));
                if (s.nextInt()==2) {
                    if (s.nextInt()==0) sb.append(zero).append(" ");
                    else sb.append(one).append(" ");
                }
                else {
                    int a = s.nextInt();
                    int b = s.nextInt();
                    zero ^= (indexNums[b]^indexNums[a-1]);
                    one ^= (indexNums[b]^indexNums[a-1]);
                }
                //pw.println(zero+" "+one);
            }
            pw.println(sb);
        }
		pw.close();
	}
}
