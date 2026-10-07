class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Key: The number itself, Value: Its original index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the number we need has already been seen
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Otherwise, remember this number and its index for later
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
}