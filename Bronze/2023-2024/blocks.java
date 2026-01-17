import java.io.*;
import java.util.*;

public class blocks {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        ArrayList<Character>[] blocks = new ArrayList[4];
        for (int i = 0; i<4; i++){
            blocks[i] = new ArrayList<>();
            char[] x = s.next().toCharArray();
            for (char a : x) if (!blocks[i].contains(a)) blocks[i].add(a);
            blocks[i].add('-');
        }
        ArrayList<Character>[] requests = new ArrayList[n];
        List<Boolean> works = new ArrayList<>();
        for (int i = 0; i<n; i++){
            requests[i] = new ArrayList<>();
            works.add(false);
            char[] x = s.next().toCharArray();
            for (char a : x) requests[i].add(a);
            while (requests[i].size()<4) requests[i].add('-');
            Collections.sort(requests[i]);
        }
        
        for (char a : blocks[0]){
            for (char b : blocks[1]){
                for (char c : blocks[2]){
                    for (char d : blocks[3]){
                        List<Character> curr = Arrays.asList(a, b, c, d);
                        Collections.sort(curr);
                        for (int i = 0; i<n; i++){
                            if (curr.equals(requests[i])) works.set(i, true);
                        }
                    }
                }
            }
        }
        
        for (boolean w : works) {
            if (w) pw.println("YES");
            else pw.println("NO");
        }
        pw.close();
    }
}
