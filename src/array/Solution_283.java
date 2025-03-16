package array;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 也可以用快慢指针
 */
public class Solution_283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){

            // 如果数字不为0，移动数字到
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i=j;i<nums.length;i++){
            nums[i] = 0;
        }

    }

}
