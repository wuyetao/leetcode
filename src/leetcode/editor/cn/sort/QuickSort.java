package leetcode.editor.cn.sort;

/**
 * 快速排序
 *
 * @author WuYetao
 * @date 2025/10/20 16:36
 */
public class QuickSort {

    public void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right){
        int pivot = left;
        while(left < right){
            while(left < right && nums[right] >= nums[pivot]){
                right--;
            }
            while(left < right && nums[left] <= nums[pivot]){
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, pivot);
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,2,1, 1, 1, 1};
        new QuickSort().sort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
