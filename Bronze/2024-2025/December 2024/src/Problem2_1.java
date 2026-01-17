import java.util.Scanner;

public class Problem2_1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];
        int[][] front = new int[n][n];
        int max = 0;
        for (int i = 0; i<q; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if (++top[a][b]==n) max++;
            if (++left[b][c]==n) max++;
            if (++front[a][c]==n) max++;
            System.out.println(max);
        }
    }
}