//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3140 👎 0

  
package leetcode.editor.cn;
class FindFirstAndLastPositionOfElementInSortedArray_34{

  public static void main(String[] args) {
       Solution solution = new FindFirstAndLastPositionOfElementInSortedArray_34().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int curr = binarySearch(nums, target, 0, nums.length - 1);
        if (curr == -1) {
            return new int[]{-1, -1};
        }else {
            int left = curr;
            int right = curr;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            return new int[]{left + 1, right - 1};
        }

    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}