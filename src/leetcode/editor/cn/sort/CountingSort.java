package leetcode.editor.cn.sort;

/**
 * 计数排序
 *
 * @author WuYetao
 * @date 2025/10/21 14:13
 */
public class CountingSort {

    public void sort(int[] nums){

        // 找到最大数
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        // 创建计数数组
        int[] count = new int[max + 1];

        // 遍历原数组，统计数组中每个数字出现的次数
        for (int j : nums) {
            count[j]++;
        }

        // 计算前缀和
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        // 遍历原数组，倒序赋值给临时数组
        int[] temp = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
            temp[count[num] - 1] = num;
            count[num]--;
        }

        // 赋值给原数组
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 8, 2, 1, 1, 1, 1};
        new CountingSort().sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}


