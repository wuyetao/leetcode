//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 2080 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum_18{

public static void main(String[] args) {
    Solution solution = new FourSum_18().new Solution();
    System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for( int i = 0 ; i < nums.length - 3 ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1 ; j < nums.length - 2 ; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length - 1;
                while(left < right) {
                    // 注意长度
                    long sum = (long) nums[i] + (long) nums[j] + (long)nums[left] + (long)nums[right];
                    if(sum == (long) target) {
                        list.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }else if(sum < (long) target){
                        left++;
                        while(left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                    } else {
                        right--;
                        while(left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}