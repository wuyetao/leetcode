package leetcode.editor.cn.sort;

/**
 * 归并排序，二叉树后序遍历
 *
 * @author WuYetao
 * @date 2025/10/21 10:08
 */
public class MergeSort {

    public  void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        // 构建临时数组
        int[] temp = new int[right - left + 1];

        // 遍历排序
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        // 处理剩余元素
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }

        // 拷贝回原数组
        for(int l = 0; l < temp.length; l++){
            nums[left+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,2,1, 1, 1, 1};
        new MergeSort().sort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
