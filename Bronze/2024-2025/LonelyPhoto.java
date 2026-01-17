import java.io.*;
import java.util.*;

public class LonelyPhoto {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = s.nextInt();
        char[] cows = s.next().toCharArray();

        int[] gurn = new int[n+1];
        int[] hol = new int[n+1];

        for (int i = 1; i<=n; i++){
            gurn[i] = gurn[i-1];
            hol[i] = hol[i-1];
            if (cows[i-1]=='G') gurn[i]++;
            if (cows[i-1]=='H') hol[i]++;
        }

        int ret = 0;
        for (int i = 0; i<n-2; i++){
            for (int j = i+3; j<n+1; j++){
                if (gurn[j]-gurn[i]==1 || hol[j]-hol[i]==1) ret++;
            }
        }
        pw.println(ret);

        pw.close();
    }
}

