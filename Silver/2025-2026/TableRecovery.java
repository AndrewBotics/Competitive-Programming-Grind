import java.io.*;
import java.util.*;

public class TableRecovery {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int N = s.nextInt();
        int[][] table = new int[N][N];
        int[] freq = new int[2 * N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = s.nextInt();
                freq[table[i][j]]++;
            }
        }
        int[] rs = new int[N];
        int[] cs = new int[N];
        outer: for (int u = 2; u <= 2 * N; u++) {
            if (freq[u] == 1) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (table[i][j] == u) {
                            for (int k = 0; k < N; k++) {
                                rs[k] = freq[table[k][j]];
                                cs[k] = freq[table[i][k]];
                            }
                            break outer;
                        }
                    }
                }
            }
        }
        int[][] ans0 = new int[N][N];
        int[][] ans1 = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans0[i][j] = rs[i] + cs[j];
                ans1[i][j] = 2 * (N + 1) - rs[i] - cs[j];
            }
        }
        int choice = 0;
        outer2: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ans0[i][j] < ans1[i][j]) {
                    choice = 0;
                    break outer2;
                }
                if (ans0[i][j] > ans1[i][j]) {
                    choice = 1;
                    break outer2;
                }
            }
        }
        int[][] ans = (choice == 0 ? ans0 : ans1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0)
                    pw.print(" ");
                pw.print(ans[i][j]);
            }
            pw.println();
        }
        pw.close();
    }
}