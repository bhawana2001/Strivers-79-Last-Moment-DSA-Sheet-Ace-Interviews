// Problem Statement: You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis. You are also given an integer ‘k’. You have to place ‘k’ new gas stations on the X-axis. You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions. Let ‘dist’ be the maximum value of the distance between adjacent gas stations after adding k new gas stations.
// Find the minimum value of ‘dist’.

// Note: Answers within 10^-6 of the actual answer will be accepted. For example, if the actual answer is 0.65421678124, it is okay to return 0.654216. Our answer will be accepted if that is the same as the actual answer up to the 6th decimal place.

//Problem Link: https://www.codingninjas.com/codestudio/problems/minimise-max-distance_7541449?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class gasStation {
    public static double MinimiseMaxDistance(int[] arr, int K) {
        // Write your code here.
        int n = arr.length; // size of the array

        double low = 0;

        double high = 0;

        // Find the maximum distance
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));
        }

        double differ = 1e-6;

        while (high - low > differ) {
            double mid = (low + high) / (2.0);
            int count = numberOfGasStationsRequired(mid, arr);
            if (count > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static int numberOfGasStationsRequired(double distance, int[] arr) {
        int n = arr.length; // size of the array
        int count = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / distance);
            if ((arr[i] - arr[i - 1]) == (distance * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        double ans = MinimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
    }

}