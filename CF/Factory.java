// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Factory {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long a = s.nextLong();
        long m = s.nextLong();
        boolean works = false;
        for (int i = 0; i<=30 && !works; i++){
            if (a%m==0) works = true;
            a*=2;
        }
        pw.println(works?"Yes":"No");
		pw.close();
	}
}
