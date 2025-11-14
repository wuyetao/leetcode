//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], 
//nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1
//,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 3276 👎 0

  
package leetcode.editor.cn;
class SearchInRotatedSortedArray_33{

  public static void main(String[] args) {
       Solution solution = new SearchInRotatedSortedArray_33().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    public int binarySearchRecursive(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;  // 基线条件：搜索区间为空
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }


        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return binarySearchRecursive(nums, target, left, mid - 1);  // 右半部分
            }else{
                return binarySearchRecursive(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return binarySearchRecursive(nums, target, mid + 1, right);  // 左半部分
            }else{
                return binarySearchRecursive(nums, target, left, mid - 1);
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}