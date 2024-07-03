package com.programers.java;
import java.util.*;
import java.util.stream.Collectors;
public class OneQnAnswer {

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
