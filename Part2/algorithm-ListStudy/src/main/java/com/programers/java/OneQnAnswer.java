package com.programers.java;

// import java.util.* 를 하여 util 전체를 import한다.
import java.util.*;
import java.util.stream.IntStream;

public class OneQnAnswer {

    // 배열을 사용하는 방식
    public int[] Tsoultion01(int[] arr) {
        // 최대값 구하기
        int max=0;
        for(int a : arr) if(a > max) max=a;

        // 최대값이 몇개인지 확인
        int count = 0;
        for(int a : arr) if(a > max) count++;

        // 배열 만들기
        int[] answer = new int[count];
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == max) answer[index++] = i;
        }

        // 배열이 인덱스 채우기
        return answer;
    }

    // 리스트를 사용하는 방식
    public int[] Tsoultion02(int[] arr) {
        // 최대값 구하기

        // 방식01. for문 활용
        /*int max=0;
        for(int a : arr) if(a > max) max=a;*/

        // 방식02. max 함수 활용
        int max = Arrays.stream(arr).max().getAsInt();

        // 배열이 인덱스 채우기
        // 방식01. for문 활용
        List<Integer> list  =new LinkedList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == max) list.add(i);
        }

        // 방식02. stream 활용
        /*IntStream.range(0, arr.length)
                .filter(i->arr[i] == max)
                .toArray();*/

        // 리스트를 배열로 변환
        // 방식01. for문 활용
        /*int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }*/

        // 방식 02. Stream 활용
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public int[] mySolution01(int[] arr) {
        int[] answer = {0,0};
        for(int i=0; i<arr.length; i++) {
            if(answer == null) {
                answer[0] = arr[i];
            }
            else if(arr[answer[0]] <= arr[i])  {
                if(answer[0] != 0 && arr[answer[0]] == arr[i]) {
                    answer[1] = i;
                    break;
                }
                answer[0] = i;
            }

        }
        return answer;
    }
}