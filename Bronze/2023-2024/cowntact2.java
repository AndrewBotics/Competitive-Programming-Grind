// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class cowntact2 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
        String cows = s.next();
        ArrayList<Integer> segments = new ArrayList<>();
        int region = 0;
        for (int i = 0; i < n; i++){
            if (cows.charAt(i) == '1') region++;
            else{
                if (region > 0) segments.add(region);
                region = 0;
            }
        }
        if (region > 0) segments.add(region);
        int[] minBlock = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int minEnd = Integer.MAX_VALUE;
        int sind = 0; int eind = segments.size()-1;
        if (cows.charAt(0) == '1') {
            minEnd = Math.min(minEnd, segments.get(0));
            sind++;
        }
        if (cows.charAt(n-1) == '1') {
            minEnd = Math.min(minEnd, segments.get(eind));
            eind--;
        }
        for (int i = sind; i <= eind; i++) minBlock[segments.get(i)%2] = Math.min(minBlock[segments.get(i)%2], segments.get(i));
        int daySpread = Math.min(minEnd*2-1, Math.min(minBlock[0]-1, minBlock[1]));
        int numInfected = 0;
        for (int block : segments) numInfected += (block+daySpread-1)/daySpread;
        System.out.println(numInfected);
		pw.close();
	}
}
