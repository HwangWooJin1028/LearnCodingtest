package com.programers.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LecturePractice {

    // Set을 사용 --> 집합 만들기
    public static void Ex04() {
        HashSet<MyData> setA = new HashSet<>();
        HashSet<MyData> setB = new HashSet<>();

        // 집합 A
        setA.add(new MyData(1));
        setA.add(new MyData(2));
        setA.add(new MyData(3));

        // 집합 B
        setB.add(new MyData(2));
        setB.add(new MyData(3));
        setB.add(new MyData(4));

        // A + B
        // 합집합
        // setA.addAll(setB);
        // System.out.println(setA);

        // A - B
        // 차집합
        // setA.removeAll(setB);
        // System.out.println(setA);

        // 교집합
        // setA와 setB 둘다 함께 존재하는 요소만 남긴다.
        setA.removeAll(setB);
        System.out.println(setA);
    }

    // Set을 사용 --> MyData Clss 사용
    public static void Ex03() {
        HashSet<MyData> set = new HashSet<>(); // Set은 순서를 보장하지 않음.

        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));

        // 이 경우, 1,2,3은 중복으로 들어가지 않는다.
        // 기본적으로 add를 할 때, 중복으로 들어가는지 체크하는 절차가 들어가게 된다.
        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));
    }

    // Set을 사용
    public static void Ex02() {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        // 이 경우, 1,2,3은 중복으로 들어가지 않는다.
        // 기본적으로 add를 할 때, 중복으로 들어가는지 체크하는 절차가 들어가게 된다.
        set.add(1);
        set.add(2);
        set.add(3);
    }

    // List로 Set을 구현
    public static void Ex01() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // 이 경우, list에는 1,2,3이 중복 된다.
        list.add(1);
        list.add(2);
        list.add(3);

        // 이렇게 하는 경우, list 는 1,2,3 이 중복 되지 않는다.
        if(!list.contains(1)) list.add(1);
        if(!list.contains(2)) list.add(2);
        if(!list.contains(3)) list.add(3);

        System.out.println(list);
    }
}
