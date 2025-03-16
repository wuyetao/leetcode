package array;

/**
 * 665. 非递减数列
 *
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */

class Solution_665 {
    public boolean checkPossibility(int[] nums) {

        if(nums.length == 1){
            return true;
        }

        for(int i=1; i<nums.length;i++){
            int x = nums[i], y = nums[i-1];
            if(nums[i] < nums[i-1]){
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = x;
                nums[i-1] = x;
                return isSorted(nums);
            }

        }
        return true;
    }

    private boolean isSorted(int[] nums){
        for(int i=1; i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }

        return true;
    }
}