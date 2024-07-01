package com.programers.java;

import java.util.Arrays;

public class OneQnAnswer {

    // 전의 요소와 지금의의 요소를 비교하여 만약 앞의 요소가 뒤의 요소의 접두사인지 확인
    public boolean Tsolution02(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        return true;
    }

    // 각각의 요소가 비교하는 글자로 시작하는지 확인한다. 즉, 루프를 두번 돌아 확인한다.
    // --> 시간 초과
    public boolean Tsolution01(String[] phone_book) {
        for(String s1 : phone_book) {
            for(String s2  : phone_book) {
                if(s1.equals(s2)) continue;
                if(s1.startsWith(s2)) return false;
            }
        }
        return true;
    }

    public boolean mySolution02(String[] phone_book) {
        Arrays.sort(phone_book);
        String prefix = phone_book[0];
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean mySolution01(String[] phone_book) {
        Arrays.sort(phone_book);
        String prefix = phone_book[0];
        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i].startsWith(prefix)) return false;
        }
        return true;
    }
}
