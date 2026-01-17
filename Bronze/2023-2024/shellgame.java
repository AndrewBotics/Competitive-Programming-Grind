import java.io.*;
import java.util.*;

public class shellgame {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("shell.in"));
        PrintWriter pw = new PrintWriter(new File("shell.out"));
        int n = s.nextInt();
        int[][] moves = new int[n][3];
        for (int i = 0; i<n; i++){
            moves[i][0] = s.nextInt();
            moves[i][1] = s.nextInt();
            moves[i][2] = s.nextInt();
        }
        int ret = 0;
        for (int i = 1; i<=3; i++){
            int pebble = i;
            int temp = 0;
            for (int j = 0; j<n; j++){
                if (pebble == moves[j][0]) pebble = moves[j][1];
                else if (pebble == moves[j][1]) pebble = moves[j][0];
                if (pebble == moves[j][2]) temp++;
            }
            ret = Math.max(ret, temp);
        }
        pw.println(ret);
        pw.close();
    }
}

