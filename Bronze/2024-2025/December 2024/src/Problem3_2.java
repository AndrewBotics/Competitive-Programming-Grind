import java.util.*;

public class Problem3_2 {
    public static void main(String[] args){
        //Roughly 100,000 operations.
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int f = s.nextInt();
        String str = s.next();
        List<String> moos = new ArrayList<>();
        int[] counts = new int[20000];
        List<String> ret = new ArrayList<>();

        for (int i = 0; i<n-2; i++){
            String sub = str.substring(i, i+3);
            if (!moos.contains(sub)) moos.add(sub);
            counts[moos.indexOf(sub)]++;
        }

        //Roughly 1,560,000 operations.
        HashSet<String> also = new HashSet<>();
        char[] dict = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i<moos.size(); i++){
            String curr = moos.get(i);
            for (String moo : moos){
                StringBuilder strb = new StringBuilder(moo);
                for (char c : dict){
                    for (int x = 0; x<3; x++) {
                        if (c!=moo.charAt(x)) {
                            strb.setCharAt(x, c);
                            also.add(strb.toString());
                            strb.setCharAt(x, moo.charAt(x));
                        }
                    }
                }
            }
        }


        for (int i = 0; i<moos.size(); i++){
            String curr = moos.get(i);
            if (counts[i]>=f && works(curr) && !ret.contains(curr)) ret.add(curr);
        }

        if (f==1){
            for (String c : also) if (works(c) && !ret.contains(c)) ret.add(c);
        }
        else {
            for (int i = 0; i<moos.size(); i++){
                String moo = moos.get(i);
                if (counts[i]==f-1 && works(moo)){
                    String[] words = str.split(moo);
                    for (String word : words) {
                        StringBuilder strb = new StringBuilder(moo);
                        for (char c : dict){
                            for (int x = 0; x<3; x++) {
                                if (c!=strb.charAt(x)) {
                                    strb.setCharAt(x, c);
                                    if (word.contains(strb.toString()) && !ret.contains(moo) && works(moo)) ret.add(moo);
                                    strb.setCharAt(x, moo.charAt(x));
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(ret);
        System.out.println(ret.size());
        for (String re : ret) System.out.println(re);

    }

    public static boolean works(String r){
        return (r.charAt(0)!=r.charAt(1)&&r.charAt(1)==r.charAt(2));
    }
}
