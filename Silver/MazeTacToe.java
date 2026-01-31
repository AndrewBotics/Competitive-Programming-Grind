import java.io.*;
import java.util.*;

public class MazeTacToe {
    public static int n;
    public static HashSet<Integer> set = new HashSet<>();
    public static boolean[][][] dp;
    public static Note[][] grid;
	public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		n = s.nextInt();
        grid = new Note[n][n];
        for (int i = 0; i<n; i++){
            grid[i] = generateFromString(s.next());
        }
        //for (Note[] no : grid) pw.println(Arrays.toString(no));

        int bi = 0;
        int bj = 0;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j].ch=='B') {
                    bi = i;
                    bj = j;
                }
            }
        }

        dp = new boolean[n][n][20000];
        dfs(bi, bj, new char[3][3]);

        pw.println(set.size());
		pw.close();
	}
    public static void dfs(int i, int j, char[][] board){
        if (i==-1 || j==-1 || i==n || j==n) return;
        if (grid[i][j].ch=='#') return;
        int enc = encode(board);
        if (dp[i][j][enc]) return;
        dp[i][j][enc] = true;
        if (grid[i][j].ch=='M' || grid[i][j].ch=='O'){
            Note note = grid[i][j];
            if (board[note.x][note.y]==0){
                char[][] next = copyOf(board);
                next[note.x][note.y] = note.ch;
                if (isWin(next)){
                    set.add(encode(next));
                    //System.out.println(i+" "+j+" "+Arrays.deepToString(next));
                    return;
                }
                dp[i][j][encode(next)] = true;
                dfs(i+1, j, next);
                dfs(i-1, j, next);
                dfs(i, j+1, next);
                dfs(i, j-1, next);
            }
            else {
                dfs(i+1, j, board);
                dfs(i-1, j, board);
                dfs(i, j+1, board);
                dfs(i, j-1, board);
            }
        }
        else {
            dfs(i+1, j, board);
            dfs(i-1, j, board);
            dfs(i, j+1, board);
            dfs(i, j-1, board);
        }
    }
    public static int encode(char[][] board){
        int ret = 0;
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                ret *= 3;
                if (board[i][j]=='M') ret += 2;
                else if (board[i][j]=='O') ret += 1;
            }
        }
        return ret;
    }
    public static boolean isWin(char[][] board){
        for (int i = 0; i<3; i++){
            if (board[i][0]=='M' && board[i][1]=='O' && board[i][2]=='O') return true;
            if (board[i][2]=='M' && board[i][1]=='O' && board[i][0]=='O') return true;
            if (board[0][i]=='M' && board[1][i]=='O' && board[2][i]=='O') return true;
            if (board[2][i]=='M' && board[1][i]=='O' && board[0][i]=='O') return true;
        }
        if (board[0][0]=='M' && board[1][1]=='O' && board[2][2]=='O') return true;
        if (board[2][2]=='M' && board[1][1]=='O' && board[0][0]=='O') return true;
        if (board[2][0]=='M' && board[1][1]=='O' && board[0][2]=='O') return true;
        if (board[0][2]=='M' && board[1][1]=='O' && board[2][0]=='O') return true;
        return false;
    }
    public static char[][] copyOf(char[][] board){
        char[][] ret = new char[3][3];
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                ret[i][j] = board[i][j];
            }
        }
        return ret;
    }
    public static Note[] generateFromString(String str){
        Note[] ret = new Note[n];
        for (int i = 0; i<n*3; i+=3){
            ret[i/3] = new Note(str.charAt(i), str.charAt(i+1), str.charAt(i+2));
        }
        return ret;
    }
    static class Note {
        public char ch;
        public int x;
        public int y;

        public Note(char a, char b, char c){
            ch = a;
            if (ch=='M' || ch=='O'){
                x = b-'1';
                y = c-'1';
            }
            else {
                x = 0;
                y = 0;
            }
        }

        public String toString(){
            return ch+"";
        }
    }
    static class Point {
        public int x;
        public int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
}
