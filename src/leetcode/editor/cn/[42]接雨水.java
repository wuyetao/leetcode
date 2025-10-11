//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5800 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class TrappingRainWater_42{

public static void main(String[] args) {
Solution solution = new TrappingRainWater_42().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 动态规划计算 左右两侧的最大高度
//        int n = height.length;
//        int[] leftMax = new int[n];
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//        int[] rightMax = new int[n];
//        rightMax[n - 1] = height[n - 1];
//        for(int i = n - 2; i >= 0; i--){
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//        int res = 0;
//        for(int i = 1; i < n - 1; i++){
//            // 雨水高度为左右两侧最小高度减去当前高度, leftMax[i], rightMax[i]必然大于等于height[i]
//            res += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return res;

        // 单调栈
//        int n = height.length;
//        int res = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        for(int i = 0; i < n; i++){
//            while (! stack.isEmpty() && height[stack.peek()] < height[i]) {
//                int top = stack.pop();
//                if (stack.isEmpty()) {
//                    break;
//                }
//                int left = stack.peek();
//                int curWidth = i - left - 1;
//                int curHeight = Math.min(height[left], height[i]) - height[top];
//                res += curWidth * curHeight;
//            }
//            stack.push(i);
//        }
//        return res;

        // 双指针
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}