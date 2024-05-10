package com.aqiu._2_Stack;

import java.util.Deque;
import java.util.LinkedList;

public class _8_P150_EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new _8_P150_EvaluateReversePolishNotation().new Solution();
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            int n = tokens.length;
            Integer s1,s2;
            for (int i = 0; i < n; i++) {
                if(!isNumber(tokens[i])){
                    switch (tokens[i]){
                        case "+":
                            s1 = stack.pop();
                            s2 = stack.pop();
                            stack.push(s1 + s2);
                            break;

                        case "-":
                            s1 = stack.pop();
                            s2 = stack.pop();
                            stack.push(s2 - s1);
                            break;

                        case "*":
                            s1 = stack.pop();
                            s2 = stack.pop();
                            stack.push(s1 * s2);
                            break;

                        case "/":
                            s1 = stack.pop();
                            s2 = stack.pop();
                            stack.push(s2 / s1);
                            break;
                    }
                }else{
                    stack.push(Integer.valueOf(tokens[i]));
                }
            }
            return stack.pop();
        }

        private boolean isNumber(String token){
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }
    }
}