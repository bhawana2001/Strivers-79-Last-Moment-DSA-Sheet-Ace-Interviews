//Problem link : https://www.codingninjas.com/codestudio/problems/majority-element_6915220?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;
public class majorityElement {
    public static List< Integer > majorityElement(int []v) {
         int n = v.length; //size of the array

        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE; 
        int element2 = Integer.MIN_VALUE; 

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != v[i]) {
                count1 = 1;
                element1 = v[i];
            } else if (count2 == 0 && element1 != v[i]) {
                count2 = 1;
                element2 = v[i];
            } else if (v[i] == element1){
                count1++;
            } 
            else if (v[i] == element2){
                count2++;
            } 
            else {
                count1--; 
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == element1) count1++;
            if (v[i] == element2) count2++;
        }

        int mini = (int)(n / 3) + 1;
        if (count1 >= mini) result.add(element1);
        if (count2 >= mini) result.add(element2);

        Collections.sort(result); 

        return result;

    }
}

