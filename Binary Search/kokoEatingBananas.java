// Problem Statement: A monkey is given ‘n’ piles of bananas, whereas the ‘ith’ pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
// Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
// Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

//Problem Link: https://www.codingninjas.com/codestudio/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class kokoEatingBananas {
    public static int minimumRateToEatBananas(int[] v, int h) {
        int low = 1;
        int high = maxBananas(v);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHour = totalHours(v, mid);
            if (totalHour <= h) { // min can be found in left part
                high = mid - 1;
            } else {
                low = mid + 1; // min can be found in right part
            }
        }
        return low;
    }

    // method to find total number of hours koko can eat all bananas
    public static int totalHours(int[] v, int hours) {
        int total = 0;
        for (int i = 0; i < v.length; i++) {
            total += Math.ceil((double) v[i] / (double) hours);
        }
        return total;
    }

    // method to find maximum number of bananas in array
    public static int maxBananas(int[] v) {
        int n = v.length; // size of array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, v[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] v = { 7, 15, 6, 3 };
        int h = 8;
        int ans = minimumRateToEatBananas(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
