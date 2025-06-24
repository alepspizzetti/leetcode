class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum_result = {};
        for (int first_index = 0; first_index <= nums.length -1; first_index++) {
            for (int second_index = first_index +1; second_index <= nums.length -1; second_index++) {
                int f_num = nums[first_index];
                int s_num = nums[second_index];

                if (f_num + s_num == target) {
                    sum_result = new int[]{first_index, second_index};
                    return sum_result;
                }
            }
        }
        return sum_result;
    }
}