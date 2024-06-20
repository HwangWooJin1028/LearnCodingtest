package com.programers.java;
import java.util.*;

public class ThreeQnAnswer {
    public int Tsolution(String[][] clothes) {
        // 위장용품의 종류별 개수
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes) {
            if(map.containsKey(c[1])) {
                map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            }
        }

        // 각 개수의 +1을 모두 곱한다.
        // 경우의 수는 각 종류별 있는 옷들을 하나씩 입거나, 아니면 아애 안입거나..
        int answer = 1;
        Iterator<Integer> iter = map.values().iterator();
        while(iter.hasNext()) {
            answer *= iter.next()+1;
        }

        // 모두 안입는 경우는 제외한다.
        // 그러므로 -1 해서 return

        return answer-1;
    }

    public int mySolution(String[][] clothes) {
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            if(map.get(clothes[i][0]) == null) {
                map.put(clothes[i][0], clothes[i][1]);
            }
        }

        Collection<String> typeValue = map.values();
        int size = 0;
        for(String type : typeValue) {
            for(int i=0; i<clothes.length; i++) {
                if(!type.equals(clothes[i][1])) {
                    size++;
                }
            }
        }
        return map.size() + (size/2);
    }
}
