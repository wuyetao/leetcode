package leetcode.editor.cn.sort;

/**
 * 冒泡排序
 *
 * @author WuYetao
 * @date 2025/10/20 13:49
 */
public class BubbleSort {

    public void sort(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,2,1};
        new BubbleSort().sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
