// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Bakery {
    public static int n;
    public static long cook;
    public static long muff;
    public static Friend[] frens;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            n = s.nextInt();
            cook = s.nextInt();
            muff = s.nextInt();
            frens = new Friend[n];
            for (int i = 0; i<n; i++) frens[i] = new Friend(s.nextInt(), s.nextInt(), s.nextInt());
            long l = 0;
            long r = cook+muff-2;

            while (l<r){
                long mid = (l+r)/2;
                long lo = Math.max(1, cook-mid);
                long up = Math.min(cook, cook+muff-mid-1);
                boolean works = true;

                for (Friend f : frens){
                    long d = cook+muff-mid;
                    if (f.a==f.b && d*f.b>f.time){
                        works = false;
                        break;
                    }
                    else if (f.a<f.b){
                        lo = Math.max(lo, (f.b*d-f.time+(f.b-f.a-1)/(f.b-f.a)));
                    }
                    else if (f.a>f.b){
                        up = Math.min(up, (f.time-d*f.b)/(f.a-f.b));
                    }
                }
                if (lo<=up && works) r = mid;
                else l = mid+1;
            }
            pw.println(l);
        }
		pw.close();
	}
    static class Friend {
        public long a;
        public long b;
        public long time;

        public Friend(long aa, long bb, long t){
            a = aa;
            b = bb;
            time = t;
        }

        public String toString(){
            return a+"/"+b+"/"+time;
        }
    }
}
