// Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its neighbors. 
// Formally, if ‘arr[i]’ is the peak element, ‘arr[i – 1]’ < ‘arr[i]’ and ‘arr[i + 1]’ < ‘arr[i]’. Find the index(0-based) of
// a peak element in the array. If there are multiple peak numbers, return the index of any peak number.

// Note: For the first element, the previous element should be considered as negative infinity as well as for the last element,
// the next element should be considered as negative infinity.

//Problem Link: https://www.codingninjas.com/codestudio/problems/find-peak-element_1081482?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;

public class findPeakElementInArray {
    public static int findPeakElement(ArrayList<Integer> arr) {
        // length of list
        int n = arr.size();
        if (n == 0){                    // if length is 0 => no peak element
            return 0;       
        }
        if (arr.get(0) > arr.get(1)) {  // check for first and last elements because
            return 0;                   // it can be possible that we have those elements
        }                               // as peak element => no further calls are needed
        if (arr.get(n-1) > arr.get(n-2)) {
            return n - 1;
        }
        int low=1;                      //we handled both 0 and n-1 cases above
        int high=n-2; 
        while(low<=high){
        int mid=(low+high)/2;
        if(arr.get(mid-1)<arr.get(mid) && arr.get(mid)>arr.get(mid+1)){
            return mid;                 //if mid is greater then both => mid is peak element
        }
        if(arr.get(mid)>arr.get(mid-1)){
            low=mid+1;                  //increasing seq. => peak is in right part
        }else{
            high=mid-1;                 //decreasing seq. => peak is in left part
        }   
        }   
        return -1;      //not found
    }
     public static void main(String[] args) {
        ArrayList<Integer> arr =
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1));
        int ans = findPeakElement(arr);
        System.out.println("The peak is at index: " + ans);
    }
};
