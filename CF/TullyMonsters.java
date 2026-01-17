// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class TullyMonsters {
    public static char[][] maze;
    public static int[][] monsDist;
    public static int[][] meDist;
    public static char[][] meDir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maze = new char[n][m];
        Queue<Point> pq = new LinkedList<>();
        Point start = new Point(0, 0);
        for (int i = 0; i<n; i++){
            maze[i] = br.readLine().toCharArray();
            for (int j = 0; j<m; j++) {
                if (maze[i][j]=='M') pq.add(new Point(i, j));
                else if (maze[i][j]=='A') start = new Point(i, j);
            }
        }

        //pw.println(mons);
        //pw.println(start);
        monsDist = new int[n][m];
        for (int[] arr : monsDist) Arrays.fill(arr, Integer.MAX_VALUE);
        for (Point p : pq) monsDist[p.x][p.y] = 0;
        meDist = new int[n][m];
        for (int[] arr : meDist) Arrays.fill(arr, Integer.MAX_VALUE);
        meDist[start.x][start.y] = 0;

        while (!pq.isEmpty()){
            Point p = pq.remove();
            if (possible(p.x+1, p.y) && monsDist[p.x][p.y]+1<monsDist[p.x+1][p.y]) {
                monsDist[p.x+1][p.y] = monsDist[p.x][p.y]+1;
                pq.add(new Point(p.x+1, p.y));
            }
            if (possible(p.x-1, p.y) && monsDist[p.x][p.y]+1<monsDist[p.x-1][p.y]) {
                monsDist[p.x-1][p.y] = monsDist[p.x][p.y]+1;
                pq.add(new Point(p.x-1, p.y));
            }
            if (possible(p.x, p.y+1) && monsDist[p.x][p.y]+1<monsDist[p.x][p.y+1]) {
                monsDist[p.x][p.y+1] = monsDist[p.x][p.y]+1;
                pq.add(new Point(p.x, p.y+1));
            }
            if (possible(p.x, p.y-1) && monsDist[p.x][p.y]+1<monsDist[p.x][p.y-1]) {
                monsDist[p.x][p.y-1] = monsDist[p.x][p.y]+1;
                pq.add(new Point(p.x, p.y-1));
            }
        }
        //for (int[] nums : monsDist) pw.println(Arrays.toString(nums));
        //pw.println();

        meDir = new char[n][m];
        for (char[] arr : meDir) Arrays.fill(arr, ' ');
        pq.add(start);
        while (!pq.isEmpty()){
            Point p = pq.remove();
            if (possible(p.x+1, p.y) && meDist[p.x][p.y]+1<meDist[p.x+1][p.y]) {
                meDist[p.x+1][p.y] = meDist[p.x][p.y]+1;
                meDir[p.x+1][p.y] = 'D';
                pq.add(new Point(p.x+1, p.y));
            }
            if (possible(p.x-1, p.y) && meDist[p.x][p.y]+1<meDist[p.x-1][p.y]) {
                meDist[p.x-1][p.y] = meDist[p.x][p.y]+1;
                meDir[p.x-1][p.y] = 'U';
                pq.add(new Point(p.x-1, p.y));
            }
            if (possible(p.x, p.y+1) && meDist[p.x][p.y]+1<meDist[p.x][p.y+1]) {
                meDist[p.x][p.y+1] = meDist[p.x][p.y]+1;
                meDir[p.x][p.y+1] = 'R';
                pq.add(new Point(p.x, p.y+1));
            }
            if (possible(p.x, p.y-1) && meDist[p.x][p.y]+1<meDist[p.x][p.y-1]) {
                meDist[p.x][p.y-1] = meDist[p.x][p.y]+1;
                meDir[p.x][p.y-1] = 'L';
                pq.add(new Point(p.x, p.y-1));
            }
        }
        //for (int[] nums : meDist) pw.println(Arrays.toString(nums));
        //for (char[] nums : meDir) pw.println(Arrays.toString(nums));

        printAnswer(n, m, pw);
		pw.close();
	}
    static class Point {
        public int x;
        public int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
        public String toString(){
            return x+"-"+y;
        }
    }
    public static boolean possible(int x, int y){
        if (x<0 || x==monsDist.length) return false;
        if (y<0 || y==monsDist[0].length) return false;
        return maze[x][y]!='#';
    }
    public static void printAnswer(int n, int m, PrintWriter pw){
        for (int i = 0; i<n; i++){
            String path = calcPath(i, 0);
            String path2 = calcPath(i, m-1);
            if (path!=null) {
                pw.println("YES");
                pw.println(path.length());
                pw.println(path);
                return;
            }
            else if (path2!=null) {
                pw.println("YES");
                pw.println(path2.length());
                pw.println(path2);
                return;
            }
        }
        for (int j = 1; j<m-1; j++){
            String path = calcPath(0, j);
            String path2 = calcPath(n-1, j);
            if (path!=null) {
                pw.println("YES");
                pw.println(path.length());
                pw.println(path);
                return;
            }
            else if (path2!=null) {
                pw.println("YES");
                pw.println(path2.length());
                pw.println(path2);
                return;
            }
        }
        pw.println("NO");
    }
    public static String calcPath(int x, int y){
        if (maze[x][y]=='A') return "";
        if (meDir[x][y]==' ') return null;
        StringBuilder sb = new StringBuilder();
        while (meDir[x][y]!=' '){
            if (monsDist[x][y]<=meDist[x][y]) return null;
            sb.append(meDir[x][y]);
            if (meDir[x][y]=='U') x++;
            else if (meDir[x][y]=='D') x--;
            else if (meDir[x][y]=='L') y++;
            else if (meDir[x][y]=='R') y--;
        }
        sb.reverse();
        return sb.toString();
    }
}
