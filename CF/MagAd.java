import java.io.*;
import java.util.*;

public class MagAd {
    public static int n;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        s = new Scanner(s.nextLine()).useDelimiter("[ -]");
        PrintWriter pw = new PrintWriter(System.out);
        List<Integer> words = new ArrayList<>();

        while (s.hasNext()) {
            String st = s.next();
            words.add(st.length() + 1);
        }
        // remove the last "+1" (no trailing space at the end of the line)
        words.set(words.size() - 1, words.get(words.size() - 1) - 1);

        int max = 0, tot = 0;
        for (int i : words) {
            max = Math.max(max, i);
            tot += i;
        }

        int lo = max, hi = tot;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFit(mid, words)) hi = mid;
            else lo = mid + 1;
        }
        pw.println(lo);
        pw.close();
    }

    // Check if all words fit into n lines with given line width cap
    public static boolean canFit(int cap, List<Integer> words) {
        int lines = 1, curr = 0;
        for (int w : words) {
            if (curr + w <= cap) {
                curr += w;
            } else {
                lines++;
                curr = w;
            }
            if (lines > n) return false; // too many lines needed
        }
        return true;
    }
}
