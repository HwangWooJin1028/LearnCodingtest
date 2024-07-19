package com.programers.java.Part2;

import java.util.ArrayList;
import java.util.List;

/* Part2. 문제 01 복습
주어진 입력중 최대값을 구하고, 최대값이 이 위치하는 index 값의 목록을 반환하세요.

입력:
[1, 3, 5, 4, 5, 2, 1]

입력된 목록의 최대값은 5입니다.
5와 동일한 값을 가진 위치는 3번째, 5번째 위치 입니다.
이 위치에 해당하는 index는 [2, 4] 입니다.

출력:
[2, 4]
* */
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
