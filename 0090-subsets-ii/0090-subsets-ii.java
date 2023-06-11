class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, result, 0, new ArrayList<>());    
        return result;
    }
    
    void backtrack(int[] nums, List<List<Integer>> result, int index, List<Integer> current_list) {
        result.add(new ArrayList<>(current_list));
              
        for(int i=index;i<nums.length;i++) {
            if(i!=index && nums[i]==nums[i-1]) continue;
            current_list.add(nums[i]);
            backtrack(nums, result, i+1, current_list);
            current_list.remove(current_list.size()-1);
        }
    }
}