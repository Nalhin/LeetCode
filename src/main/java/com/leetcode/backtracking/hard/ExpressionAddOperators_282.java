package com.leetcode.backtracking.hard;

//Given a string num that contains only digits and an integer target, return
//all possibilities to add the binary operators '+', '-', or '*' between the digits
//of num so that the resultant expression evaluates to the target value.
//
//
// Example 1:
// Input: num = "123", target = 6
//Output: ["1*2*3","1+2+3"]
// Example 2:
// Input: num = "232", target = 8
//Output: ["2*3+2","2+3*2"]
// Example 3:
// Input: num = "105", target = 5
//Output: ["1*0+5","10-5"]
// Example 4:
// Input: num = "00", target = 0
//Output: ["0*0","0+0","0-0"]
// Example 5:
// Input: num = "3456237490", target = 9191
//Output: []
//
//
// Constraints:
//
//
// 1 <= num.length <= 10
// num consists of only digits.
// -2³¹ <= target <= 2³¹ - 1
//
// Related Topics Math String Backtracking 👍 1959 👎 336


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

public class ExpressionAddOperators_282{
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        nextExpression(0, target, 0, num, new StringBuilder(), result);

        return result;
    }


    private void nextExpression(int start,
                                long target,
                                long chain,
                                String numStr,
                                StringBuilder prefix,
                                List<String> result){

        if(start >= numStr.length()) {
            if(target - chain == 0){
                result.add(prefix.toString());
            }
            return;
        }

        boolean isFirst = start == 0;

        int oldSize = prefix.length();
        int maxSubstringEnd = numStr.charAt(start) == '0' ? start + 1 : numStr.length();

        for(int end = start + 1; end <= maxSubstringEnd; end++){
            long num = Long.parseLong(numStr.substring(start, end));

            prefix.append(isFirst ? "" : '+').append(num);
            nextExpression(end, target - chain, num,  numStr, prefix, result);
            prefix.setLength(oldSize);

            if(!isFirst){
                prefix.append('*').append(num);
                nextExpression(end, target, chain * num, numStr, prefix, result);
                prefix.setLength(oldSize);

                prefix.append('-').append(num);
                nextExpression(end, target - chain, -num, numStr, prefix, result);
                prefix.setLength(oldSize);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
