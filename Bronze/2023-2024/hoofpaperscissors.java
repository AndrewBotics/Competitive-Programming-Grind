import java.io.*;
import java.util.*;

public class hoofpaperscissors {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("hps.in"));
        PrintWriter pw = new PrintWriter("hps.out");
        int[][] games = new int[4][4];
	int n = s.nextInt();
	for (int i = 0; i<n; i++){
		games[s.nextInt()][s.nextInt()]++;
	}
	pw.println(Math.max((games[1][2]+games[2][3]+games[3][1]), (games[1][3]+games[3][2]+games[2][1])));
	pw.close();
    }
}
