package com.programers.java;

import java.util.*;

/* Part08. 문제 01 )
문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
- scoville의 길이는 2 이상 1,000,000 이하입니다.
- K는 0 이상 1,000,000,000 이하입니다.
- scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
- 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
* */
public class OneQnAnswer {


    public int Tsolution02(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) { queue.offer(s); }

        int answer = 0;
        while(queue.peek() < K && queue.size() >= 2) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            queue.offer(n1 + (n2 * 2));
            answer++;
        }

        if(queue.peek() < K) return -1;

        return answer;
    }


    public int Tsolution01(int[] scoville, int K) {
        // [ 1, 2, 3, 9, 10, 12 ]  K = 7
        // [ 3, 9, 10, 12, 5 ] : 1회 섞음
        // [ 9, 10, 12, 13 ] : 2회 섞음

        Arrays.sort(scoville);
        List<Integer> list = new ArrayList<>();
        for(int s : scoville) list.add(s);

        Collections.sort(list);

        int answer = 0;
        while(list.get(0) < K && list.size() >= 2) {
            int s1 = list.remove(0);
            int s2 = list.remove(0);
            int s3 = s1 + s2 * 2;
            list.add(s3);
            answer++;
        }

        if(list.get(0) < K) return -1;

        return answer;
    }

    public int mySolution04(int[] scoville, int K) {
        int i=0;

        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) { queue.offer(s); }

        while(queue.peek() < K && queue.size() >= 2) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            queue.offer(n1 + (n2 * 2));
            i++;
        }

        if(!(queue.peek() >= K)) return -1;

        return i;
    }

    public int mySolution03(int[] scoville, int K) {
        int i=0;

        TreeSet<Integer> set = new TreeSet<>();
        for(int s : scoville) { set.add(s); }

        while(set.first() < K && set.size() >= 2) {
            int n1 = set.pollFirst();
            int n2 = set.pollFirst();
            set.add(n1+(n2*2));
            i++;
        }

        if(!(set.first() >= K)) return -1;

        return i;
    }

    public int mySolution02(int[] scoville, int K) {
        int i=0;

        TreeSet<Integer> set = new TreeSet<>();
        for(int s : scoville) { set.add(s); }

        for(i=0; i<set.size(); i++) {
            if(set.first() >= K) return i;
            int n1 = set.pollFirst();
            int n2 = set.pollFirst();
            set.add(n1+(n2*2));
        }

        return i;
    }

    // 해당 풀이가 틀린 이유
    // 1. queue 의 size 만큼만 돌기 때문. while 문을 사용 하여 조건에 true 인 경우만 돌도록 설계할 것
    // 2. 반복문을 돌 때, queue 의 크기가 2 미만인 경우를 고려안함.
    // 3. while 문을 빠져 나왔는데도 가장 작은 스코빌 지수가 7 미만인 경우, return -1 해야한다는 제한사항을 잘 수행하지 못함.
    public int mySolution01(int[] scoville, int K) {
        int i=0;

        // 1. queue에 차례대로 scovill를 넣어 작은수에서 큰수로 정렬
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) { queue.offer(s); }

        // 2. min Heap 으로 정렬한 자료를 돌면서, 스코빌 지수를 계산
        for(i=0; i<queue.size(); i++) {
            if(queue.peek() >= K) return i;
            int n1 = queue.poll();
            int n2 = queue.poll();
            int result = n1 + (n2 * 2);
            queue.offer(result);
        }

        return i;
    }
}
