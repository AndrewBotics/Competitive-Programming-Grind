import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        boolean[][][] carved = new boolean[n][n][n];
        int max = 0;
        for (int i = 0; i<q; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            carved[a][b][c] = true;
            boolean row = true;
            boolean col = true;
            boolean dep = true;
            for (int x = 0; x<n; x++) {
                row = row && carved[x][b][c];
                col = col && carved[a][x][c];
                dep = dep && carved[a][b][x];
            }
            if (row) max++;
            if (col) max++;
            if (dep) max++;
            System.out.println(max);
        }
    }
}