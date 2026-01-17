import java.io.*;
import java.util.*;

public class fjfarms {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k = 0; k<t; k++){
            int n = s.nextInt();
            int[] plants = new int[n];
            int[] growth = new int[n];
            int[] goals = new int[n];
            int reduce = Integer.MAX_VALUE;
            for (int i = 0; i<n; i++) plants[i] = s.nextInt();
            for (int i = 0; i<n; i++) {growth[i] = s.nextInt(); reduce = Math.min(reduce, growth[i]);}
            for (int i = 0; i<n; i++) goals[i] = s.nextInt();
            for (int i = 0; i<n; i++) growth[i] -= reduce;
            boolean going = true;
            int ct = 0;
            while (going){
                if (check(plants, goals)){
                    System.out.println(ct);
                    going = false;
                }
                else if (nullify(growth)){
                    System.out.println(-1);
                    going = false;
                }
                for (int j = 0; j<n; j++){
                    plants[j] += growth[j];
                }
                ct++;
            }
        }
    }
    static boolean check(int[] plants, int[] goals){
        int[] comparisons = new int[plants.length];
        for (int i = 0; i<plants.length; i++){
            for (int j = 0; j<plants.length; j++){
                if (i!=j){
                    if (plants[i]<plants[j]) comparisons[i]++;
                }
            }
        }
        if (Arrays.equals(comparisons, goals)) return true;
        return false;
    }
    static boolean nullify(int[] growth){
        int[] blank = new int[growth.length];
        boolean ret = true;
        for (int i : growth) if (i!=0) ret = false;
        return ret;
    }
}

