//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1692 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIi_40{

public static void main(String[] args) {
Solution solution = new CombinationSumIi_40().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res ;
    }

    public void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result){
        if(remain < 0){
            return;
        }
        if(remain == 0){
            result.add(new ArrayList<>(current));
        }

        for(int i = start; i < candidates.length; i++){

            // 关键剪枝：跳过重复元素，避免重复组合
            // 跳过的原因：在同一层递归中，如果前一个相同的数字已经尝试过所有组合，当前数字会产生重复组合
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 剪枝：如果当前数字已经大于剩余值，后面的更大，直接跳出
            if (candidates[i] > remain) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}