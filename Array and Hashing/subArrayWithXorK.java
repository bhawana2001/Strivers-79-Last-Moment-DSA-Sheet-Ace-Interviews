// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.
//Problem Link: https://www.codingninjas.com/codestudio/problems/subarrays-with-xor-k_6826258?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.*;
public class subArrayWithXorK {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int n = a.length; //size of the given array.
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //declaring the map.
        map.put(xr, 1); //setting the value of 0.
        int count = 0;

        for (int i = 0; i < n; i++) {
            // prefix xor till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^b:
            int x = xr ^ b;

            // add the occurrence of xr^k
            // to the count:
            if (map.containsKey(x)) {
                count += map
                .get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (map.containsKey(xr)) {
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }
        }
        return count;
    }

    //main method
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithSumK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}