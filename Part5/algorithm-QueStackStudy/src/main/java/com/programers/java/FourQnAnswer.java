package com.programers.java;

import java.util.*;
import java.util.stream.Collectors;

/* Part 05. 문제 04
문제 설명
운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다.
이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.

1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.

현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와,
몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때,
해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요
*/
public class FourQnAnswer {
    class Paper {
        boolean isMine;
        int priority;
        Paper(boolean isMine, int priority) {
            this.isMine = isMine;
            this.priority = priority;
        }
    }

    public int Tsolution01(int[] priorities, int location) {
        int answer = 0;
        List<Paper> papers = new ArrayList<>();
        for(int i=0;i<priorities.length;i++) {
            // 만약, 해당하는 값이 내가 알고싶은 것이면 true를 설정한다.
            papers.add(new Paper(i == location, priorities[i]));
        }

        while(!papers.isEmpty()) {
            Paper now = papers.remove(0);
            boolean printable = false;
            for(Paper p : papers) {
                // 만약, 현재 우선순위가 높은 것이 리스트 내부에 존재한다면
                if(p.priority > now.priority) {
                    printable = false; // false를 반환
                    break;
                }
            }

            // 만약 현재 우선순위가 높은 것이 리스트 내부에 존재한다면
            if(!printable) {
                papers.add(now); // queue에 데이터를 넣는다.
                continue;
            }

            answer++;
            if(now.isMine) return answer; // 만약 now가 isMine이면 return한다.
        }

        return answer;
    }

    public int mySolution04(int[] priorities, int location) {
        int answer = 1;
        Queue<Character> que = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            int charint = 'A'+i;
            que.offer((char)charint);
        }

        for(int i = 0; i < priorities.length; i++){
            char process = que.poll();
            for(int j=0; j<que.size(); j++) {
                char compare = que.poll();
                if(priorities[i] == priorities[j]) {
                    que.offer(process);
                    que.offer(compare);
                    break;
                }
                else if(priorities[i] > priorities[j]) {
                    que.offer(compare);
                }
            }
        }

        System.out.println(que);

        return 'A' + location;
    }

    public int mySolution03(int[] priorities, int location) {
        int answer = 1;

        for(int i=0; i<priorities.length; i++){
            for(int j=0; j<priorities.length; j++) {
                if(i==j) continue;
                if(priorities[i] > priorities[j]) answer++;
                else if(priorities[i] == priorities[j] && i<j) answer++;
            }
            if((i+1) == location){
                break;
            } else {
                answer = 1;
            }
        }

        return answer;
    }

    public int mySolution02(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));

        for(int i=0; i<priorities.length; i++) {
            int process = que.poll();
            for(int j=0; j<que.poll(); j++) {
                int compare = que.poll();
                if(compare > process) que.offer(compare);
                if(compare < process) que.offer(compare); que.offer(process);
            }
        }

        return answer;
    }

    public int mySolution01(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));

        for(int i=0; i<que.size(); i++) {
            int num = que.poll();
            int max = que.stream().max(Integer::compare).get();
            if(max > num) que.offer(num);
            else if(max <= num) answer++;
            if(location == i) break;
        }
        return answer;
    }
}
