import java.io.*;
import java.util.*;

public class moreoddphotos {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int odds = 0;
        int evens = 0;
        for (int i = 0; i<n; i++){
            if (s.nextInt()%2 == 1) odds++;
            else evens++;
        }
        int ret = 0;
        for (int i = 0; i<n; i++){
            if (ret%2==0 && evens>=1){
                evens--;
                ret++;
            }
            else if (ret%2==0 && odds>=2) {
                odds -= 2;
                ret++;
            }
            else if (ret%2==1 && odds>=1){
                odds--;
                ret++;
            }
            else if (ret%2==0 && odds==1){
                odds--;
                ret--;
            }
        }
        pw.println(ret);
        pw.close();
    }
}

