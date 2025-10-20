package leetcode.editor.cn.sort;

/**
 * 插入排序
 *
 * @author WuYetao
 * @date 2025/10/20 13:58
 */
public class InsertionSort {

    public void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int base = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > base){
                nums[j+1] = nums[j];
                j--;
            }
            // 将 base 赋值到正确位置
            nums[j + 1] = base;
        }
    }
}
