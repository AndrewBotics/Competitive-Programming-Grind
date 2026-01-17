import java.util.*;
import java.io.*;

public class PlaceForSelfies {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int q = s.nextInt();
        while (q-- > 0) {
            int n = s.nextInt();
            int m = s. nextInt();
            long[] lines = new long[n];
            for (int i = 0; i < n; i++) {
                lines[i] = s.nextLong();
            }
            Arrays.sort(lines);
            for (int i = 0; i < m; i++) {
                long a = s.nextLong();
                long b = s.nextLong();
                long c = s.nextLong();
                int ind = Arrays.binarySearch(lines, b);
                if (ind < 0) ind = -ind - 1;
                boolean found = false;
                if (ind < n && (lines[ind] - b) * (lines[ind] - b) < 4 * a * c) {
                    pw.println("YES");
                    pw.println(lines[ind]);
                    found = true;
                } 
                if (!found && ind > 0 && (lines[ind - 1] - b) * (lines[ind - 1] - b) < 4 * a * c) {
                    pw.println("YES");
                    pw.println(lines[ind - 1]);
                    found = true;
                }
                if (!found) pw.println("NO");
            }
        }
        pw.close();
    }
}
