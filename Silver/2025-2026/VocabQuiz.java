// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class VocabQuiz {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int[] words = new int[n+1];
        for (int i = 1; i<=n; i++){
            words[i] = s.nextInt();
        }
        //pw.println(Arrays.toString(words));
        int[] children = new int[n+1];
        int[] len = new int[n+1];
        for (int i = 1; i<=n; i++){
            len[i] = len[words[i]]+1;
            children[words[i]]++;
        }
        int leaves = 0;
        for (int i = 1; i<=n; i++) if (children[i]==0) leaves++;
        while (leaves-->0){
            int x = s.nextInt();
            while (true){
                if (x==0) {
                    pw.println(0);
                    break;
                }
                if (children[words[x]]==1){
                    x = words[x];
                    children[x] = 0;
                    continue;
                }
                pw.println(len[x]);
                children[words[x]]--;
                break;
            }
        }

		pw.close();
	}
}
