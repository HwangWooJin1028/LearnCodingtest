package com.programers.java;

// import java.util.* 를 하여 util 전체를 import한다.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TwoQnAnswer {

    // 방법02. Arrays.equals() 사용
    // 정답과 비교하는 방식이다.
    // 시간복잡도: O(2*n+nlogn) --> O(nlogn) (큰값만..)
    public boolean Tsoultion02(int[] arr) {
        int[] answer = new int[arr.length];

        // 시간복잡도 : O(n)
        for(int i = 0; i < arr.length; i++) {
            answer[i] = i+1;
        }

        Arrays.sort(arr); // O(nlogn)

        return Arrays.equals(answer, arr); // O(n)
    }

    // 방법01. 맞는 방식이지만 시간초과가 된다.
    // O(n^2) --> 너무 오래걸림
    public boolean Tsoultion01(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int found = 0;
            for(int a: arr) {
                if(a == i) found++;
            }

            if(found != 1) return false;
        }

        return true;
    }

    public boolean mySolution01(int[] arr) {
        boolean answer = true;
        // 1. arr의 길이를 확인하고 그에 따라 리스트 만들기
        List<Integer> numList = new Vector<Integer>();
        List<Boolean> boolList = new Vector<Boolean>();

        for(int i=0; i<arr.length; i++) {
            numList.add(i+1);
        }

        // 2. arr에 숫자가 잘 들어가있는지 확인하기
        // --> 이를 Arrays.equals()로 축약 가능
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<numList.size(); j++) {
                if(numList.get(j) == arr[i]) {
                    boolList.add(true);
                }
            }
        }

        // 3. 결과 확인
        if(boolList.size() != numList.size()) {
            answer = false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}