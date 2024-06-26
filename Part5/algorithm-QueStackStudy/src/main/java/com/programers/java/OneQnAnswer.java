package com.programers.java;

import java.util.Stack;

/* Part 05. 문제 01
괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.

예를 들어,
"()()" 또는 "(())()" 는 올바른 괄호입니다.
")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.

'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

제한사항
문자열 s의 길이 : 100,000 이하의 자연수
문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
*/
public class OneQnAnswer {

    boolean Tsolution02(String s) {
        int stack = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') stack++;
            if(c == ')') {
                if(stack == 0) return false;
                stack--;
            }
        }
        return stack == 0;
    }

    boolean Tsolution01(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            if(c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 괄호가 false 가 되는 상황
    // 1. 첫번째가 ) 일 경우
    // 2. 마지막 괄호가 ( 일 경우
    // 3. (와 ) 의 개수가 맞지 않는 경우
    boolean mySolution01(String s) {
        if(Character.toString(s.charAt(0)).equals(")") || Character.toString(s.charAt(s.length()-1)).equals("(")) return false;
        char[] chArray = s.toCharArray();
        int left = 0;
        int right = 0;

        for(char ch : chArray) {
            if(Character.toString(ch).equals(")")) right++;
            if(Character.toString(ch).equals("(")) left++;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return (chArray.length % 2 == 0 && right == left);
    }
}
