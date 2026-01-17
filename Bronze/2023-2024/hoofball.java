// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class hoofball {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("hoofball.in"));
        PrintWriter pw = new PrintWriter(new File("hoofball.out"));
        int n = s.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i<n; i++) cows[i] = s.nextInt();
        Arrays.sort(cows);
        int[] diffs = new int[n-1];
        for (int i = 0; i<n-1; i++) diffs[i] = cows[i+1]-cows[i];
        
        int apexes = 0;
        for (int i = 0; i<n-1; i++){
            if (i==0){
                if (diffs[i]>diffs[i+1]) apexes++;
            }
            else if (i==n-2){
                if (diffs[i]>diffs[i-1]) apexes++;
            }
            else {
                if (diffs[i]>diffs[i+1] && diffs[i]>diffs[i-1]) apexes++;
		else if (diffs[i]==diffs[i+1] && diffs[i]>diffs[i-1]) apexes++;
		else if (diffs[i]>diffs[i+1] && diffs[i]==diffs[i-1]) apexes++;
            }
        }
        pw.println(apexes);
        pw.close();
    }
}

