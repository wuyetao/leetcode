//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3214 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class Permutations_46{

  public static void main(String[] args) {
       Solution solution = new Permutations_46().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
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

        for(int i = start; i < nums.length; i++){
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