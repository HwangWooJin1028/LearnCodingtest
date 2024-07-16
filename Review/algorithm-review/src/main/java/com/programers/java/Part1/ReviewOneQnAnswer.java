package com.programers.java.Part1;

import java.util.ArrayList;
import java.util.List;

public class ReviewOneQnAnswer {
    public int[] solution(int[] arr) {
        List<Integer> indexList = new ArrayList<>();
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            if(max == arr[i]) indexList.add(i);
            if(max < arr[i]) {
                indexList.clear();
                indexList.add(i);
                max = arr[i];
            }
        }

        return indexList.stream().mapToInt(Integer::intValue).toArray();
    }
}
