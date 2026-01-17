import java.io.*;
import java.util.*;

public class greatrevegetation {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new PrintWriter("revegetate.out"));
        int size = s.nextInt();
        int n = s.nextInt();
        List<Integer>[] pastures = new ArrayList[size];
        List<Integer>[] prefs = new ArrayList[size];
        for (int i = 0; i<size; i++){
            pastures[i] = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            prefs[i] = new ArrayList<>();
        }
        for (int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            prefs[Math.max(a, b)-1].add(Math.min(a, b)-1);
        }
        for (int i = 0; i<size; i++){
            pastures[i] = first(pastures[i]);
            for (int j = i+1; j<size; j++){
                if (prefs[j].contains(i)){
                    if (pastures[j].indexOf(pastures[i].get(0)) != -1){
                        pastures[j].remove(pastures[j].indexOf(pastures[i].get(0)));
                    }
                }
            }
        }
        for (List<Integer> i : pastures) pw.print(i.get(0));
        pw.close();
    }
    static List<Integer> first(List<Integer> a){
        return new ArrayList<>(Arrays.asList(a.get(0)));
    }
}

