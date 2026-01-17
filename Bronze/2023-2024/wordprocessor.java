import java.io.*;
import java.util.*;

public class wordprocessor {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("word.in"));
        PrintWriter pw = new PrintWriter(new File("word.out"));
        int n = s.nextInt();
        int k = s.nextInt();
        List<String> ret = new ArrayList<>();
        int curr = 0;
        ret.add(s.next());
        int charct = ret.get(0).length();
        for (int i = 1; i<n; i++){
            String a = s.next();
            if (a.length()+charct<=k){
                ret.set(curr, ret.get(curr)+" "+a);
                charct += a.length();
            }
            else {
                curr++;
                ret.add(a);
                charct = a.length();
            }
        }
        for (String line : ret) pw.println(line);
        pw.close();
    }
}
