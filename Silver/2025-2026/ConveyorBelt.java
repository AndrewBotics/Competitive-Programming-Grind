// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ConveyorBelt {
    public static int n;
    public static char[][] grid;
    public static boolean[][] good;
    public static int ct = 0;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = s.nextInt();
        int q = s.nextInt();
        grid = new char[n][n];
        good = new boolean[n][n];
        Query[] queries = new Query[q];
        for (int i = 0; i<q; i++){
            queries[i] = new Query(s.nextInt(), s.nextInt(), s.next());
            grid[queries[i].x][queries[i].y] = queries[i].dir;
        }

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++) dfs(i, j);
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(n*n-ct);
        for (int i = q-1; i>0; i--){
            Query qu = queries[i];
            grid[qu.x][qu.y] = 0;
            dfs(qu.x, qu.y);
            stack.push(n*n-ct);
        }
        while (!stack.isEmpty()) pw.println(stack.pop());

		pw.close();
	}
    public static void dfs(int i, int j){
        if (!isValid(i, j)) return;
        if (!checkGood(i, j)) return;
        if (good[i][j]) return;

        good[i][j] = true;
        ct++;
        
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }

    public static boolean checkGood(int i, int j){
        if (grid[i][j]==0 && border(i, j)) return true;
        if ((grid[i][j]==0 || grid[i][j]=='D') && ((isValid(i+1, j)&&good[i+1][j])||!isValid(i+1, j))) return true;
        if ((grid[i][j]==0 || grid[i][j]=='U') && ((isValid(i-1, j)&&good[i-1][j])||!isValid(i-1, j))) return true;
        if ((grid[i][j]==0 || grid[i][j]=='L') && ((isValid(i, j-1)&&good[i][j-1])||!isValid(i, j-1))) return true;
        if ((grid[i][j]==0 || grid[i][j]=='R') && ((isValid(i, j+1)&&good[i][j+1])||!isValid(i, j+1))) return true;
        return false;
    }

    public static boolean isValid(int i, int j){
        return i>-1 && j>-1 && i<n && j<n;
    }

    public static boolean border(int i, int j){
        return i==0 || j==0 || i==n-1 || j==n-1;
    }

    static class Query {
        public int x;
        public int y;
        public char dir;
        
        public Query(int a, int b, String d){
            x = a-1;
            y = b-1;
            dir = d.charAt(0);
        }
    }
    static class Pair {
        public int x;
        public int y;

        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
}
