//Problem Statement: Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
// However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
// Return the least number of units of times that the CPU will take to finish all the given tasks.

//Problem Link: https://www.codingninjas.com/studio/problems/task-scheduler_1070424?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;
import java.io.*;

public class taskScheduler {
    public static int taskScheduler(String s, int n, int k) {
        // Write your code here.
        Map<Character, Integer> counts = new HashMap<>();
        for (char t : s.toCharArray()) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(counts.values());

        int result = 0;
        while (!pq.isEmpty()) {
            int time = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < k + 1; ++i) {
                if (!pq.isEmpty()) {
                    int top = pq.poll();
                    if (top - 1 > 0) {
                        tmp.add(top - 1);
                    }
                    time++;
                }
            }
            tmp.forEach(t -> pq.offer(t));
            result += pq.isEmpty() ? time : k + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAABBB";
        System.out.println(taskScheduler(s, 6, 2));
    }

}
