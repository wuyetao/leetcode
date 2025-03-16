package array;

import java.util.Arrays;


/**
 * 453. 最小操作次数使数组元素相等
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/description/
 *
 * 利用减法
 */
class Solution_453 {
    public int minMoves(int[] nums) {

        Arrays.sort(nums);
        int num = 0;
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            num += nums[i]-min;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution_453 s = new Solution_453();
        System.out.println(s.minMoves(new int[]{1,1000000000}));
    }
}

