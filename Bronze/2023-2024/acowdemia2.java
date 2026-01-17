import java.io.*;
import java.util.*;

public class acowdemia2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int k = s.nextInt();
        int n = s.nextInt();
        Map<String, Integer> members = new HashMap<>();
        for (int a = 0; a < n; a++) members.put(s.next(), a);
        char[][] answer = new char[n][n];
        for (int a = 0; a < n; a++) {
            Arrays.fill(answer[a], '?');
            answer[a][a] = 'B';
        }
        for (int j = 0; j < k; j++) {
            String[] paper = new String[n];
            for (int x = 0; x < n; x++) paper[x] = s.next();
            for (int x = 0; x < n; x++) {
                boolean ab = true;
                for (int y = x + 1; y < n; y++) {
                    if (paper[y - 1].compareTo(paper[y]) > 0) ab = false;
                    if (!ab) {
                        int a = members.get(paper[x]);
                        int b = members.get(paper[y]);
                        answer[a][b] = '0';
                        answer[b][a] = '1';
                    }
                }
            }
        }
        for (char[] out : answer) pw.println(out);
        pw.close();
    }
}
