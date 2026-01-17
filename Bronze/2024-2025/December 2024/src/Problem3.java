import java.util.*;
public class Problem3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int f = s.nextInt();
        String str = s.next();
        ArrayList<Character> m = new ArrayList<>();
        char[] dict = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c : str.toCharArray()) if (!m.contains(c)) m.add(c);
        Collections.sort(m);
        str = "!" + str + "!";
        for (char c : m){
            for (char o : m) if (c!=o){
                StringBuilder cur = new StringBuilder("");
                cur.append(c);
                cur.append(o);
                cur.append(o);
                String[] splits = str.split(cur.toString());
                if (splits.length>=f+1) System.out.println(cur.toString());
                else if (splits.length==f){
                    for (int i = 0; i<dict.length; i++){
                        char w = dict[i];
                        if (w!=cur.charAt(1)) {
                            cur.setCharAt(0, w);
                            for (String sp : splits) if (sp.contains(cur.toString())) {
                                cur.setCharAt(0, c);
                                System.out.println(cur.toString());
                            }
                        }
                    }
                    for (int i = 0; i<dict.length; i++){
                        char w = dict[i];
                        cur.setCharAt(1, w);
                        for (String sp : splits) if (sp.contains(cur.toString())) {
                            cur.setCharAt(1, o);
                            System.out.println(cur.toString());
                        }
                    }
                    for (int i = 0; i<dict.length; i++){
                        char w = dict[i];
                        cur.setCharAt(2, w);
                        for (String sp : splits) if (sp.contains(cur.toString())) {
                            cur.setCharAt(2, o);
                            System.out.println(cur.toString());
                        }
                    }
                }
            }
        }
    }
}
