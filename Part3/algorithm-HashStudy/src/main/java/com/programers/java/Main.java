package com.programers.java;

import java.util.Hashtable;
import java.util.Map;
// Array 장점  + LiST 장점 => 유연하면서도 빠르게 값을 찾을 수 있음.
// HashMap: not synch
// Hashtable : synch

public class Main {
    public static void main(String[] args) {
        ex01();
        OneQnAnswer oneQnAnswer = new OneQnAnswer();
        int[] nums = {3,2,2,4,5,5};
        oneQnAnswer.mySolution01(nums);
    }

    // 실습 내용
    static void ex01() {
        Map<String, Integer> map = new Hashtable<>();
        map.put("A", 1); // key: A, value = 1
        map.put("B", 2);

        map.remove("B", 3); // 이 경우, 3이 존재하지 않으므로 삭제되지 않는다.
        map.replace("A", 10, 11); // 만약 A의 값이 10이면 11로 바꾸어라

        // map.put("A", 10); // 이 경우, A라는 KEY값을 가진 Value값이 10으로 덮어씌워진다.
        map.putIfAbsent("A", 10); // 만약 A라는 key를 가진 Value값이 없을때만 들어간다.
        method(map);
    }

    static void method(Map<String, Integer> map) {
        System.out.println(map);
        System.out.println(map.get("A"));
        // System.out.println(map.get("C")); // ERROR

        // 만약 C가 없다면, -1로 주세요..
        System.out.println(map.getOrDefault("C", -1));

        System.out.println(map.values());
        System.out.println(map.keySet());

    }
}