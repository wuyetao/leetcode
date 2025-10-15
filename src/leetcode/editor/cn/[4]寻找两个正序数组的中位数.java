//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7720 👎 0

  
package leetcode.editor.cn;
class MedianOfTwoSortedArrays_4{

  public static void main(String[] args) {
       Solution solution = new MedianOfTwoSortedArrays_4().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 归并
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int len = n1 + n2;
//        int[] nums = new int[len];
//        int i = 0, j = 0;
//        while (i < n1 && j < n2) {
//            if(nums1[i] < nums2[j]){
//                nums[i + j] = nums1[i++];
//            }else {
//                nums[i + j] = nums2[j++];
//            }
//        }
//        while (i < n1){
//            nums[i + j] = nums1[i++];
//        }
//        while (j < n2){
//            nums[i + j] = nums2[j++];
//        }
//        if(len % 2 == 0){
//            return (nums[len / 2] + nums[len / 2 - 1] ) / 2.0;
//        }else{
//            return nums[len / 2];
//        }

        // 双指针
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int len = n1 + n2;
//        int left = 0, right = 0;
//        int aRight = 0, bRight = 0;
//        for(int i = 0; i <= len / 2; i++){
//            left = right;
//            if(aRight < n1 && (bRight >= n2 || nums1[aRight] < nums2[bRight])){
//                right = nums1[aRight++];
//            }else{
//                right = nums2[bRight++];
//            }
//        }
//        if(len % 2 == 0){
//            return (left + right) / 2.0;
//        }else{
//            return right;
//        }

        // 分治
        int n1 = nums1.length;
        int n2 = nums2.length;
        int len = n1 + n2;
        if((len & 1) == 0){
            return (getKthElement(nums1, nums2, len / 2  + 1) + getKthElement(nums1, nums2, len / 2 ) ) / 2.0;
        }else{
            return getKthElement(nums1, nums2, len / 2 + 1);
        }

    }
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int index1 = 0, index2 = 0;

        while(true){
            if(index1 == n1){
                return nums2[index2 + k - 1];
            }
            if(index2 == n2){
                return nums1[index1 + k - 1];
            }
            if (k == 1) { return Math.min(nums1[index1], nums2[index2]); }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, n1) - 1;
            int newIndex2 = Math.min(index2 + half, n2) - 1;
            if(nums1[newIndex1] <= nums2[newIndex2]){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }



}
//leetcode submit region end(Prohibit modification and deletion)

 
}