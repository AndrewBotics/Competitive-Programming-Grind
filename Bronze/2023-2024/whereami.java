import java.io.*;
import java.util.*;

public class whereami {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("whereami.in"));
        PrintWriter pw = new PrintWriter(new File("whereami.out"));
        int n = s.nextInt();
        String houses = s.next();
        HashSet<String> types = new HashSet<>();
        List<String> total = new ArrayList<>();
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<=n; j++){
                types.add(houses.substring(i, j));
                total.add(houses.substring(i, j));
            }
        }
        int ret = 0;
        for (String t : types){
            int count = Collections.frequency(total, t);
            if (count>1) ret = Math.max(ret, t.length());
        }
        //pw.println(total);
        //pw.println(types);
        pw.println(ret+1);
        pw.close();
    }
}
