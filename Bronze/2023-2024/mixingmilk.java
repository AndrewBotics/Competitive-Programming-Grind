import java.io.*;
import java.util.*;

public class mixingmilk {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new File("mixmilk.out"));
        int capA = s.nextInt();
        int a = s.nextInt();
        int capB = s.nextInt();
        int b = s.nextInt();
        int capC = s.nextInt();
        int c = s.nextInt();
        for (int i = 0; i<33; i++){
            b += a;
            a = 0;
            int t = b-capB;
            if (t>0){
                b -= t;
                a += t;
            }

            c += b;
            b = 0;
            t = c-capC;
            if (t>0){
                c -= t;
                b += t;
            }

            a += c;
            c = 0;
            t = a-capA;
            if (t>0){
                a -= t;
                c += t;
            }
        }
        b += a;
        a = 0;
        int t = b-capB;
        if (t>0){
            b -= t;
            a += t;
        }
        pw.println(a);
        pw.println(b);
        pw.println(c);
        pw.close();
    }
}
