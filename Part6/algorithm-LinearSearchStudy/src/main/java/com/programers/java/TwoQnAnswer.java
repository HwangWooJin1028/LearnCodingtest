package com.programers.java;

public class TwoQnAnswer {

    boolean Tsolution02(String s) {
        // 조건은 정규 표현식
        // P 또는 p가 아닌 글자를 삭제
        int p  = s.replaceAll("[^pP]","").length();
        int y  = s.replaceAll("[^yY]","").length();
        return p == y;
    }
    
    boolean Tsolution01(String s) {
        String content = s.toLowerCase();
        int p  = 0; int y = 0;

        for(char c : content.toCharArray()) if(c == 'p') p++;
        for(char c : content.toCharArray()) if(c == 'y') p--;

        return p == 0;
    }

    boolean mySolution(String s) {
        String content = s.toUpperCase();
        int p  = 0; int y = 0;

        for(int i=0; i<content.length(); i++) {
            String str = Character.toString(content.charAt(i));
            if(str.equals("P")) p++;
            if(str.equals("Y")) y++;
        }

        return p == y;
    }
}
