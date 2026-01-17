import java.io.*;
import java.util.*;

public class thebucketlist {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("blist.in"));
        PrintWriter pw = new PrintWriter(new File("blist.out"));
        int n = s.nextInt();
        int[] cows = new int[1001];
        for (int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            for (int j = a; j<=b; j++){
                cows[j]+=c;
            }
        }
        int max = 0;
        for (int co : cows) max = Math.max(max, co);
        pw.println(max);
        pw.close();
    }
}
