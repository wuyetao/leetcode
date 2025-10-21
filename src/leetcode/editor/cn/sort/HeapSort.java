package leetcode.editor.cn.sort;

/**
 * 堆排序 O(n)+O(nlogn)=O(nlogn)
 *
 * @author WuYetao
 * @date 2025/10/21 10:26
 */
public class HeapSort {

    public void sort(int[] nums){

        // 构建堆, 最后一个非叶子节点的索引就是n/2 - 1，自下往上堆化, 时间复杂度O(n)
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            heapify(nums, i, nums.length);
        }

        // 堆排序
        for(int i = nums.length - 1; i > 0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // 每次 Heapify 操作最多需要从根节点向下遍历到叶子节点，因此最多需要h 次比较和交换（h 是堆的高度）, 时间复杂度 O(logn)
            heapify(nums, 0, i);
        }
    }

    public void heapify(int[] nums, int i, int length){
        // 左子节点：2 * i + 1
        int left = 2 * i + 1;
        // 右子节点：2 * i + 2
        int right = 2 * i + 2;
        int largest = i;
        if(left < length && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < length && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, largest, length);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,2,1, 1, 1, 1};
        new HeapSort().sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
