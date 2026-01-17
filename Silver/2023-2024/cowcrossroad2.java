import java.io.*;
import java.util.*;

public class cowcrossroad2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("maxcross.in"));
        PrintWriter pw = new PrintWriter(new File("maxcross.out"));
        int n = s.nextInt();
        int k = s.nextInt();
        int b = s.nextInt();
        List<Integer> lights = new ArrayList<>();
        for (int i = 0; i<b; i++){
            lights.add(s.nextInt());
        }
        if (!lights.contains(0)) lights.add(0);
        if (!lights.contains(n+1)) lights.add(n+1);
        Collections.sort(lights);
        outer: for (int i = 1; i<lights.size(); i++){
            for (int j = 0; j<lights.size() && j+i<lights.size(); j++){
                if (lights.get(j+i)-lights.get(j)>=k+1){
                    pw.println(i-1);
                    break outer;
                }
            }
        }
        pw.close();
    }
}
