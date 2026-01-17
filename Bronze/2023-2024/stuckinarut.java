import java.io.*;
import java.util.*;

public class stuckinarut {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int maxx = 0;
        int maxy = 0;
        char[] dirs = new char[n];
        int[] x = new int[n];
        int[] y = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i<n; i++){
            dirs[i] = s.next().charAt(0);
            x[i] = s.nextInt();
            y[i] = s.nextInt();
        }
        List<Integer> difs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                difs.add(Math.abs(x[k] - x[j]));
                difs.add(Math.abs(y[k] - y[j]));
            }
        }
        Collections.sort(difs);
        for (int d : difs) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dirs[j] == 'E' && dirs[k] == 'N' && x[j] < x[k] && y[k] < y[j]) {
                        if (x[j] + d == x[k] && y[k] + Math.min(ans[k], d) > y[j]) {
                            ans[j] = Math.min(ans[j], d);
                        } else if (y[k] + d == y[j] && x[j] + Math.min(ans[j], d) > x[k]) {
                            ans[k] = Math.min(ans[k], d);
                        }
                    }
                }
            }
        }
        for (int a : ans) pw.println(a == Integer.MAX_VALUE ? "Infinity" : a);
        pw.close();
    }
}

