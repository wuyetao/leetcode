//给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。 
//
// 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处： 
//
// 
// 0 <= j <= nums[i] 且 
// i + j < n 
// 
//
// 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 n - 1 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2929 👎 0

  
package leetcode.editor.cn;
class JumpGameIi_45{

  public static void main(String[] args) {
       Solution solution = new JumpGameIi_45().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {

        // 次数
        int count = 0;
        // 当前位置能跳到最远位置
        int currentEnd = 0;
        // 能到达的最远位置
        int farthest = 0;
        for(int i = 0; i < nums.length -1; i++){
            // 更新
            farthest = Math.max(farthest , i + nums[i]);

            // 是否到达最远位置
            if(i == currentEnd){
                count++;
                currentEnd = farthest;

                if(currentEnd >= nums.length -1){
                    break;
                }
            }
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

 
}