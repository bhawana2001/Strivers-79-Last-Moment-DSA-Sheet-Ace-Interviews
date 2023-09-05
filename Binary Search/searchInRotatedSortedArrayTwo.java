// Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and
//  a target value k. Now the array is rotated at some pivot point unknown to you. 
// Return True if k is present and otherwise, return False. 

//Problem Link: https://www.codingninjas.com/codestudio/problems/search-in-a-rotated-sorted-array-ii_7449547?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class searchInRotatedSortedArrayTwo {
    public static boolean searchInARotatedSortedArrayII(int[] A, int key) {
        // We will be using binary search
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if mid element is key
            // that means we found the element
            if (A[mid] == key) {
                return true;
            }
            // if elements are duplicated
            if (A[low] == A[mid] && A[mid] == A[high]) {
                low++;
                high--;
                continue;
            }
            // find range in which key element is present
            if (A[low] <= A[mid]) {
                // if element is present in first half
                // make high as mid-1, we shrink the array
                if (A[low] <= key && key <= A[mid]) {
                    high = mid - 1;
                }
                // if element is present in second half
                // make low as mid+1, we shrink the array
                else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] <= key && key <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        boolean ans = searchInARotatedSortedArrayII(arr, k);
        if (ans == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}