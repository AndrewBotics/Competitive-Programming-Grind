import java.io.*;
import java.util.*;

public class cannonball {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int pos = s.nextInt() - 1;
		int move = 1;
		int broken = 0;
		int[][] locs = new int[n][2];
		for (int i = 0; i<n; i++){
			locs[i][0] = s.nextInt();
			locs[i][1] = s.nextInt();
		}
		while (pos >= 0 && pos < n){
			if (locs[pos][0] % 2 == 0){
				if (move > 0) move += locs[pos][1];
				else if (move < 0) move -= locs[pos][1];
				move = move * -1;
				locs[pos][0] += 2;
			}
			else if (locs[pos][0] == 1){
				if (move > 0 && move >= locs[pos][1]){
					broken++;
					locs[pos][0] = -1;
					locs[pos][1] = -1;
				}
				else if (move < 0 && move * -1 >= locs[pos][1]){
					broken++;
					locs[pos][0] = -1;
					locs[pos][1] = -1;
				}
			}
			if (locs[pos][0]>=100) break;
			pos += move;
			//pw.println((pos+2) + ", " + move);
		}
		pw.println(broken);
		pw.close();
	}
}