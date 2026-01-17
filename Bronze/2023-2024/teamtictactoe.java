import java.io.*;
import java.util.*;

public class teamtictactoe {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("tttt.in"));
		PrintWriter pw = new PrintWriter(new File("tttt.out"));
		char[][] board = new char[3][3];
		for (int i = 0; i<3; i++) board[i] = s.next().toCharArray();
		List<Character> onetypes = new ArrayList<>();
		List<String> twotypes = new ArrayList<>();
		for (int i = 0; i<3; i++) gameSolve(board[i][0], board[i][1], board[i][2], onetypes, twotypes);
		for (int i = 0; i<3; i++) gameSolve(board[0][i], board[1][i], board[2][i], onetypes, twotypes);
		gameSolve(board[0][0], board[1][1], board[2][2], onetypes, twotypes);
		gameSolve(board[0][2], board[1][1], board[2][0], onetypes, twotypes);

		pw.println(onetypes.size());
		pw.println(twotypes.size());
		pw.close();
	}
	static int solve(char a, char b, char c){
		HashSet<Character> chars = new HashSet<>();
		chars.add(a);
		chars.add(b);
		chars.add(c);
		return chars.size();
	}
	static void gameSolve(char a, char b, char c, List<Character> ones, List<String> twos){
		int sol = solve(a, b, c);
		if (sol==1 && !ones.contains(a)) ones.add(a);
		else if (sol==2){
			List<Character> abcs = new ArrayList<>();
			if (!abcs.contains(a)) abcs.add(a);
			if (!abcs.contains(b)) abcs.add(b);
			if (!abcs.contains(c)) abcs.add(c);
			Collections.sort(abcs);
			String abc = Character.toString(abcs.get(0)) + Character.toString(abcs.get(1));
			if (!twos.contains(abc)) twos.add(abc);
		}
	}
}