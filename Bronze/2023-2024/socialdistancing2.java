import java.io.*;
import java.util.*;

public class socialdistancing2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("socdist2.in"));
        PrintWriter pw = new PrintWriter(new File("socdist2.out"));
        int n = s.nextInt();
        List<Integer> clean = new ArrayList<>();
        List<Integer> infected = new ArrayList<>();
        for (int i = 0; i<n; i++){
            int j = s.nextInt();
            int t = s.nextInt();
            if (t==0) clean.add(j);
            else infected.add(j);
        }
        Collections.sort(infected);

        int allrad = Integer.MAX_VALUE;
        for (int i : clean){
            int rad = 0;
            boolean searching = true;
            while (searching){
                rad++;
                if (infected.contains(i-rad) || infected.contains(i+rad)) searching = false;
            }
            if (rad<allrad) allrad = rad;
        }
        allrad--;

        int ret = 1;
        for (int i = 1; i<infected.size(); i++){
            if (infected.get(i)-infected.get(i-1)>allrad) ret++;
        }
        
        pw.println(ret);
        pw.close();
    }
}
