// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class acowdemia3 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int x = s.nextInt();
		int y = s.nextInt();
		char[][] grid = new char[x+2][y+2];
		Arrays.fill(grid[0], '.');
		Arrays.fill(grid[x+1], '.');
		for (int i = 1; i<=x; i++) grid[i] = ("."+s.next()+".").toCharArray();
		//for (char[] line : grid) pw.println(Arrays.toString(line));
		
		int ans = 0;
		for (int i = 1; i<=x; i++){
			for (int j = 1; j<=y; j++){
				if (grid[i][j]=='G'){
					if ((grid[i-1][j]=='C' && grid[i+1][j]=='C') || (grid[i][j-1]=='C' && grid[i][j+1]=='C')){
						grid[i][j] = '.';
						ans++;
					}
				}
			}
		}
		for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (grid[i][j] == 'C') {
                    if (grid[i + 1][j - 1] == 'C') {
                        if (grid[i][j - 1] == 'G') {
                            grid[i][j - 1] = '.';
                            ans++;
                        } else if (grid[i + 1][j] == 'G') {
                            grid[i + 1][j] = '.';
                            ans++;
                        }
                    }
                    if (grid[i + 1][j + 1] == 'C') {
                        if (grid[i][j + 1] == 'G') {
                            grid[i][j + 1] = '.';
                            ans++;
                        } else if (grid[i + 1][j] == 'G') {
                            grid[i + 1][j] = '.';
                            ans++;
                        }
                    }
                }
            }
        }
		pw.println(ans);
		pw.close();
	}
}
