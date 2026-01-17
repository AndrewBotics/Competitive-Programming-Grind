import java.io.*;
import java.util.*;

public class backandforth {
    static HashSet<Integer> answer = new HashSet<>();
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("backforth.in"));
        PrintWriter pw = new PrintWriter(new File("backforth.out"));
        ArrayList<Integer> barnA = new ArrayList<>();
        ArrayList<Integer> barnB = new ArrayList<>();
        for (int i = 0; i<10; i++) barnA.add(s.nextInt());
        for (int i = 0; i<10; i++) barnB.add(s.nextInt());
        solve(4, barnA, barnB, 1000, 1000);
        pw.println(answer.size());
        pw.close();
    }

    private static void solve(int depth, ArrayList<Integer> source, ArrayList<Integer> dest, int tankA, int tankB) {
        if (depth == 0) {
            answer.add(tankA);
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            ArrayList<Integer> barnAnew = new ArrayList<>(source);
            ArrayList<Integer> barnBnew = new ArrayList<>(dest);
            barnBnew.add(source.get(i));
            barnAnew.remove(i);
            solve(depth - 1, barnBnew, barnAnew, tankB - source.get(i), tankA + source.get(i));
        }
    }
} 
