import java.io.*;
import java.util.*;

public class lonelyphoto {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		String str = s.next();
		int ret = 0;
		for (int i = 0; i<n; i++){
			int g = 0;
			int h = 0;
			for (int j = i; j<n; j++){
				if (str.charAt(j)=='G') g++;
				else h++;
				if (h+g>=3 && (g==1 || h==1)) ret++;
			}
		}
		pw.println(ret);
		pw.close();
	}
}
