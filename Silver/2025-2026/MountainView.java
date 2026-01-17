// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MountainView {
    static class Mtn implements Comparable<Mtn> {
        public int x;
        public int y;
        public boolean invisible;

        public Mtn(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Mtn m){
            int sum = x+y-m.x-m.y;
            if (sum==0) {
                if (y<m.y) invisible = true;
                else m.invisible = true;
                return y-m.y;
            }
            return sum;
        }

        public String toString(){
            return "{"+x+", "+y+", "+invisible+"}";
        }
    }

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("mountains.in"));
        PrintWriter pw = new PrintWriter("mountains.out");
        int n = s.nextInt();
        Mtn[] mtns = new Mtn[n];
        for (int i = 0; i<n; i++){
            mtns[i] = new Mtn(s.nextInt(), s.nextInt());
        }
        Arrays.sort(mtns);
        //pw.println(Arrays.toString(mtns));

        int compareX = mtns[n-1].x+mtns[n-1].y;
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n && !mtns[i].invisible; j++){
                if (mtns[j].x+mtns[i].y<=mtns[j].y+mtns[i].x) mtns[i].invisible = true;
            }
        }
        //pw.println(Arrays.toString(mtns));

        int ct = 0;
        for (Mtn m : mtns) if (m.invisible) ct++;
        pw.println(n-ct);

		pw.close();
	}
}
