class Solution {
    public int[] getConcatenation(int[] nums) {
        
            int n=nums.length;
        
        int ans[]=new int[2*n];
        
       int j=0;
        for(int i=0;i<2*n;i++)
        {
            if(j==n)
            {
                j=0;
            }
            
            ans[i]=nums[j];
            j++;
        }
        return ans;
        
    }
}