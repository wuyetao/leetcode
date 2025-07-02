leetcode plugin 设置
Code FileName: [${question.frontendQuestionId}]${question.title}

Code Template: 
${question.content}

package leetcode.editor.cn;
class $!velocityTool.camelCaseName(${question.titleSlug})_${question.frontendQuestionId}{

public static void main(String[] args) {
Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})_${question.frontendQuestionId}().new Solution();
}

${question.code}

}