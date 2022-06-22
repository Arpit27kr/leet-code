class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        
        int sum=n*(n+1)/2;
        int i=0,sumarr=0;
        
        while(i<n){
            sumarr+= nums[i];
            i++;
        }
        return (sum-sumarr);
        
    }
}
