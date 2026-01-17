// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(r.readLine());
            tasks.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(tasks);

        //for (Task t : tasks) System.out.println(t.weight+" "+t.deadline);
        long sum = 0;
        long earned = 0;
        for (int i = 0; i<n; i++){
            sum += tasks.get(i).weight;
            earned += tasks.get(i).deadline-sum;
        }

        System.out.println(earned);
    }
}

class Task implements Comparable<Task> {
    public int weight;
    public int deadline;

    public Task(int w, int d){
        weight = w;
        deadline = d;
    }

    @Override
    public int compareTo(Task e){
        return weight - e.weight;
    }
}
