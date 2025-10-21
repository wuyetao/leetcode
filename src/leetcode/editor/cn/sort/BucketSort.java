package leetcode.editor.cn.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *
 * @author WuYetao
 * @date 2025/10/21 13:40
 */
public class BucketSort {

    public void sort(float[] nums){
        int n = nums.length;
        List<List<Float>> buckets = new ArrayList<>();
        for(int i = 0; i < n; i++){
            buckets.add(new ArrayList<>());
        }

        // 将数组元素放入桶中
        for(float num : nums){
            int index = (int) (num * n);
            buckets.get(index).add(num);
        }

        // 对每个桶进行排序
        for(List<Float> bucket : buckets){
            Collections.sort(bucket);
        }

        // 输出排序后的结果
        int index = 0;
        for(List<Float> bucket : buckets){
            for(float num : bucket){
                nums[index++] = num;
            }
        }
    }
}
