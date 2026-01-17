// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MortalKombatTower {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] bosses = new int[n];
            for (int i = 0; i<n; i++) bosses[i] = Integer.parseInt(st.nextToken());
            boolean turn = true;
            int sp = 0;
            for (int i = 0; i<n; turn = !turn){
                if (turn){
                    sp += bosses[i];
                    if ((i+1>=n || bosses[i+1]==0) && (i+2>=n || bosses[i+2]==1)) i++;
                    i++;
                } else {
                    if (i+2>=n) break;
                    if (bosses[i+1]==1) i++;
                    i++;
                }
            }
            System.out.println(sp);
        }
		pw.close();
	}
}
