package com.programers.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// LinkedList
// List 인터페이스

// ArrayList(not synch)
// Vector(synch)

class MyData {
    int value;

    public MyData(int v) {
        this.value = v;
    }

    static MyData create(int v) {
        return new MyData(v);
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyData other = (MyData) obj;
        return value == other.value;
    }
}

public class Main {
    public static void main(String[] args) {
        ThreeQnAnswer threeQnAnswer = new ThreeQnAnswer();
        long l = 12345;
        threeQnAnswer.mySolution01(l);
    }

    // vector 이건 LinkedList 이던 Stack 이던 상관없이 사용이 되도록 한다.
    private static void method(List<MyData> list) {
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }

    public static void ex01() {
        int[] listdd = {};
        
        // List로 들어가는 요소들을 <>로 정의
        List<Integer> list = new Vector<>(); // 백터형인데, 리스트 형으로도 표현 가능하다. --> 다형성
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,4); // index 1에 4라는 요소 추가
        list.remove(2);

        // 서로 link로 이어져 있다.
        System.out.println(list);
        System.out.println(list.get(2));

        // 5라는 값이 있는지 확인한다.
        // 이때, 5라는 값이 자동으로 pasing이 되어, Integer.valueOf(5) 한것과 같게 된다.
        // 즉, 5가 참조 타입으로 pasing이 되었다는 것.
        System.out.println(list.contains(5));
    }

    public static void ex02() {

        // List로 들어가는 요소들을 <>로 정의
        // LinkecList는 양방향 리스트를 구현함.


        // ArrayList
        // ArrayList는 내부에 ArrayList가 구현이 되어있어, 이것의 크기를 늘어나거나 줄어들거나 한다.
        // 예를들어, 5개짜리 크기의 ArrayList가 구현되어 있는데 이보다 더 큰 사이즈의 List가 필요해 졌다면 더 큰 크기의 list를 만들어 기존의 작은 사이즈의 List는 삭제된다.
        // ArrayList는 생성할 때, int값을 넣을 수 있어 처음 ArrayList를 생성할 때의 크기를 지정할수있다.
        // 또, ArrayList는 주로 멀티스레드 상황이 아니면서도 값을 빨리 찾아야 할 떄 사용한다.
        // List<MyData> list = new ArrayList<>(5);

        // Vector
        // Vector도 역시 ArrayList와 마찬가지로 크기가 유동성이다. 즉, 변한다.
        // 따라서 Vector 역시 생성자에 처음 생성할 당시의 크기를 지정할 수 있다.
        // 그리고, 그 크기에 꽉 차고 값을 또 넣어야 할때, 크기를 얼마나 늘릴거냐 까지 정할 수 있다.
        // Vector는 추가하거나 삭제할 때, 동기화 기능이 있기 때문에 멀티쓰레드 환경에서 좋다.
        List<MyData> list = new Vector<>(5,2); // 처음 생성할 떄, list를 5개까지 생성, 만약 꽉차면 2개씩 늘리기
        list.add(MyData.create(1));
        list.add(MyData.create(2));
        list.add(MyData.create(3));

        // 서로 link로 이어져 있다.
        System.out.println(list);

        // false가 나오는 데, 그 이유는 MyData.create로 다른 값을 만들었기 때문이다.
        // 하지만 참조된 값은 같다. 때문에 이렇게 될려면
        System.out.println(list.contains(MyData.create(2)));
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        method(list);
    }

}