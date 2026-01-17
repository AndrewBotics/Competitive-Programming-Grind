import java.io.*;
import java.util.*;

public class race {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("race.in"));
        PrintWriter pw = new PrintWriter(new File("race.out"));
        int k = s.nextInt();
        int n = s.nextInt();

        for (int i = 0; i < n; i += 1) {
            int x = s.nextInt();

            int d = k;
            int speed = 0;
            int time = 0;

            while (true) {
                speed++;
                d -= speed;
                time++;
                if (d <= 0) {
                    break;
                }
                if (speed >= x) {
                    d -= speed;
                    time++;
                    if (d <= 0) {
                        break;
                    }
                }
            }

            pw.println(time);
        }

        pw.close();
    }
}