import java.io.*;
import java.util.*;

public class madscientist {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("breedflip.in"));
        PrintWriter pw = new PrintWriter(new File("breedflip.out"));
        int n = s.nextInt();
        char[] want = s.next().toCharArray();
        char[] have = s.next().toCharArray();
        int curr = 0;
        int swaps = 0;
        for (int i = 0; i<n; i++){
            if (want[i]==have[i]) {
                if (curr!=0){
                    swaps++;
                    curr = 0;
                }
            }
            else {
                curr++;
            }
        }
        if (curr!=0) swaps++;
        pw.println(swaps);
        pw.close();
    }
}
