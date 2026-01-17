// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BuildGates {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new File("gates.out"));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int x = 1000;
        int y = 1000;
        boolean[][] queries = new boolean[2000][2000];
        for (int i = 0; i<n; i++){
            if (s.charAt(i) == 'N'){
                queries[x][y+1] = true;
                queries[x][y+2] = true;
                y += 2;
            }
            else if (s.charAt(i) == 'E'){
                queries[x+1][y] = true;
                queries[x+2][y] = true;
                x += 2;
            }
            else if(s.charAt(i) == 'S'){
                queries[x][y-1] = true;
                queries[x][y-2] = true;
                y -= 2;
            }
            else{
                queries[x-1][y] = true;
                queries[x-2][y] = true;
                x -= 2;
            }
        }

        //printQueries();

        int ct = -1;
        for (int i = 0; i<queries.length; i++){
            for (int j = 0; j<queries.length; j++){
                if (!queries[i][j]){
                    ct++;
                    floodFill(queries, i, j);
                    //pw.println(i+" "+j);
                }
            }
        }
        pw.println(ct);
		pw.close();
	}
    public static void floodFill(boolean[][] queries, int i, int j){
        Stack<Pair> stack = new Stack();
        stack.add(new Pair(i,j));
        while (stack.size() != 0){
            Pair pair = stack.pop();
            queries[pair.x][pair.y] = true;
                
            if (pair.x+1 >= 0 && pair.x+1 < 2000 && pair.y >= 0 && pair.y < 2000 && !queries[pair.x+1][pair.y]) stack.add(new Pair(pair.x+1,pair.y));
            if (pair.x-1 >= 0 && pair.x-1 < 2000 && pair.y >= 0 && pair.y < 2000 && !queries[pair.x-1][pair.y]) stack.add(new Pair(pair.x-1,pair.y));
            if (pair.x >= 0 && pair.x < 2000 && pair.y-1 >= 0 && pair.y-1 < 2000 && !queries[pair.x][pair.y-1]) stack.add(new Pair(pair.x,pair.y-1));
            if (pair.x >= 0 && pair.x < 2000 && pair.y+1 >= 0 && pair.y+1 < 2000 && !queries[pair.x][pair.y+1]) stack.add(new Pair(pair.x,pair.y+1));
        }
    }
    static class Pair{
        public int x, y;
        public Pair(int X, int Y){
            x = X;
            y = Y;
        }
    }
}