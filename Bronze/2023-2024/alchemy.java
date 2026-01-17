import java.io.*;
import java.util.*;

public class alchemy {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] resources = new int[n];
        for(int i = 0; i < n; i++) resources[i] = s.nextInt();
        int ans = 0;
        int[][] recipes = new int[n][];
        int k = s.nextInt();
        while(k-- > 0) {
            int gain = s.nextInt()-1;
            int t = s.nextInt();
            recipes[gain] = new int[t];
            for(int i = 0; i < t; i++) recipes[gain][i] = s.nextInt()-1;
        }
        while(canMake(recipes, resources, n-1)) ans++;
        pw.println(ans);
        pw.close();
    }
    private static boolean canMake(int[][] recipes, int[] resources, int want) {
        if(resources[want] > 0) {
            resources[want]--;
            return true;
        }
        if(recipes[want] == null) return false;
        for(int c : recipes[want]) if(!canMake(recipes, resources, c)) return false;
        return true;
    }
}
