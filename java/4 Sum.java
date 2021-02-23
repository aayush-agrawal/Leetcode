class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();	
        Arrays.sort(nums);     
		
        for (int i = 0; i <= nums.length - 4; i++) {
            if(i>0&&nums[i]==nums[i-1])  continue; // skipping duplicates
			
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue; // skipping duplicates

                int val = target - (nums[i] + nums[j]);
 
                int start = j + 1, end = nums.length - 1;
 
                while (start < end) {
                    if (nums[start] + nums[end] < val) 
                        start++;
                    else if (nums[start] + nums[end] > val)
                        end--;                    
                    else {
                        result.add(List.of(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end&&nums[start]==nums[start+1])start++; // skipping duplicates
                        while(start<end&&nums[end]==nums[end-1])end--; // skipping duplicates
                        start++;
                        end--;
                    }
                }
            }
        }
    
        return result;
    }
}