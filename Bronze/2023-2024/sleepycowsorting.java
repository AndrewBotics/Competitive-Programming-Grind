import java.io.*;
import java.util.*;

public class sleepycowsorting {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("sleepy.in"));
        PrintWriter pw = new PrintWriter(new File("sleepy.out"));
        int n = s.nextInt();
        int a = s.nextInt();
        int ret = 0;
        for (int i = 1; i<n; i++){
            int b = s.nextInt();
            if (b<a) ret = i;
            a = b;
        }
        pw.println(ret);
        pw.close();
    }
}
