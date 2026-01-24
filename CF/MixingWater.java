import java.io.*;
import java.util.*;

public class MixingWater {
    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer st;
    static double H;
    static double C;
    static double targ;

    static int solve () throws IOException {
        st = new StringTokenizer(reader.readLine());
        H = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        targ = Integer.parseInt(st.nextToken());

        if (targ <= (H + C) / 2) return 2;
        int lt = 0;
        int rt = (int) 1e6;
        int mid;
        while (lt < rt) {
            mid = (lt + rt) / 2;
            //Java doesn't pass without the addition of the constant below.
            if (calc(mid) + 0.000000000000000000001 <= calc(mid + 1)) rt = mid;
            else lt = mid + 1;
        }
        return (2 * lt) + 1;
    }

    static double calc (double numC) {
        double av = (((numC + 1) * H) + (numC * C)) / ((2 * numC) + 1);
        return Math.abs(av - targ);
    }

    public static void main (String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int T = Integer.parseInt(reader.readLine());
        int t = 0;
        while (t < T) {
            out.println(solve());
            t++;
        }
        out.close();
    }
}