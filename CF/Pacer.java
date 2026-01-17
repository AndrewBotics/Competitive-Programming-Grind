// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Pacer {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int m = s.nextInt();
            int currTime = 0;
            int ct = 0;
            boolean onLeft = true;
            for (int i = 0; i<n; i++){
                int time = s.nextInt();
                int elapsed = time-currTime;
                boolean currLeft = s.nextInt()==0;
                ct += elapsed;

                if (currLeft!=onLeft && (time-currTime)%2==0) ct--;
                if (currLeft==onLeft && (time-currTime)%2==1) ct--;

                currTime = time;
                onLeft = currLeft;
            }
            pw.println(ct+m-currTime);
        }

		pw.close();
	}
}
