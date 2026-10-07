class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=nums.length-1;
        Pair[] pairs = new Pair[nums.length];
        for(int k=0; k<nums.length; k++){
            pairs[k] = new Pair(nums[k], k);
        }
        Arrays.sort(pairs, (p1, p2)->p1.element - p2.element);
        while(i<=j){
            if(target == pairs[i].element + pairs[j].element){
                return new int[]{Math.min(pairs[i].idx, pairs[j].idx), Math.max(pairs[i].idx, pairs[j].idx)};
            }else if(target < pairs[i].element + pairs[j].element)
                j--;
            else 
                i++;
        }
        return new int[]{};
    }
    class Pair{
        int element;
        int idx;
        Pair(int element, int idx){
            this.element = element;
            this.idx = idx;
        }
    }
}
