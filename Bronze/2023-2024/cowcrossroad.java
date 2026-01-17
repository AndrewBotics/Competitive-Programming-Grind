import java.io.*;
import java.util.*;

public class cowcrossroad {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("crossroad.in"));
        PrintWriter pw = new PrintWriter("crossroad.out");
        int n = s.nextInt();
        int[] cows = new int[11];
        for (int i = 0; i<11; i++) cows[i] = -1;
        int crosses = 0;
        for (int i = 0; i<n; i++){
            int cow = s.nextInt();
            int bin = s.nextInt();
            if (bin==0){
                if (cows[cow] == 1){
                    cows[cow] = 0;
                    crosses++;
                }
                else if (cows[cow] == -1){
                    cows[cow] = 0;
                }
            }
            if (bin==1){
                if (cows[cow] == 0){
                    cows[cow] = 1;
                    crosses++;
                }
                else if (cows[cow] == -1){
                    cows[cow] = 1;
                }
            }
        }
        pw.println(crosses);
        pw.close();
    }
}
