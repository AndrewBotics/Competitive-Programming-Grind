import java.io.*;
import java.util.*;

public class abcs {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int[] x = new int[7];
        for (int i = 0; i<7; i++){
            x[i] = s.nextInt();
        }
        Arrays.sort(x);
        pw.println(x[0]+" "+x[1]+" "+(x[6]-x[0]-x[1]));
        pw.close();
    }
}
