import java.io.*;
import java.util.*;

public class yearofthecow {
    static final String[] years = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();

        Relation[] relations = new Relation[n];
        for (int r = 0; r < n; r++) {
            String name = s.next();
            s.next();
            s.next();
            boolean prev = s.next().equals("previous");
            String animal = s.next();
            int year = -1;
            for (int i = 0; i < years.length; i++) {
                if (years[i].equals(animal)) { year = i; }
            }
            s.next();
            s.next();
            String relative = s.next();
            relations[r] = new Relation(name, prev, year, relative);
        }

        Map<String, Integer> birthYears = new HashMap<>();
        birthYears.put("Bessie", 0);
        for (Relation r : relations) {
            int change = r.prev ? -1 : 1;
            int year = birthYears.get(r.relative) + change;
            while (mod(year, years.length) != r.year) { year += change; }
            birthYears.put(r.name, year);
        }

        int dist = Math.abs(birthYears.get("Bessie") - birthYears.get("Elsie"));
        pw.println(dist);
        pw.close();
    }

    static int mod(int n, int m) {
        return ((n % m) + m) % m; 
    }

    static class Relation {
        String name;
        boolean prev;
        int year;
        String relative;
        public Relation(String name, boolean prev, int year, String relative) {
            this.name = name;
            this.prev = prev;
            this.year = year;
            this.relative = relative;
        }
    }
}
