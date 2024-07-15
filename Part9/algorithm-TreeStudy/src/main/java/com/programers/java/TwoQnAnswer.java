package com.programers.java;

import java.util.*;

/* Part08. 문제 02 )
n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
* */

public class TwoQnAnswer {

    class Node {
        int n;
        int dist = 0;
        boolean visited = false;
        List<Node> links  = new LinkedList<>();
        Node (int n) {this.n = n;}
    }

    public int Tsolution01(int n, int[][] edge) {
        // node 를 list에 저장
        List<Node> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(new Node(i + 1));
        // 각 Node에 연결된 정보를 Node 안의 links에 저장
        for(int[] e : edge) {
            Node n1 = list.get(e[0] - 1);
            Node n2 = list.get(e[1] - 1);
            n1.links.add(n2);
            n2.links.add(n1);
        }

        int maxDist=0;

        Queue<Node> queue = new LinkedList<>();
        Node frist = list.get(0); // 1번 node는 방문 처리
        frist.visited = true;
        queue.offer(frist);
        // Node 의 연결 상태를 알아보기 및 가장 많이 연결된 것을 보기
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            // node와 연결되어 있는 linkes를 방문하며, visited를 true로,
            // 연결 정보를 의미하는 dist를 +1 을 하고, maxDist 수정
            for(Node node : now.links) {
                if(node.visited) continue;

                node.visited = true;
                node.dist = now.dist + 1;
                queue.offer(node);

                maxDist = Math.max(maxDist, node.dist);
            }
        }

        int answer = 0;

        for(Node node : list) {
            if(node.dist == maxDist) answer++;
        }

        return answer;
    }

}