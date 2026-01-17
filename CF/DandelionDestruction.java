// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class DandelionDestruction {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            List<Long> odds = new ArrayList<>();
            long evens = 0;
            for (int i = 0; i<n; i++){
                long a = s.nextLong();
                if (a%2==0) evens += a;
                else odds.add(a);
            }
            Collections.sort(odds);
            if (odds.size()>0){
                int ct = (1+odds.size())/2;
                for (int i = 0; i<ct; i++) evens += odds.get(odds.size()-1-i);
                pw.println(evens);
            }
            else pw.println(0);
        }
		pw.close();
	}
}
