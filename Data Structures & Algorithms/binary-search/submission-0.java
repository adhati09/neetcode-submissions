class Solution {
    public int search(int[] nums, int target) {
        boolean flag = false;
        for(int i = 0; i < nums.length && !flag; i++){
            if(nums[i] == target){
                flag = true;
                return i;
            }
        }

        return -1;
    }
}
