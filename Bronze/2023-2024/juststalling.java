import java.io.*;
import java.util.*;

public class juststalling {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] cows = new int[n];
        int[] stables = new int[n];
        for (int i = 0; i<n; i++){
            cows[i] = s.nextInt();
        }
        for (int i = 0; i<n; i++){
            stables[i] = s.nextInt();
        }
        Arrays.sort(cows);
        Arrays.sort(stables);
        int c = 0;
        long ret = 1;
        for (int i = n-1; i>0; i--){
            int x = 0;
            for (int j:stables) if (j>=cows[i]) x++;
            ret *= (long) (x-c);
            c++;
        }
        pw.println(ret);
        pw.close();
    }
}
