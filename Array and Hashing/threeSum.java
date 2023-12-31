//Problem Link: https://www.codingninjas.com/codestudio/problems/three-sum_6922132?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;
public class threeSum {
    public static List< List < Integer > > triplet(int n, int []nums) {
        // Write your code here.
         //sort the array
        Arrays.sort(nums);
        //make a list 
        List<List<Integer>> res=new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low=i+1,high=nums.length-1,sum=0-nums[i];
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<sum) low++;
                    else high--;
                }
            }
        }
        return res;
    }
}
