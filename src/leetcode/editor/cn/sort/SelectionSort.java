package leetcode.editor.cn.sort;

/**
 * 选择排序
 *
 * @author WuYetao
 * @date 2025/10/20 10:19
 */
public class SelectionSort {

    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,2,1};
        new SelectionSort().sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

}
