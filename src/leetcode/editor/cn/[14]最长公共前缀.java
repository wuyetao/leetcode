//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics 字典树 数组 字符串 👍 3413 👎 0

  
package leetcode.editor.cn;
class LongestCommonPrefix_14{

  public static void main(String[] args) {
       Solution solution = new LongestCommonPrefix_14().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for(int i = 1; i < count; i++){
            prefix = commonPrefix(prefix, strs[i]);
            if(prefix.isEmpty()){
                break;
            }
        }
        return prefix;
    }

    // 比较两个字符串的公共前缀长度
    private String commonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}