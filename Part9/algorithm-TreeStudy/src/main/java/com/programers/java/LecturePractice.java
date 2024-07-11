package com.programers.java;

import java.util.*;

class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v) {
        this.v = v;
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
        return Integer.compare(this.v, o.v);
    }
}

public class LecturePractice {

    public static void ex04() {
        // 최대값(최소값) 유지
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Random r = new Random();
        for (int i = 0; i < 20; i++) maxHeap.offer(r.nextInt(50));
        // 이 maxHeap을 println을 하면 정렬이 안 된 상태로 출력이 된다.
        System.out.println(maxHeap);

        List<Integer> list = new LinkedList<>();
        while (!maxHeap.isEmpty()) list.add(maxHeap.poll());

        // 정렬이 된 상태로 println이 된다.
        System.out.println(list);
    }

    public static void ex03() {

        Queue<Integer> que = new PriorityQueue<>(); // Queue 로도 받는 것이 가능
        que.offer(100);
        que.offer(60);
        que.offer(30);
        que.offer(1);

        System.out.println("---------------- Queue -----------------");
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.poll());

        // Heap은 보통 PriorityQueue 로 구현되어 있다.

        // min Heap 으로 제공
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(100);
        minHeap.offer(60);
        minHeap.offer(30);
        minHeap.offer(1);

        System.out.println("---------------- Min Heap -----------------");
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());


        // max Heap 으로 제공
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(100);
        maxHeap.offer(60);
        maxHeap.offer(30);
        maxHeap.offer(1);

        System.out.println("---------------- Max Heap -----------------");
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }


    public static void ex02() {
        // 값이 있는지 빠르게 검색 할 때 사용하는 방법은 숫자의 대소 관계를 이용한다.
        // 따라서 TreeSet은 사용자가 만든 객체를 add를 할 수 없다.
        // 만약 사용자가 만든 class를 저장하고 싶다면 Comparable 를 implements 하여 compareTo를 구현해야 한다.
        Set<MyData> set = new TreeSet<>();

        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));

        // Set 자료 구조는, 같은 값을 넣어지지가 않는다.
        // 이유는 add를 할 때, 값이 있는지 없는지 확인하기 때문
        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));

    }

    public static void ex01() {
        // TreeSet 은 Binary Search Tree 를 사용하여 내부가 구현되고 있다.
        // 때문에, add 를 할 때, 값이 있는지 빠르게 검색하는 것이 가능하다.
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        // Set 자료 구조는, 같은 값을 넣어지지가 않는다.
        // 이유는 add를 할 때, 값이 있는지 없는지 확인하기 때문
        set.add(1);
        set.add(2);
        set.add(3);

    }
}