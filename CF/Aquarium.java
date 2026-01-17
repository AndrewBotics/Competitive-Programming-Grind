// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Aquarium {
    static class Column implements Comparable<Column>{
        public long time;
        public long magnitude;

        public Column (long t, long m) {
            time = t;
            magnitude = m;
        }

        public String toString(){
            return "{"+time+","+magnitude+"}";
        }

        @Override
        public int compareTo(Column c){
            return (int) (time-c.time);
        }
    }
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        long t = s.nextLong();
        while (t-->0){
            long n = s.nextLong();
            long x = s.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i<n; i++) {
                long a = s.nextLong();
                map.put(a, map.getOrDefault(a, 0L)+1);
            }

            List<Column> fill = new ArrayList<>();
            for (long k : map.keySet()) fill.add(new Column(k, map.get(k)));
            Collections.sort(fill);
            //pw.println(fill);

            long f = 0;
            long lvl = 0;
            long delta = 0;
            for (Column c : fill){
                long totD = delta*(c.time-lvl);
                if (f+totD<x) {
                    f += totD;
                    lvl = c.time;
                }
                else {
                    long h = (x-f)/delta;
                    f += h*delta;
                    lvl += h;
                }
                delta += c.magnitude;
            }

            //pw.println(x+" "+f+" "+lvl+" "+delta);
            if (f<x) {
                long h = (x-f)/delta;
                f += h*delta;
                lvl += h;
            }

            pw.println(lvl);
        }

		pw.close();
	}
}
