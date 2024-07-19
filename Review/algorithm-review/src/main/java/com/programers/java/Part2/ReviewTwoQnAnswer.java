package com.programers.java.Part2;

import java.util.*;

/* Part2. 문제 02 복습
문제 설명
길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 
아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.

제한사항
배열의 길이는 10만 이하입니다.
배열의 원소는 0 이상 10만 이하인 정수입니다.
* */
public class ReviewTwoQnAnswer {

    public boolean solution02(int[] arr) {

        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        int[] list = new int[arr.length];

        for(int i=0; i<arr.length; i++) list[i] = i+1;

        return Arrays.equals(sortedArray, list);
    }

    public boolean solution01(int[] arr) {
        boolean answer = true;

        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        List<Integer> list = new ArrayList<>();
        int before = 0;
        for(int i=0; i<sortedArray.length; i++) {
            if(before + 1 == sortedArray[i]) {
                list.add(sortedArray[i]);
                before = sortedArray[i];
            }
        }

        return arr.length == list.size();
    }
}
