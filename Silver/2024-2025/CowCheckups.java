// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CowCheckups {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] ind = new int[n+1];
        for (int i = 1; i<=n; i++) a[i] = s.nextInt();
        for (int i = 1; i<=n; i++) {
            b[i] = s.nextInt();
            ind[i] = ind[i-1];
            if (a[i]==b[i]) ind[i]++;
        }
        //System.out.println(Arrays.toString(ind));
        long ct = 0;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                if (i<=j){
                    if (a[i]==b[j]){
                        ct += Math.min(n-j+1, i);
                    }
                    ct += ind[i-1];
                    ct += ind[n]-ind[j];
                    //System.out.println(i+" "+j+" "+ct);
                }
                else {
                    if (a[i]==b[j]){
                        ct += Math.min(n-i+1, j);
                    }
                    //System.out.println(i+" "+j+" "+ct);
                }
            }
        }
        System.out.println(ct);
	}
}
