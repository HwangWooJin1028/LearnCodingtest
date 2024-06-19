package com.programers.java;
import java.util.*;

public class OneQnAnswer {

    public int Tsolution02(int[] nums) {
        int answer = 0;

        // 같은 종류가 몇개있는지 중요하다.
        // EX: [3,3,3,2,2,2]
        // [3,2]    : 2개
        // N/2      : 3개
        // 문제의 핵심: 포켓몬의 종류의 개수를 구한다.
        List<Integer> list = new LinkedList<>();
        for (int n : nums) {
            if(!list.contains(n)) list.add(n); // list에 n이 없으면 add
        }
        int n1 = list.size();

        // 배열 크기의 1/2를 구한다.
        int n2 = nums.length/2;

        // 최소값을 선택한다.
        return Math.min(n1, n2);
    }

    public int Tsolution01(int[] nums) {
        int answer = 0;

        // 같은 종류가 몇개있는지 중요하다.
        // EX: [3,3,3,2,2,2]
        // [3,2]    : 2개
        // N/2      : 3개
        // 문제의 핵심: 포켓몬의 종류의 개수를 구한다.
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, 0);
        }
        int n1 = map.keySet().size();

        // 배열 크기의 1/2를 구한다.
        int n2 = nums.length/2;

        // 최소값을 선택한다.
        return Math.min(n1, n2);
    }

    public int mySolution01(int[] nums) {

        // 1. 몇마리의 포켓몬을 가져가야 하는 지 알기
        int size = nums.length/2;

        // 2. 어떠한 종류에 그 종류에 대해 포켓몬이 얼마나 있는지 확인하기
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.getOrDefault(nums[i], -1) != -1) {
                map.put(nums[i], (map.get(nums[i])+1) );
            }else if(map.getOrDefault(nums[i], -1) == -1) {
                map.put(nums[i], 1);
            }
        }


        // 3. 최종 결과물
        int answer = 0;
        if(size<map.size()) {
            answer = size;
        } else if(size>=map.size()) {
            answer = map.size();
        }

        return answer;
    }
}