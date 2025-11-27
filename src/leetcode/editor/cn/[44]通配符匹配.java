//
// 给你一个输入字符串 (
// s) 和一个字符模式 (
// p) ，请你实现一个支持 
// '?' 和 
// '*' 匹配规则的通配符匹配：
// 
//
// 
// '?' 可以匹配任何单个字符。 
// '*' 可以匹配任意字符序列（包括空字符序列）。 
// 
//
// 
// 
// 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "aa", p = "*"
//输出：true
//解释：'*' 可以匹配任意字符串。
// 
//
// 示例 3： 
//
// 
//输入：s = "cb", p = "?a"
//输出：false
//解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, p.length <= 2000 
// s 仅由小写英文字母组成 
// p 仅由小写英文字母、'?' 或 '*' 组成 
// 
//
// Related Topics 贪心 递归 字符串 动态规划 👍 1238 👎 0

  
package leetcode.editor.cn;
class WildcardMatching_44{

  public static void main(String[] args) {
       Solution solution = new WildcardMatching_44().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int s_n = s.length();
        int p_n = p.length();
        boolean[][] dp = new boolean[s_n + 1][p_n + 1];

        dp[0][0] = true;

        // 解决开头如果连续*的问题
        for(int j = 1; j <= p_n; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];
            }else{
                break;
            }
        }

        for(int i = 1; i <= s_n; i++){
            for(int j = 1; j <= p_n; j++){
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                if(sChar == pChar || pChar == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pChar == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[s_n][p_n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}