class Solution {    
    public int[] runningSum(int[] nums) 
    {
        
        	        int temp=0;
	        int sum[] = new int[nums.length];
	        for (int i = 0; i < nums.length; i++) 
	        {
	        	
	        	temp=temp+nums[i];
	            sum[i] =temp;
	           
	        	
	        }  
        return sum;
        
    }
}