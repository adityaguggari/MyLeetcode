class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> result, int index) {
        if(index==nums.length) {
            List<Integer> current_list=new ArrayList<>();
            for(int i=0;i<nums.length;i++) {
                current_list.add(nums[i]);
            }
            result.add(new ArrayList<>(current_list));
        }

        for(int i=index;i<nums.length;i++) {
            swap(nums, index, i);
            backtrack(nums, result, index+1);
            swap(nums, index, i);
        }
    }

    void swap(int[] nums, int start, int end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
    }
}