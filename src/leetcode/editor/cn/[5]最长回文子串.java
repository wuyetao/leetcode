//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7845 👎 0

  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

class LongestPalindromicSubstring_5{

  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring_5().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int start = 0;
        for(int L = 2; L <= s.length(); L++){
            for(int i = 0; i < s.length() ; i++){
                int j = i + L - 1;

                // 如果右边界越界，就可以退出当前循环 if (j >= len) { break; }
                if (j >= s.length()) {
                    break;
                }

                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if(dp[i][j] && L > maxLength){
                    maxLength = L;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}