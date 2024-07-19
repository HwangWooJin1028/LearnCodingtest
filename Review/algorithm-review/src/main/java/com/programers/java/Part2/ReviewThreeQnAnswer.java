package com.programers.java.Part2;

import java.util.ArrayList;
import java.util.List;

/* Part2. 문제 03 복습
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
123456789101112
n은 10,000,000,000이하인 자연수입니다.
* */
public class ReviewThreeQnAnswer {

    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while(n != 0) {
            // 1. n에서 뒤에서부터 숫자를 가져오기
            list.add((int)(n % 10));

            // 2. 나머지 숫자를 n으로
            n = (int)(n / 10);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
