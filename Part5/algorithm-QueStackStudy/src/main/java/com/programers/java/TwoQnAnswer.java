package com.programers.java;

import java.util.*;

/* Part 05. 문제 02
문제 설명
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses 와
각 작업의 개발 속도가 적힌 정수 배열 speeds 가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds 배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다. 7 3 9
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
*/
public class TwoQnAnswer {

    public int[] Tsolution01(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            float p  = progresses[i];
            float s = speeds[i];
            int days = (int)Math.ceil((100 - p) / s);
            queue.offer(days);
        }
        Queue<Integer> answer = new LinkedList<>();
        int d = queue.poll();
        int count = 1;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if(d >= n) {
                count++;
                d = n;
                continue;
            }
            answer.offer(count);
            count = 1;
            d = n;
        }
        answer.offer(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution03(int[] progresses, int[] speeds) {
        List<Integer> returnList = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int date = 0;
        queue.offer((int)Math.ceil((double)(100-progresses[0])/speeds[0]));
        for(int i=0; i<progresses.length; i++) {
            queue.offer((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
            if(queue.poll() >= queue.peek()) date++;
            else {
                returnList.add(date);
                date = 1;
            }
        }
        returnList.add(date);
        return returnList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution02(int[] progresses, int[] speeds) {
        // 1. 각 프로세스의 작업 기간 구하기
        List<Integer> returnList = new LinkedList<>();
        List<Integer> resultList = new LinkedList<>();
        int date = 0;
        resultList.add((int)Math.ceil((double)(100-progresses[0])/speeds[0]));
        for(int i=0; i<progresses.length; i++) {
            resultList.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
            if(resultList.get(resultList.size()-1) <= resultList.get(resultList.size()-2)) date++;
            else if(resultList.get(resultList.size()-1) > resultList.get(resultList.size()-2)) {
                returnList.add(date);
                date = 1;
            }
        }
        returnList.add(date);
        return returnList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution01(int[] progresses, int[] speeds) {
        Queue<Integer> result = new LinkedList<>();
        List<Integer> returnList = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            result.offer((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }

        int peek = result.poll();
        int index=0;
        returnList.add(1);
        for(int i=0; i<result.size(); i++) {
            if(peek >= result.peek()) {
                result.poll();
                int value = returnList.get(index);
                returnList.set(index, ++value);
                index++;
            } else if(peek < result.peek()) {
                peek = result.poll();
                returnList.add(1);
            }
        }

        return returnList.stream().mapToInt(Integer::intValue).toArray();
    }
}
