// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ReverseXOR {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            char[] bits = Integer.toBinaryString(n).toCharArray();
            int min = 0;
            int max = 0;
            for (int i = 0; i<bits.length; i++){
                if (bits[i]=='1') max = i;
            }
            //pw.println(min+" "+max);
            //pw.println(Arrays.toString(bits));
            if ((min+max)%2==0){
                boolean works = bits[(min+max)/2]=='0';
                for (int i = 0; i<(min+max)/2 && works; i++){
                    if (bits[min+i]!=bits[max-i]) works = false;
                }
                pw.println(works?"YES":"NO");
            }
            else {
                boolean works = true;
                for (int i = 0; i<=(min+max)/2 && works; i++){
                    if (bits[min+i]!=bits[max-i]) works = false;
                }
                pw.println(works?"YES":"NO");
            }
        }
		pw.close();
	}
}
