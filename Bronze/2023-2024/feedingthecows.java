// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class feedingthecows {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = s.nextInt();
		while (t>0){
			int n = s.nextInt();
			int k = s.nextInt();
			char[] cows = s.next().toCharArray();
			
			char[] ret = new char[n];
			Arrays.fill(ret, '.');
			int ct = 0, lg = -k-1, lh = -k-1;
 			for (int j=k; j<n; j++) {
                if (cows[j-k] == 'G') {
                    if ((j-k)-lg > k) {
                        ct++;
                        ret[j] = 'G';
                        lg = j;
                    }
                } else {
                    if ((j-k)-lh > k) {
                        ct++;
                        ret[j] = 'H';
                        lh = j;
                    }
                }
            }
			boolean gNeeds = false;
            for (int j=n-1; j>=0; j--) {
                if (cows[j] == 'G' && j-lg > k) {
                    gNeeds = true;
                }
            }
            if (gNeeds) {
                for (int j=n-1; j>=0; j--) {
                    if (ret[j] == '.') {
                        ct++;
                        ret[j] = 'G';
                        break;
                    }
                }
            }
            boolean hNeeds = false;
            for (int j=n-1; j>=0; j--) {
                if (cows[j] == 'H' && j - lh > k) {
                    hNeeds = true;
                }
            }
            if (hNeeds) {
                for (int j=n-1; j>=0; j--) {
                    if (ret[j] == '.') {
                        ct++;
                        ret[j] = 'H';
                        break;
                    }
                }
            }
			pw.println(ct);
			pw.println(ret);
			t--;
		}
		pw.close();
	}
}
