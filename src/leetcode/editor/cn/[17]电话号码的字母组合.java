//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 3142 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfAPhoneNumber_17{

  public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), res, map);
        return res;

    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> res, Map<Character, String> map){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); i++){
            StringBuilder newPath = new StringBuilder(path);
            backtrack(digits, index + 1, newPath.append(letters.charAt(i)), res, map);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

 
}