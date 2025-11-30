//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1752 👎 0

  
package leetcode.editor.cn;

import java.util.*;

class PermutationsIi_47{

  public static void main(String[] args) {
       Solution solution = new PermutationsIi_47().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> result){

        // 返回条件
        if(start == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int num: nums){
                current.add(num);
            }
            result.add(current);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for(int i = start; i < nums.length; i++){

            if(used.contains(nums[i])){
                continue;
            }

            used.add(nums[i]);

            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i);
        }

    }

    public void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}