package com.programers.java;

import java.util.*;



public class ThreeQnAnswer {

    class Word {
        String word;
        int depth; // words의 index
        Word(String word, int depth) { this.word = word; this.depth = depth;}
    }

    public int Tsolution(String begin, String target, String[] words) {

        // target 이 words에 없는 경우
        if(!Arrays.asList(words).contains(target)) return 0;

        Set<String> used = new HashSet<String>();

        Stack<Word> stack = new Stack<>();
        stack.push(new Word(begin, 0));

        while(!stack.isEmpty()){
            Word now = stack.pop();
            // 만약 now가 target인 경우는 depth를 반환.
            if(now.word.equals(target)) return now.depth;

            // now 를 기준으로 바꿀 수 있는 단어를 stack을 넣는다. 그리고 answer는 +1이 된다.
            for (String w : words) {
                // 한글자 만 다른 단어가 아닌 경우는 거르기
                if(!changable(now.word, w)) continue;

                // 사용한 경우인 경우는 거르기
                if(used.contains(w)) continue;

                // 이제 stack에 push를 하였으므로 used에 contains
                used.add(w);

                // 바꿀 수 있는 단어만 stack 에 넣기
                stack.push(new Word(w, now.depth + 1));
            }
        }

        return 0;
    }
    // String 값을 비교하여 한글자만 같은지 확인한다.
    boolean changable(String w1, String w2){
        int len = Math.min(w1.length(), w2.length());
        int count = 0;
        for(int i = 0; i < len; i++){
            if(w1.charAt(i) != w2.charAt(i)) count++;
        }
        return count == 1;
    }
}
