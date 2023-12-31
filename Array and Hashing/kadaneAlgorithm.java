//Problem link : https://bit.ly/3HZltTa

public class kadaneAlgorithm {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
        if(n==0) return 0;
        if(arr==null) return 0;
        long meh=0;
        //maximum sum so far
        long msf=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            meh=meh+arr[i];
            if(meh<arr[i])
                meh=arr[i];
            if(meh>msf)
                msf=meh;
            // if maximum sum so far becomes negative at 
            // any point we just initialize it as zero
            if(msf<0)
                msf=0;
        }
        //return maximum sum
        return msf;
	}

}
