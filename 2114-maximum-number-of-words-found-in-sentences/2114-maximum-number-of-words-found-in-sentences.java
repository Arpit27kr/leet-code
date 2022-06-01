class Solution {
    public int mostWordsFound(String[] sentences) {
      
      int max=0;
        for(String val:sentences)
        {
            max=Math.max(max,val.split(" ").length);
        }
        return max;
        
        
       
        
    }
}