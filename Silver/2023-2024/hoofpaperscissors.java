import java.io.*;
import java.util.*;

public class hoofpaperscissors {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("hps.in"));
        PrintWriter pw = new PrintWriter(new File("hps.out"));
        int n = s.nextInt();
        int[][] plays = new int[n+1][3];
        List<String> outcomes = Arrays.asList("H", "P", "S");
        for (int i = 1; i<=n; i++){
            for (int j = 0; j<3; j++) plays[i][j] = plays[i-1][j];
            String x = s.next();
            plays[i][outcomes.indexOf(x)]++;
        }
        int max = 0;
        for (int i = 0; i<n; i++){
            for (int n1 = 0; n1<3; n1++){
                for (int n2 = 0; n2<3; n2++){
                    if (n1!=n2){
                        int x = plays[i][n1] + (plays[n][n2] - plays[i][n2]);
                        if (max < x) max = x;
                    }
                }
            }
        }
        //pw.println(Arrays.deepToString(plays));
        pw.println(max);
        pw.close();
    }
}
