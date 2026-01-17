import java.io.*;
import java.util.*;

public class JustGreenEnough {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[][] leq = new int[n][n+1];
        int[][] l = new int[n][n+1];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int c = s.nextInt();
                leq[i][j+1] = leq[i][j]+(c<=100?1:0);
                l[i][j+1] = l[i][j]+(c<100?1:0);
            }
        }

        long ans = 0;
        for (int x1 = 0; x1<n; x1++){
            for (int x2 = x1+1; x2<=n; x2++){
                int y1 = -1;
                int y2 = -1;
                for (int y0 = 0; y0<n; y0++){
                    while (y1<n && (y1<y0 || leq[y1][x2]==leq[y1][x1])) y1++;
                    while (y2<n && (y2<y0 || l[y2][x2]==l[y2][x1])) y2++;
                    ans += y2-y1;
                }
            }
        }
        pw.println(ans);

		pw.close();
	}
}
