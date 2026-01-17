import java.io.*;
import java.util.*;

public class acowdemia1 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int l = s.nextInt();
        Integer[] papers = new Integer[n];
        for (int i = 0; i<n; i++) {
            papers[i] = s.nextInt();
        }
        Arrays.sort(papers, Comparator.reverseOrder());
        int h = hIndex(papers);
        if (h!=n) {
            for (int j = h; j>=0 && j>h-l; j--) {
                papers[j]++;
            }
        }
        Arrays.sort(papers, Comparator.reverseOrder());
        pw.println(hIndex(papers));
        pw.close();
    }
    static int hIndex(Integer[] papers){
        int ret = papers.length;
        while (ret > 0 && papers[ret-1] < ret){
            ret--;
        }
        return ret;
    }
}

