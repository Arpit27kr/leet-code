class Solution {
   	public static int maximumUniqueSubarray(int[] nums) {

        // HashSet to check if the next value is unique.
		Set<Integer> set = new HashSet<>();
        
        // maxSum for the maximum score that we can get 
		int maxSum = 0;
        // currSum is used for the current sum of the iteration 
		int currSum = 0;

        // We have two pointer left and right 
        // r pointer will traverse the array and l will stay to indicate inital 
        // value for our current case 
		for (int l = 0, r = 0; r < nums.length; r++) {
            // let's add our next value 
			currSum += nums[r];
        // if the next element is already in the current set 
        // we need to move our l pointer 
    			if (set.contains(nums[r])) {
        // delete the values until we have found the non-unique value 
				while (nums[l] != nums[r]) {
					currSum -= nums[l];
					set.remove(nums[l]);
					l++;
				}
        // now we have found the non-unique value in our current case 
        // lets remove it both currSum and our set 
				if (nums[l] == nums[r]) {
					currSum -= nums[l];
					set.remove(nums[l]);
					l++;
				}
			}
        // add current value to the set 
			set.add(nums[r]);
        // compare the current case with previous cases to get maximum value .
			maxSum = Math.max(currSum, maxSum);

		}
		return maxSum;
	}
}