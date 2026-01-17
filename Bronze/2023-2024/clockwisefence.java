import java.io.*;
import java.util.*;

public class clockwisefence {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        for (int i = 0; i<n; i++){
            char[] x = s.next().toCharArray();
            int pos = 0;
            int maxx = 0;
            int minx = 0;
            char curr = '-';
            String ret = "CW";
            for (char a : x){
                if (a=='E'){
                    pos++;
                    curr = 'E';
                }
                if (a=='W'){
                    pos--;
                    curr = 'W';
                }
                if (a=='N'){
                    if (pos > maxx) {
                        if (curr=='E') ret = "CCW";
                        maxx = pos;
                    }
                    if (pos < minx) {
                        if (curr=='W') ret = "CW";
                        minx = pos;
                    }
                }
                if (a=='S'){
                    if (pos > maxx) {
                        if (curr=='E') ret = "CW";
                        maxx = pos;
                    }
                    if (pos < minx) {
                        if (curr=='W') ret = "CCW";
                        minx = pos;
                    }
                }
            }
            pw.println(ret);
        }
        pw.close();
    }
}
