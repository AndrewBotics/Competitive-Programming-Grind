import java.util.*;
import java.io.*;
 
public class revengine {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i=0; i<t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            s.nextLine();
            List<String> instances = new ArrayList<>();
            for (int j=0; j<m; j++) {
                instances.add(s.nextLine());
            }
            while (true) {
                int oldSize = instances.size();
                for (int j = 0; j<n; j++) {
                    for (char bit = '0'; bit <= '1'; bit++) {
                        int pos = 0;
                        for (String instance : instances) {
                            if (instance.charAt(j) == bit) {
                                pos |= 1 << (instance.charAt(n + 1) - '0');
                            }
                        }
                        if (pos != 3) {
                            int finalJ = j;
                            char finalBit = bit;
                            instances.removeIf(instance -> instance.charAt(finalJ) == finalBit);
                        }
                    }
                }
                int newSize = instances.size();
                if (newSize == oldSize) {
                    break;
                }
            }
            if (new HashSet<>(instances).isEmpty()) {
                System.out.println("OK");
            } else {
                System.out.println("LIE");
            }
        }
    }
}
