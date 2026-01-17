import java.util.*;
import java.io.*;

class fieldreduction {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("reduce.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("reduce.out"));
		int n = s.nextInt();
		int[][] arr = new int[2][n];
		for (int i = 0; i < n; i++) {
			arr[0][i] = s.nextInt();
			arr[1][i] = s.nextInt();
		}
		long min = (long) Math.pow(40000, 2);
		for (int i = 0; i < n; i++) {
			min = Math.min(area(arr, i), min);
		}
		pw.println(min);
		pw.close();
	}
	static long area(int[][] arr, int index){
		int maxx = 0;
		int maxy = 0;
		int minx = 40000;
		int miny = 40000;
		for (int i = 0; i < arr[0].length; i++) {
			if (i!=index){
				maxx = Math.max(maxx, arr[0][i]);
				maxy = Math.max(maxy, arr[1][i]);
				minx = Math.min(minx, arr[0][i]);
				miny = Math.min(miny, arr[1][i]);
			}
		}
		return (long) (maxx-minx)*(maxy-miny);
	}
}