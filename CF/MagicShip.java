// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MagicShip {
	public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long[] currPos = {s.nextLong(), s.nextLong()};
        long[] dest = {s.nextLong(), s.nextLong()};
        s.next();
        char[] winds = s.next().toCharArray();

        if (!reachable(currPos, dest, Long.MAX_VALUE/2, winds)){
            pw.println(-1);
        }
        else {
            long lo = 0;
            long hi = Long.MAX_VALUE/2;
            long valid = -1;
            while (lo<=hi){
                long mid = lo/2 + hi/2;
                if (reachable(currPos, dest, mid, winds)){
                    valid = mid;
                    hi = mid-1;
                }
                else lo = mid+1;
            }
            pw.println(valid);
        }
        pw.close();
    }
    public static boolean reachable(long[] from, long[] to, long time, char[] winds){
        long windX = 0;
        long windY = 0;
        for (char w : winds){
            if (w=='U') windY++;
            else if (w=='D') windY--;
            else if (w=='R') windX++;
            else if (w=='L') windX--;
        }

        windX *= time/winds.length;
        windY *= time/winds.length;
        long rem = time % winds.length;
        for (int i = 0; i<rem; i++){
            if (winds[i]=='U') windY++;
            else if (winds[i]=='D') windY--;
            else if (winds[i]=='R') windX++;
            else if (winds[i]=='L') windX--;
        }
        return Math.abs(from[0]+windX-to[0])+Math.abs(from[1]+windY-to[1])<=time;
    }
}
