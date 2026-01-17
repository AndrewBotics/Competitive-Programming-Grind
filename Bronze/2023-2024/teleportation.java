import java.io.*;
import java.util.*;

public class teleportation {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("teleport.in"));
        PrintWriter pw = new PrintWriter("teleport.out");
        int a = s.nextInt();
        int b = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        pw.println(Math.min(Math.min(Math.abs(a-x) + Math.abs(b-y), Math.abs(b-x) + Math.abs(a-y)), Math.abs(a-b)));
        pw.close();
    }
}

