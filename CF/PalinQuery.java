import java.io.*;
import java.util.*;
import java.lang.*;

public class PalinQuery {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    static long inv2 = 499122177;
    static long MOD2 = MOD * MOD;
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e18)+9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s = br.readLine();
        char[] c = s.toCharArray();
        int n = s.length();
        int q = Integer.parseInt(br.readLine());
        boolean[][] palin = new boolean[n][n];
        for(int i = 0; i < n; i++){
            int l = i;
            int r = i;
            while (l>=0&&r<n&&c[l]==c[r]){
                palin[l][r] = true;
                l--;
                r++;
            }
            l = i-1;
            r = i;
            while (l>=0&&r<n&&c[l]==c[r]){
                palin[l][r] = true;
                l--;
                r++;
            }
        }
        int[][] dp = new int[n][n];
        for(int length = 1; length <= n; length++){
            for(int i = 0; i+length <= n; i++){
                int j = i+length-1;
                if(length==1){
                    dp[i][j] = 1;
                    continue;
                }
                if(palin[i][j]){
                    dp[i][j] += (dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]+1);
                }else{
                    dp[i][j] += (dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]);
                }
            }
        }
        while (q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            pw.println(dp[l][r]);
        }
        pw.close();
    }
}