import java.io.*;
import java.util.*;

public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("triangles.in"));
		PrintWriter pw = new PrintWriter(new File("triangles.out"));
		int n = s.nextInt();
		int[][] coords = new int[n][2];
		for (int i = 0; i<n; i++){
			coords[i][0] = s.nextInt();
			coords[i][1] = s.nextInt(); 
		}
		int max = 0;
		for (int a = 0; a<n-2; a++){
			int ax = coords[a][0];
			int ay = coords[a][1];
			for (int b = a+1; b<n-1; b++){
				int bx = coords[b][0];
				int by = coords[b][1];
				for (int c = b+1; c<n; c++){
					int cx = coords[c][0];
					int cy = coords[c][1];
					int temp = 0;
					if (ax==bx && cx!=ax) {
						if (ay==cy){
							temp = Math.abs((ax-cx)*(ay-by));
						}
						else if (by==cy){
							temp = Math.abs((bx-cx)*(ay-by));
						}
					}
					else if (bx==cx && ax!=bx){
						if (by==ay){
							temp = Math.abs((bx-ax)*(by-cy));
						}
						else if (cy==ay){
							temp = Math.abs((cx-ax)*(by-cy));
						}
					}
					else if (ax==cx && bx!=cx){
						if (ay==by){
							temp = Math.abs((ax-bx)*(ay-cy));
						}
						else if (cy==by){
							temp = Math.abs((cx-bx)*(ay-cy));
						}
					}
					if (temp>max) max = temp;
				}
			}
		}
		pw.println(max);
		pw.close();
	}
}