// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RaabGame {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();

        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();

            if (a+b>n || (a==0 && b!=0) || (a!=0 && b==0)){
                pw.println("NO");
            }
            else {
                pw.println("YES");
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i<=n; i++) sb.append(i).append(" ");
                pw.println(sb);

                sb = new StringBuilder();
                for (int i = 1; i<=n-a-b; i++) sb.append(i).append(" ");
                for (int i = n-b+1; i<=n; i++) sb.append(i).append(" ");
                for (int i = n-a-b+1; i<=n-b; i++) sb.append(i).append(" ");
                pw.println(sb);
            }
        }
		pw.close();
	}
}
