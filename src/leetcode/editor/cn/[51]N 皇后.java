//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2377 👎 0

  
package leetcode.editor.cn;

import java.util.*;

class NQueens_51{

  public static void main(String[] args) {
       Solution solution = new NQueens_51().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        backtrack(result, queens, n, 0, columns, diagonals1, diagonals2);

        return result;


    }

    public void backtrack(List<List<String>> result, int[] queens, int n,
                          int row, Set<Integer> columns,
                          Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row == n){
            result.add(generateBoard(queens));
            return;
        }

        for(int col = 0; col < n; col++){
            // 计算对角线
            int diagonal1 = row - col;
            int diagonal2 = row + col;

            if(columns.contains(col) || diagonals1.contains(diagonal1) || diagonals2.contains(diagonal2)){
                continue;
            }

            // 记录
            columns.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            queens[row] = col;

            // 递归
            backtrack(result, queens, n, row + 1, columns, diagonals1, diagonals2);

            columns.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
            queens[row] = -1;

        }

    }

    public List<String> generateBoard(int[] queens){

        List<String> board = new ArrayList<>();

        for(int i = 0; i < queens.length; i++){
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}