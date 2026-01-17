import java.io.*;
import java.util.*;

public class breedcounting {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("bcount.in"));
        PrintWriter pw = new PrintWriter(new File ("bcount.out"));
        int n = s.nextInt();
        int q = s.nextInt();
        int[][] cows = new int[n+1][4];
        int x = s.nextInt();
        cows[1][x]++;
        for (int i = 2; i<=n; i++){
            cows[i][1] = cows[i-1][1];
            cows[i][2] = cows[i-1][2];
            cows[i][3] = cows[i-1][3];
            x = s.nextInt();
            cows[i][x]++;
        }
        for (int i = 0; i<q; i++){
            int a = s.nextInt()-1;
            int b = s.nextInt();
            pw.println((cows[b][1]-cows[a][1]) + " " + (cows[b][2]-cows[a][2]) + " " + (cows[b][3]-cows[a][3]));
        }
        pw.close();
    }
}
