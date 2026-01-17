import java.io.*;
import java.util.*;

public class udderednotherd {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        char[] alphabet = s.next().toCharArray();
        List<Character> word = new ArrayList<>();
        String temp = s.next();
        for (int i = 0; i<temp.length(); i++){
            word.add(temp.charAt(i));
        }
        boolean going = true;
        int count = 0;
        while (going){
            for (int i = 0; i<alphabet.length; i++){
                if (word.size()!=0){
                    if (alphabet[i]==word.get(0)){
                        word.remove(0);
                    }
                }
            }
            if (word.size()==0) going = false;
            count++;
        }
        pw.println(count);
        pw.close();
    }
}
