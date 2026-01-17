// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CPer {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            String str = s.next();
            int rem = 0;
            int even = 0;
            int zero = 0;
            for (char c : str.toCharArray()){
                int curr = c-'0';
                rem += curr;
                if (curr%2==0) even++;
                if (curr==0) zero++;
            }
            pw.println(rem%3==0&&even>=2&&zero!=0?"red":"cyan");
        }
		pw.close();
	}
}
