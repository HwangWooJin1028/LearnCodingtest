package com.programers.java;

import java.util.*;

// Deque: 앞에서도 값을 꺼낼 수 있으며, 뒤에서도 꺼낼 수 있다. (양방향)
// (addFirst, addLast, offerFirst, offerLast)

public class LecturePractice {

    // java 에서 제공하는 Deque 을 사용
    public static void Ex04() {
        // Stack
        // Stack 는 Class 로 제공하며 vector 를 상속한다.
        Deque<Integer> deque = new LinkedList<>() {};

        deque.offerFirst(1);
        System.out.println(deque);

        deque.offerLast(2);
        System.out.println(deque);

        deque.offerFirst(3);
        System.out.println(deque);

        deque.offerLast(4);
        System.out.println(deque);

        // 첫번째 값이 꺼내짐
        deque.pollFirst();
        System.out.println(deque);
    }

    // java 에서 제공하는 stack 을 사용
    public static void Ex03() {
        // Stack
        // Stack 는 Class 로 제공하며 vector 를 상속한다.
        Stack<Integer> stack = new Stack<>();

        // 값을 add
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        // 값을 꺼내는 메서드
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        // 값을 꺼낼 차례가 된 요소를 확인
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);


    }

    // java 에서 제공하는 queue 를 사용
    public static void Ex02() {
        // Queue
        // Queue 는 Interface 로만 제공한다.
        // add, remove, element 는 각각의 행동을 못할 경우, throw exception 을 하지만,
        // offer, poll, peek 는 return special value 를 한다.
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);
        // 값을 꺼내지 않고 확인만 하는 메서드
        System.out.println(queue.peek());
        System.out.println(queue);
    }

    // List 를 활용하여 stack, queue 를 구현
    public static void Ex01() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 스택 적용
        // 맨 마지막에 들어온 값을 제거하여 적용한다.
        System.out.println(list.remove(list.size() -1));
        System.out.println(list);

        // 큐 적용
        // 0번째 값(처음 들어온 값)을 없애 큐를 적용시킨다.
        System.out.println(list.remove(0));
        System.out.println(list);

        // 0번째 값(맨 앞에 있는 값)을 없애 큐를 적용시킨다.
        System.out.println(list.remove(0));
        System.out.println(list);
    }
}
