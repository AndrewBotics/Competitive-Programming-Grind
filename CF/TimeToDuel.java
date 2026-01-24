import java.io.*;
import java.util.*;

public class TimeToDuel {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int a = s.nextInt();
        for (int i = 0; i<a; i++){
            int n = s.nextInt();
            int curr = s.nextInt();
            boolean zero = curr==0;
            boolean zeroCons = false;
            for (int j = 1; j<n; j++){
                int next = s.nextInt();
                if (curr==0 && next==0) zeroCons = true; 
                curr = next;
                zero |= curr==0;
            }
            pw.println(zeroCons || !zero ? "YES" : "NO");
        }
        pw.close();
    }
}

