import java.io.*;
import java.util.*;

public class comfortablecows {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[][] cows = new int[n][2];
        int[] adjacents = new int[n];
        for (int i = 0; i<n; i++){
            cows[i][0] = s.nextInt();
            cows[i][1] = s.nextInt();
            for (int j = 0; j<i; j++){
                if (cows[j][0]+1==cows[i][0] && cows[j][1]==cows[i][1]){
                    adjacents[i]++;
                    adjacents[j]++;
                }
                if (cows[j][0]-1==cows[i][0] && cows[j][1]==cows[i][1]){
                    adjacents[i]++;
                    adjacents[j]++;
                }
                if (cows[j][0]==cows[i][0] && cows[j][1]+1==cows[i][1]){
                    adjacents[i]++;
                    adjacents[j]++;
                }
                if (cows[j][0]==cows[i][0] && cows[j][1]-1==cows[i][1]){
                    adjacents[i]++;
                    adjacents[j]++;
                }
            }
            int ct = 0;
            for (int j : adjacents) if (j==3) ct++;
            pw.println(ct);
        }
        pw.close();
    }
}

