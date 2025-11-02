//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1：87/7*/
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
//解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1766 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

class ThreeSumClosest_16{

public static void main(String[] args) {
Solution solution = new ThreeSumClosest_16().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetNumber = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素（可选优化）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closetNumber - target)) {
                    closetNumber = sum;
                }

                if (sum > target) {
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else {
                    left++;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }

        }
        return closetNumber;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}