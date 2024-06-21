package com.programers.java;
import java.util.*;

public class OneQnAnswer {
    
    // Set 사용
    public boolean Tsolution02(int[] lotto) {
        Set<Integer> set = new HashSet<>();

        for(int l : lotto) {
            if(l > 45 || l < 1) return false;
            set.add(l);
        }
        
        // set의 size는 중복이 없다면 lotto의 length와 같을 것이다.
        return set.size() == lotto.length;
    }
    
    // Set 미사용
    public boolean Tsolution01(int[] lotto) {
        boolean[] checker = new boolean[45+1];

        for(int l : lotto) {
            if(l > 45 || l < 1) return false;
            // 만약 중복된 값이 들어가면 false를 반환한다.
            if(checker[l]) return false;
            checker[l] = true;
        }

        return true;
    }

    public boolean mySolution(int[] lotto) {
        Set<Integer> set = new HashSet<>();

        for(int l : lotto) {
            if(l > 45 || l < 1) return false;
            set.add(l);
        }

        return (set.size() == 6);
    }
}
