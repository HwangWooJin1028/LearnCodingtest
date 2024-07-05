package com.programers.java;
import java.util.*;
public class ThreeQnAnswer {

    public String mySlution05(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        char before = ' ';
        for(char c : s.toCharArray()) {
            if(before == ' ') c = Character.toUpperCase(c);
            sb.append(c);
            before = c;
        }
        return sb.toString();
    }

    public String mySlution04(String s) {
        String[] words = s.split(" ");
        List<String> answer = new LinkedList<>();

        for(String word : words) {
            word = word.toLowerCase();
            // 공백 문자일 경우
            if(word.equals("")) {
                answer.add("");
                continue;
            }
            char c = word.charAt(0);
            // answer에 pasing이 완료된 것을 return
            answer.add(Character.toString(c).toUpperCase()
                    + word.substring(1));
        }
        return String.join(" ", answer.toArray(new String[answer.size()]));
    }

    public String mySolution03(String s) {
        String[] words = s.split(" ");
        String[] answer = new String[words.length];
        int answerIdx=0;

        for(String word : words) {
            word = word.toLowerCase();

            if(word.equals("")) {
                answer[answerIdx] = "";
                answerIdx++;
                continue;
            }
            char c = word.charAt(0);

            answer[answerIdx]= Character.toString(c).toUpperCase()
                    + word.substring(1);
            answerIdx++;
        }
        return String.join(" ", answer);
    }

    public String mySolution02(String s) {
        String[] words = s.split(" ");
        String[] answer = new String[words.length];
        int answerIdx=0;

        for(String word : words) {
            word = word.toLowerCase();
            // 공백 문자일 경우
            if(word.equals("")) {
                answer[answerIdx] = "";
                answerIdx++;
                continue;
            }
            char c = word.charAt(0);
            // answer에 pasing이 완료된 것을 return
            answer[answerIdx]= Character.toString(c).toUpperCase()
                    + word.substring(1);
            answerIdx++;
        }
        return String.join(" ", answer);
    }

    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        for(String word : words) {
            char c = word.charAt(0);
            answer += Character.toString(c).toUpperCase() + word.substring(1) + " ";
        }
        return answer;
    }
}
