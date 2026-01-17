import java.io.*;
import java.util.*;

public class milkfactory {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("factory.in"));
        PrintWriter pw = new PrintWriter(new File("factory.out"));
        int n = s.nextInt();
        List<Integer>[] reaches = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            reaches[i] = new ArrayList<>();
            reaches[i].add(i);
        }
        for (int i = 0; i<n-1; i++){
            int x = s.nextInt()-1;
            int y = s.nextInt()-1;
            reaches[y].add(x);
            Collections.sort(reaches[y]);
        }
        List<Integer> perfect = new ArrayList<>();
        for (int i = 0; i<n; i++) perfect.add(i);

        boolean going = check(perfect, reaches) == -1;
        while (going){
            List<Integer>[] curr = new ArrayList[n];
            for (int i = 0; i<n; i++) curr[i] = clone(reaches[i]);
            for (int i = 0; i<n; i++){
                List<Integer> mod = new ArrayList<>();
                for (int j : curr[i]) {
                    for (int k : curr[j]) {
                        if (!curr[i].contains(k) && !mod.contains(k)) mod.add(k);
                    }
                }
                curr[i].addAll(mod);
            }
            for (int i = 0; i<n; i++) Collections.sort(curr[i]);
            going = checkDiff(reaches, curr);
            if (going) going = check(perfect, curr) == -1;
            for (int i = 0; i<n; i++) reaches[i] = clone(curr[i]);
        }
        pw.println(check(perfect, reaches));
        pw.close();
    }
    static int check(List<Integer> perfect, List<Integer>[] reaches){
        for (int i = 0; i<reaches.length; i++){
            if (reaches[i].equals(perfect)) return i+1;
        }
        return -1;
    }
    static boolean checkDiff(List<Integer>[] prev, List<Integer>[] next){
        for (int i = 0; i<prev.length; i++){
            if (!prev[i].equals(next[i])) return true;
        }
        return false;
    }
    static List<Integer> clone(List<Integer> obj){
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i<obj.size(); i++) ret.add(obj.get(i));
        return ret;
    }
}

