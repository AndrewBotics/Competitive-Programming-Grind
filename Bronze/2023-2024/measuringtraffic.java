import java.io.*;
import java.util.*;

public class measuringtraffic {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("traffic.in"));
        PrintWriter pw = new PrintWriter(new File("traffic.out"));
        int n = s.nextInt();
        String[] t = new String[n];
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i<n; i++){
            t[i] = s.next();
            a[i] = s.nextInt();
            b[i] = s.nextInt();
        }

        int c = 0;
        int d = 99999999;
        for (int i = n-1; i>=0; i--){
            if (t[i].equals("none")) {
                c = Math.max(c, a[i]);
                d = Math.min(d, b[i]);
            }
            else if (t[i].equals("off")) {
                c += a[i];
                d += b[i];
            }
            else if (t[i].equals("on")) {
                c -= b[i];
                d -= a[i];
                c = Math.max(0,c);
            }
        }
        pw.println(c+" "+d);

        c = 0;
        d = 99999999;
        for (int i = 0; i<n; i++){
            if (t[i].equals("none")) {
                c = Math.max(c, a[i]);
                d = Math.min(d, b[i]);
            }
            else if (t[i].equals("on")) {
                c += a[i];
                d += b[i];
            }
            else if (t[i].equals("off")) {
                c -= b[i];
                d -= a[i];
                c = Math.max(0,c);
            }
        }
        pw.println(c+" "+d);

        pw.close();
    }
}
