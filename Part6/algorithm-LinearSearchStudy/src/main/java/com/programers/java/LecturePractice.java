package com.programers.java;

import java.util.*;

class MyData implements Comparable<MyData>{
    int v;
    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "" + v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(v);
    }

    @Override
    public int compareTo(MyData o) {
        // 1 == 1 : 1 - 1 == 0 : 같다.
        // 1 ? 2 : 1 - 2 == 0 : 같아
        //                < 0 : 오른쪽 것이 크다
        //                > 0 : 왼쪽 것이 크다.
        return v - o.v;
    }
}

public class LecturePractice {

    public static void ex04() {
        List<MyData> list = new LinkedList<>();

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            // random으로 1~100까지의 숫자를 랜덤으로 넣는다.
            list.add(new MyData(i));
        }
        System.out.println(list);
        // 이 경우, list는 random으로 정렬되어 있기 때문에 정렬이 되어있어야 한다.
        int index = Collections.binarySearch(list, new MyData(r.nextInt(63)));
        System.out.println(index);
    }

    public static void ex03() {
        List<MyData> list = new LinkedList<>();

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            // random으로 1~100까지의 숫자를 랜덤으로 넣는다.
            list.add(new MyData(r.nextInt(100)));
        }
        System.out.println(list);
        // 이 경우, list는 random으로 정렬되어 있기 때문에 정렬이 되어있어야 한다.
        int index = Collections.binarySearch(list, new MyData(r.nextInt(63)));
        System.out.println(index);
    }

    public static void ex02() {
        List<MyData> list = new LinkedList<>();

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(new MyData(i));
        }
        System.out.println(list);

        // 이 경우, 63을 못찾고 있다. equals 함수를 MyData 내부에 구현해야 한다.
        int index = list.indexOf(new MyData(63));
        System.out.println(index);
    }

    public static void ex01() {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list);

        // indexOf 안에 LinearSearch 알고리즘이 구현되어 있기 때문에,
        // 63을 찾을 수 있다.
        int index = list.indexOf(63);
        System.out.println(index);
    }
}
