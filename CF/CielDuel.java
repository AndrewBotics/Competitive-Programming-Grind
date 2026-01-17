// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CielDuel {
    public static List<Integer> atk = new ArrayList<>();
    public static List<Integer> def = new ArrayList<>();
    public static List<Integer> cards = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int m = s.nextInt();

        for (int i = 0; i<n; i++){
            if (s.next().equals("ATK")) atk.add(s.nextInt());
            else def.add(s.nextInt());
        }
        for (int i = 0; i<m; i++){
            cards.add(s.nextInt());
        }
        Collections.sort(atk);
        Collections.sort(def);
        Collections.sort(cards);

        int best = 0;
        int maxK = Math.min(atk.size(), cards.size());
        for (int k = 1; k <= maxK; k++) {
            boolean ok = true;
            int dmg = 0;
            for (int i = 0; i < k; i++) {
                int c = cards.get(cards.size() - k + i);
                int a = atk.get(i);
                if (c < a) { ok = false; break; }
                dmg += c - a;
            }
            if (ok) best = Math.max(best, dmg);
        }

        List<Integer> rem = new ArrayList<>(cards);
        boolean okAll = true;
        int dmgAll = 0;

        for (int d : def) {
            int idx = -1;
            for (int i = 0; i < rem.size(); i++) {
                if (rem.get(i) > d) { idx = i; break; }
            }
            if (idx == -1) { okAll = false; break; }
            rem.remove(idx);
        }

        if (okAll) {
            for (int a : atk) {
                int idx = -1;
                for (int i = 0; i < rem.size(); i++) {
                    if (rem.get(i) >= a) { idx = i; break; }
                }
                if (idx == -1) { okAll = false; break; }
                dmgAll += rem.remove(idx) - a;
            }
        }
        if (okAll) {
            for (int c : rem) dmgAll += c;
            best = Math.max(best, dmgAll);
        }

        pw.println(best);
		pw.close();
	}
}
