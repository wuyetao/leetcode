package leetcode.editor.cn.sort;

/**
 * 基数排序, 依赖计数排序
 *
 * @author WuYetao
 * @date 2025/10/21 14:48
 */
public class RadixSort {

    public void sort(int[] nums){

        // 找到最大的数
        int max =  Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        for(int exp = 1; max / exp > 0; exp *= 10){
            countSort(nums, exp);
        }
    }

    public void countSort(int[] nums, int exp){

        int[] count = new int[10];

        for(int num: nums){
            count[(num / exp) % 10]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        int[] temp = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
            int d = (num / exp) % 10;
            int index = count[d] - 1;
            temp[index] = num;
            count[d]--;
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {51, 52, 84, 77, 12, 13, 17, 15};
        new RadixSort().sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
