import java.io.*;
import java.util.*;

public class photoshoot {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("photo.in"));
        PrintWriter pw = new PrintWriter(new File("photo.out"));
        int n = s.nextInt();
        boolean searching = true;
        int[] bes = new int[n-1];
        for (int i = 0; i<n-1; i++) bes[i] = s.nextInt(); 
        for (int i = 1; i<n && searching; i++){
            List<Integer> ret = new ArrayList<>();
            ret.add(i);
            for (int j = 1; j<n; j++) ret.add(bes[j-1]-ret.get(j-1));
            boolean works = true;
            for (int j = 1; j<=n; j++) if (!ret.contains(j)) works = false;
            if (works) {
                pw.print(ret.get(0));
                for (int j = 1; j<n; j++) pw.print(" "+ret.get(j));
                searching = false;
            }
        }
        pw.close();
    }
}
