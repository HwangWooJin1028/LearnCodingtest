package com.programers.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Part08. 문제 03 )
n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면
A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게
순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
모든 경기 결과에는 모순이 없습니다.
* */

public class ThreeQnAnswer {

    class Node {
        int n;
        int win = 0, lose = 0;
        boolean visited = false;
        List<Node> links = new ArrayList<>();
        Node(int n) { this.n = n; }
    }

    public int Tsolution(int n, int[][] results) {
        List<Node> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new Node(i+1));

        // 승자에서 패자로 방향성 부여
        for(int[] result: results) {
            Node winner = list.get(result[0] - 1);
            Node loser = list.get(result[0] - 1);
            winner.links.add(loser);
        }

        // list에 있는 node 들 부르기
        for(Node winner : list) {
            // 각 list에 있는 node들의 visited를 false해서 다시 winner 기준으로
            // 승,패 수를 세기
            for(Node node : list) node.visited = false;

            // 각 노드에 연결된 노드들(패자)를 queue에 넣으며 win, lose 수 세기
            Queue<Node> queue = new LinkedList<>();

            queue.offer(winner);
            while(!queue.isEmpty()) {
                Node now = queue.poll();
                
                // 현재 방문하고 있는 노드의 links를 돌아보며 승패 수를 세기
                for(Node loser : now.links) {
                    if(loser.visited) continue;

                    loser.visited = true;
                    queue.offer(loser);
                    winner.win++;
                    loser.lose++;
                }
            }
        }

        int answer = 0;
        for(Node node : list) {
            if(node.win + node.lose == n - 1) answer++;
        }
        return answer;
    }
}