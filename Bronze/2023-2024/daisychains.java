import java.io.*;
import java.util.*;

public class daisychains {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] flowers = new int[n];
        int[] totals = new int[n];
        for (int i = 0; i<n; i++) {
            flowers[i] = s.nextInt();
            if (i==0) totals[0] = flowers[0];
            else totals[i] = flowers[i]+totals[i-1];
        }
        int all = 0;
        for (int i = 0; i<n; i++){
            for (int j = i; j<n; j++){
                float mean = (float) (totals[j] - totals[i] + flowers[i])/(j-i+1);
                if (0==(mean - (int) mean)){
                    boolean check = false;
                    for (int k=i; k<=j; k++){
                        if (flowers[k]==mean) check = true;
                    }
                    if (check) all++;
                }
            }
        }
        pw.println(all);
        pw.close();
    }
}
