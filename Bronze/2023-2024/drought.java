import java.io.*;
import java.util.*;

public class drought {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t>0){
            int n = s.nextInt();
            Integer[] cows = new Integer[n];
            if (n!=1){
                for (int i = 0; i<n; i++) cows[i] = s.nextInt();
                pw.println(solve(n, cows));
            }
            else {
                s.nextInt();
                pw.println(0);
            }
            t--;
        }
        pw.close();
    }
    static long solve(int n, Integer[] cows){
        List<Integer> temp = Arrays.asList(cows);
        int min = Collections.min(temp);
        long ret = -1;
        for (int i = min; i>=0 && ret==-1; i--){
            int[] reduced = new int[n];
            reduced[0] = cows[0]-i;
            for (int j = 1; j<n; j++){
                reduced[j] = cows[j]-i-reduced[j-1];
            }
            if (reduced[n-1]==0){
                boolean neg = false;
                ret++;
                for (int r : reduced) {
                    if (r<0) neg = true;
                    ret += r*2;
                }
                if (neg) ret = -1;
            }
        }
        return ret;
    }
}
