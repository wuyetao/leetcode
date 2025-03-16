package array;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 中等
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Solution_189 {

    public void rotate(int[] nums, int k) {
        //  取余
        k = k % nums.length;
        //  重新排列
        int[] res = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            res[(i+k)% nums.length] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        Solution_189 s = new Solution_189();
        int[] a = new int[]{1,2,3,4,5,6,7};
        s.rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
