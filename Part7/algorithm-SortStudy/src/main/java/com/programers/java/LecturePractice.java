package com.programers.java;

import java.util.*;

class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }

    // Comparable<MyData> 를 상속받아 compareTo를 구현
    @Override
    public int compareTo(MyData o) {
        return Integer.compare(this.v, o.v); // this.v - o.v
    }
}

// Interface Comparator
public class LecturePractice {

    // 퀵 정렬 구현 메소드
    public static List<MyData> quickSort(List<MyData> list) {
        // 만약 list 내부에 있는 데이터가 1개이거나 0개이면 list를 그대로 return
        if(list.size() <= 1) return list;

        // pivot 값을 지정 (아무 값이나 상관 없다.)
        MyData pivot = list.remove(0);

        // pivot을 기준으로 작은 값과 큰 값을 나누기 위해 List<>를 생성
        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        // pivot 과  List 내부에 있는 값을 비교하여 작은 list와 큰 list에 값을 add
        for(MyData d : list){
            if(pivot.compareTo(d) > 0) lesser.add(d);
            else greater.add(d);
        }

        // less와 greater를 합친다.
        // 이때, less 와 grater List 도 같은 과정을 거쳐야 되기 때문에 지금 실행되고 있는 함수를 호출한다.
        List<MyData> merged = new LinkedList<>();
        merged.addAll(quickSort(lesser));
        merged.add(pivot);
        merged.addAll(quickSort(greater));

        return merged;
    }

    // 사용자 정의 데이터 퀵 정렬 구현
    public static void ex03() {
        List<MyData> list = new LinkedList<>();

        Random rand = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(rand.nextInt(50)));
        list = quickSort(list);
        System.out.println(list);
    }

    // 사용자 정의 데이터 정렬 함수 사용
    public static void ex02() {
        List<MyData> list = new LinkedList<>();

        Random rand = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(rand.nextInt(50)));

        // 내가 정의한 데이터를 정렬을 하는 것이기 때문에, Comparator에서 제공하는 정렬 함수는 사용할 수 없다.
        // list.sort(Comparator.naturalOrder());

        // 때문에 이런 식으로 compare 함수를 구현하여 정렬을 할 수 있다.
        // 기존의 Comparator.naturalOrder() 같은 정렬 함수를 사용하기 위해서는,
        // 자신이 만든 클래스에 compareTo를 구현하면 된다.
        list.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });

        System.out.println(list);
    }

    // Integer 정렬 함수 사용
    public static void ex01() {
        List<Integer> list = new ArrayList<Integer>();

        Random rand = new Random();
        for(int i=0; i<20; i++) list.add(rand.nextInt(50));

        // 오름차순
        // list.sort(Comparator.naturalOrder());

        // 내림차순
        // list.sort(Comparator.reverseOrder());

        list.sort(new Comparator<Integer>() {
            // 인자로 들어온 두 값을 빼 음수가 반환되는지, 양수가 반환되는지, 0이 반환되는지에 따라
            // 정렬이 된다.
            // o2.intValue()-o1.intValue() 인 경우에는 내림차순,
            // o1.intValue()-o2.intValue() 인 경우에는 오름차순이다.
            // 또한, .intValue()를 사용하여 두 수를 빼 정렬을 할 수 있지만, .compareTo를 통해 비교할 수도 있다.
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        // 또한, 정렬을 람다로 사용할 수도 있다.
        list.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println(list);
    }
}
