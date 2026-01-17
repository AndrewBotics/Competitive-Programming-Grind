// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class swapityswap {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("swap.in"));
        PrintWriter pw = new PrintWriter("swap.out");
        int n = s.nextInt();
        int t = s.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i<n; i++) cows[i] = i+1;
        int a1 = s.nextInt();
        int a2 = s.nextInt();
        int b1 = s.nextInt();
        int b2 = s.nextInt();
        int[] swap = initRev(cows, a1, a2);
        swap = initRev(swap, b1, b2);
        for (int i = 0; i<n; i++) {
            if (cows[i] == swap[i]) swap[i] = -1;
        }

        for (int i = 0; i<t; i++){
            int[] temp = Arrays.copyOf(cows, n);
            for (int j = 0; j<n; j++){
                if (swap[j]!=-1){
                    cows[j] = temp[swap[j]-1];
                }
            }
        }
        for (int ret : cows) pw.println(ret);
        pw.close();
    }
    static int[] initRev(int[] list, int a, int b){
        int[] newList = Arrays.copyOf(list, list.length);
        int[] reversed = new int[b-a+1];
        int x = 0;
        for (int i = b-1; i>a-2; i--){
            reversed[x] = newList[i];
            x++;
        }
        x = 0;
        Collections.reverse(Arrays.asList(reversed));
        for (int i = a-1; i<b; i++){
            newList[i] = reversed[x];
            x++;
        }
        return newList;
    }
}

