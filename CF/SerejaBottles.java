import java.io.*;
import java.util.*;

public class SerejaBottles {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            b[i] = s.nextInt();
        }

        boolean[] opened = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && b[j] == a[i]) {
                    opened[i] = true;
                }
            }
        }

        int cnt = 0;
        for (boolean canOpen : opened) if (!canOpen) cnt++;
        System.out.println(cnt);
    }
}
