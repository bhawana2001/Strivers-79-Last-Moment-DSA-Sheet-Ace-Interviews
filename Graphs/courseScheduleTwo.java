//Problem Statement: There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

//Problem Link: https://leetcode.com/problems/course-schedule-ii/description/

import java.util.*;

class courseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return null;
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++)
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }

        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}