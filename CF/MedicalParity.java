
import java.io.*;
import java.util.*;

public class MedicalParity {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            String xS = s.next();
            String yS = s.next();
            int n = xS.length();
            boolean[] x = new boolean[n];
            boolean[] y = new boolean[n];
            for (int i = 0; i<n; i++){
                x[i] = xS.charAt(i)=='1';
                y[i] = yS.charAt(i)=='1';
            }
            int[][] dp = new int[n][2];
            for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
            if (x[0] && y[0]){
                dp[0][0] = 2;
                dp[0][1] = 0;
            }
            else if (x[0] != y[0]){
                dp[0][0] = 1;
                dp[0][1] = 1;
            }
            else if (!x[0] && !y[0]){
                dp[0][0] = 0;
                dp[0][1] = 2;
            }

            for (int i = 1; i<n; i++){
                if (x[i] && y[i]){
                    dp[i][0] = Math.min(Math.min(dp[i][0], dp[i-1][0]+2), dp[i-1][1]+1);
                    dp[i][1] = Math.min(Math.min(dp[i][1], dp[i-1][0]), dp[i-1][1]+1);
                }
                else if (x[i] && !y[i]){
                    dp[i][0] = Math.min(Math.min(dp[i][0], dp[i-1][0]+1), dp[i-1][1]);
                    dp[i][1] = Math.min(Math.min(dp[i][1], dp[i-1][0]+1), dp[i-1][1]+2);
                }
                else if (!x[i] && y[i]){
                    dp[i][0] = Math.min(Math.min(dp[i][0], dp[i-1][0]+1), dp[i-1][1]+2);
                    dp[i][1] = Math.min(Math.min(dp[i][1], dp[i-1][0]+1), dp[i-1][1]);
                }
                else if (!x[i] && !y[i]){
                    dp[i][0] = Math.min(Math.min(dp[i][0], dp[i-1][0]), dp[i-1][1]+1);
                    dp[i][1] = Math.min(Math.min(dp[i][1], dp[i-1][0]+2), dp[i-1][1]+1);
                }
            }
            pw.println(Math.min(dp[n-1][0], dp[n-1][1]));
        }
		pw.close();
	}
    public static int bit(boolean b){
        return b?1:0;
    }
}
