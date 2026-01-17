import java.io.*;
import java.util.*;

public class herdle {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String[] answers = new String[]{s.next(), s.next(), s.next()};
        String[] guesses = new String[]{s.next(), s.next(), s.next()};
        int greens = 0;
        int yellows = 0;
        char[] ans = new char[9];
        char[] gues = new char[9];
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                ans[i*3+j] = answers[i].charAt(j);
                gues[i*3+j] = guesses[i].charAt(j);
            }
        }
        for (int i = 0; i<9; i++){
            if (ans[i]==gues[i]){
                greens++;
                ans[i] = 'x';
                gues[i] = 'y';
            }
        }
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (ans[i]==gues[j]){
                    yellows++;
                    ans[i] = 'x';
                    gues[j] = 'y';
                }
            }
        }
        //pw.println(Arrays.toString(ans));
        //pw.println(Arrays.toString(gues));
        pw.println(greens);
        pw.println(yellows);
        pw.close();
    }
}
