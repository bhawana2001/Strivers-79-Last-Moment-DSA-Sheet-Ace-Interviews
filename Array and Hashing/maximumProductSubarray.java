// Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

//Problem Link : https://www.codingninjas.com/codestudio/problems/subarray-with-maximum-product_6890008?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class maximumProductSubarray {
    public static int subarrayWithMaxProduct(int[] arr) {
        // Write your code here.
        int product1 = arr[0];
        int product2 = arr[0];
        int answer = arr[0];
        // loop for finding maximum product using kadane algorithm
        for (int i = 1; i < arr.length; i++) {
            int res = Math.max(arr[i],
                    Math.max(product1 * arr[i], product2 * arr[i]));
            product2 = Math.min(arr[i],
                    Math.min(product1 * arr[i], product2 * arr[i]));
            product1 = res;

            answer = Math.max(answer, product1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, -3, 0, -4, -5 };
        int answer = subarrayWithMaxProduct(nums);
        System.out.print("The maximum product subarray is: " + answer);
    }
}
