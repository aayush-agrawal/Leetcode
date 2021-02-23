class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        int current_sum = 0;
        for(int i=0; i<nums.length; i++) {
            current_sum += nums[i];
            if(map.containsKey(current_sum - k))
                result += map.get(current_sum - k);

            int count = map.getOrDefault(current_sum, 0);
            map.put(current_sum, count+1);
        }
        return result; 
    }
}