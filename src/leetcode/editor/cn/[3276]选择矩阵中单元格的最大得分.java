//给你一个由正整数构成的二维矩阵 grid。 
//
// 你需要从矩阵中选择 一个或多个 单元格，选中的单元格应满足以下条件： 
//
// 
// 所选单元格中的任意两个单元格都不会处于矩阵的 同一行。 
// 所选单元格的值 互不相同。 
// 
//
// 你的得分为所选单元格值的总和。 
//
// 返回你能获得的 最大 得分。 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[1,2,3],[4,3,2],[1,1,1]] 
// 
//
// 输出： 8 
//
// 解释： 
//
// 
//
// 选择上图中用彩色标记的单元格，对应的值分别为 1、3 和 4 。 
//
// 示例 2： 
//
// 
// 输入： grid = [[8,7,6],[8,3,2]] 
// 
//
// 输出： 15 
//
// 解释： 
//
// 
//
// 选择上图中用彩色标记的单元格，对应的值分别为 7 和 8 。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 10 
// 1 <= grid[i][j] <= 100 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 矩阵 👍 19 👎 0

  
package leetcode.editor.cn;

import java.util.*;

class SelectCellsInGridWithMaximumScore_3276{

  public static void main(String[] args) {
       Solution solution = new SelectCellsInGridWithMaximumScore_3276().new Solution();
       int [][] grid = {
               {92,11,45,88,38,13,65,85},
      {52,83,3,14,82,51,27,59},
          {65,69,99,27,7,70,39,43},
              {43,46,22,19,75,70,57,50},
                  {54,36,91,80,74,43,62,61},
                      {35,45,19,32,92,50,93,88},
                          {60,15,93,10,89,32,51,11},
                              {82,66,42,61,78,94,66,7},
                                  {75,56,49,78,81,61,79,50}
      };

       // 数组转列表
       List<List<Integer>> list = new ArrayList<>();
       for (int i = 0; i < grid.length; i++) {
           List<Integer> list1 = new ArrayList<>();
           for (int j = 0; j < grid[i].length; j++) {
               list1.add(grid[i][j]);
           }
           list.add(list1);
       }
       System.out.println(solution.maxScore(list));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxScore(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty()) return 0;

        // 记录每个数字出现在哪些行（用二进制位掩码）
        Map<Integer, Integer> pos = new HashMap<>();
        int m = grid.size();
        for (int i = 0; i < m; i++) {
            for (int x : grid.get(i)) {
                // 合并行掩码：如果 x 出现在多行，用 OR 运算合并
                pos.merge(x, 1 << i, (a, b) -> a | b);
            }
        }

        // 只考虑在 grid 中的唯一数字
        List<Integer> allNums = new ArrayList<>(pos.keySet());
        int n = allNums.size();

        // memo[i][j] 表示前 i 个数字，行掩码为 j 时的最大和
        int[][] memo = new int[n][1 << m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示未计算
        }

        // 从最大的数字开始 DFS（贪心优化）
        allNums.sort(Collections.reverseOrder());

        return dfs(n - 1, 0, pos, allNums, memo);
    }

    private int dfs(int i, int j, Map<Integer, Integer> pos, List<Integer> allNums, int[][] memo) {
        if (i < 0) {
            return 0; // 没有数字可选，返回 0
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // 已计算过，直接返回
        }

        // 不选当前数字 x
        int res = dfs(i - 1, j, pos, allNums, memo);

        // 尝试选当前数字 x
        int x = allNums.get(i);
        int rowMask = pos.get(x); // x 出现的行掩码

        // 遍历所有 x 出现的行
        for (int t = rowMask, lb; t > 0; t ^= lb) {
            lb = t & -t; // 取出最低位的 1（即行号）
            if ((j & lb) == 0) { // 如果该行未被选中
                res = Math.max(res, dfs(i - 1, j | lb, pos, allNums, memo) + x);
            }
        }

        return memo[i][j] = res; // 记忆化
    }

}
//leetcode submit region end(Prohibit modification and deletion)

 
}
