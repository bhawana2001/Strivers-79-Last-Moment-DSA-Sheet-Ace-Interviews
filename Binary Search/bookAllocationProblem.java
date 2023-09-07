// Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:
// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

//Problem Link: https://www.codingninjas.com/codestudio/problems/allocate-books_1090540?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;

public class bookAllocationProblem {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // if number of students is greater then number of books
        if (m > n)
            return -1;
        // maximum in array
        int low = maxInArray(arr);
        // sum of all elements
        int high = sum(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStu(arr, mid);
            if (students > m) {
                // right part
                low = mid + 1;
            } else {
                // left part
                high = mid - 1;
            }
        }
        return low;

    }

    public static int countStu(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    // find sum of all elements
    public static int sum(ArrayList<Integer> arr) {
        int sum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    // find maximum pages
    public static int maxInArray(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }

}