// Problem Statement:Given an array of asteroids where each element represents an asteroid's size and direction (positive for right, negative for left), simulate the collisions of asteroids. 
// When two asteroids collide, the smaller one is destroyed, and the larger one continues moving. Return the state of the asteroids after all collisions.

//Problem Link: https://www.codingninjas.com/studio/problems/asteroid-collision_977232?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class asteroidCollision {
    public static List<Integer> collidingAsteroids(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                st.push(asteroid); // Push right-moving asteroids onto the stack
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroid) {
                    st.pop(); // Destroy smaller right-moving asteroids
                }
                if (!st.isEmpty() && st.peek() == -asteroid) {
                    st.pop(); // Both asteroids are destroyed
                } else if (!st.isEmpty() && st.peek() > -asteroid) {
                    // Left-moving asteroid survives
                } else {
                    st.push(asteroid); // Left-moving asteroid is pushed onto the stack
                }
            }
        }
        List<Integer> ans = new ArrayList<>(st);
        return ans;
    }
}
