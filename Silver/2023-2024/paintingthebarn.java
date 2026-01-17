import java.io.*;
import java.util.*;

public class paintingthebarn {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new File("paintbarn.out"));
        int n = s.nextInt();
        int k = s.nextInt();
        int[][] grid = new int[1001][1001];
        int maxx = 0;
        int maxy = 0;
        for (int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            grid[a][b]++;
            grid[a][d]--;
            grid[c][b]--;
            grid[c][d]++;
            if (c>maxx) maxx = c;
            if (d>maxy) maxy = d;
        }
        int ret = 0;
        int[][] sums = new int[maxx][maxy];
        for (int i = 0; i<maxx; i++){
            for (int j = 0; j<maxy; j++){
                int sum = 0;
                sum += grid[i][j];
                if (j > 0) sum += sums[i][j-1];
                if (i > 0) sum += sums[i-1][j];
                if (j > 0 && i > 0) sum -= sums[i-1][j-1];
                sums[i][j] = sum;
                if (sum == k) ret++;
            }
        }
        //for (int i = 10; i>=0; i--) pw.println(Arrays.toString(grid[i]));
        //pw.println(maxx);
        //pw.println(maxy);
        pw.println(ret);
        pw.close();
    }
}
