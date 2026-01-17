// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SmolString {
    static class String2 implements Comparable<String2> {
        public String str;
        
        public String2 (String st) {
            str = st;
        }

        public String toString(){
            return str;
        }

        @Override
        public int compareTo(String2 str2){
            return (str+str2.str).compareTo(str2.str+str);
        }
    }
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        String2[] strings = new String2[n];
        for (int i = 0; i<n; i++){
            strings[i] = new String2(s.next());
        }
        Arrays.sort(strings);
        StringBuilder ret = new StringBuilder();
        for (String2 x : strings) ret.append(x.str);
        pw.println(ret);
		pw.close();
	}
}
