import java.util.*;
import java.io.*;
 
public class photoshoot2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int j = 0; j < n; j++) a[j] = s.nextInt();
        for (int j = 0; j<n; j++) b[j] = s.nextInt();
        int ct = 0;
        boolean[] moved = new boolean[n + 1];
        int k = 0;
        for (int j = 0; j < n; j++) {
            while (moved[a[k]]) {
                k++;
            }
            if (b[j] == a[k]) {
                k++;
            } else {
                ct++;
                moved[b[j]] = true;
            }
        }
        pw.println(ct);
        pw.close();
    }
}