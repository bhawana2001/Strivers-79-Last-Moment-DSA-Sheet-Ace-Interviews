// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). 
// Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array. 

//Problem Link: https://www.codingninjas.com/codestudio/problems/rotated-array_1093219?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class minimumInRotatedSortedArray {
    public static int findMin(int[] arr) {
         int low = 0;
         int high = arr.length - 1;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                res = Math.min(res, arr[low]);
                break;
            }
            //if left part is sorted
            if (arr[low] <= arr[mid]) {
                // keep the minimum
                res = Math.min(res, arr[low]);
                // Eliminate left half
                low = mid + 1;

            } else { 
                //if right part is sorted
                // keep the minimum
                res = Math.min(res, arr[mid]);
                // Eliminate right half
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);
        System.out.println("The minimum element is: " + ans );
    }
}