package com.programers.java;
import java.util.*;
import java.util.stream.Collectors;
public class OneQnAnswer {

    public int[] Tsolution02(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        // 최소값 구하기
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr)
                .filter(a -> a != min) // a가 min값이 아닐때만 array를 만든다.
                .toArray();
    }

    public int[] Tsolution01(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        // 최소값 구하기
        int min = Integer.MAX_VALUE;
        for(int a:arr) if(a < min) min = a;

        // 최소값 빼고 나머지 배열 만들기
        int[] answer = new int[arr.length-1];
        int index = 0;
        for(int a : arr) {
            if(a == min) continue;
            answer[index++] = a;
        }

        return answer;
    }

    public int[] mySolution06(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int tIdx = 0;
        int small = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(small > arr[i]) {
                small = arr[i];
                tIdx = i;
            }
        }

        list.remove(tIdx);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution05(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        for(int i=1; i<arr.length; i++) {
            int temp = 0;
            if(arr[i] < arr[i-1]) {
                temp = arr[i];
            }

        }
        int[] answer = new int[arr.length-1];
        for(int i=0; i<answer.length; i++) answer[i] = arr[i];

        return answer;
    }

    public int[] mySolution04(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        for(int i=0; i<arr.length; i++) {
            int temp = arr[i];
            int tIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(temp < arr[j]){
                    temp = arr[j];
                    tIdx = j;
                }
            }
            temp = arr[tIdx];
            arr[tIdx] = arr[i];
            arr[i] = temp;
        }
        int[] answer = new int[arr.length-1];
        for(int i=0; i<answer.length; i++) answer[i] = arr[i];

        return answer;
    }

    public int[] mySolution03(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        for(int i=1; i<arr.length; i++) {
            int temp = 0;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        int[] answer = new int[arr.length-1];
        for(int i=0; i<answer.length; i++) answer[i] = arr[i];

        return answer;
    }

    public int[] mySolution02(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());
        list.remove(list.size()-1);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution01(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());
        list.remove(list.size()-1);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
