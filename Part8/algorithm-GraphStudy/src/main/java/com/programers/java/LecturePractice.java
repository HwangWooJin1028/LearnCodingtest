package com.programers.java;

import java.util.*;
class Node {
    String name;
    List<Node> links;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }

    void link(Node node) {
        links.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, links);
    }

    void visited() {
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }
}

public class LecturePractice {
    public static void BFS() {
        // Graph
        // 그래프는 java에서 지원 x, 직접 구현해야 함.
        List<Node> nodes = new LinkedList<>();
        Node a = (new Node("A"));
        Node b = (new Node("B"));
        Node c = (new Node("C"));
        Node d = (new Node("D"));
        Node e = (new Node("E"));

        // 그래프와 연결된 Node 연결
        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        // BFS : Queue 사용
        // 예약 노드들을 저장하는 큐 변수 생성 및 add(offer)
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a);

        while(queue.isEmpty()) {
            Node n = queue.poll();
            n.visited();
            if(n.equals(e)) {
                break;
            }
            // 해당하는 노드에 연결된 것들을 queue에 넣으며 예약한다.
            /*n.links.stream()
                    .filter(l -> queue.contains(l))
                    .forEach(queue::offer);*/

            for(Node l : n.links) {
                if(l.isVisited()) continue;
                if(queue.contains(l)) continue;
                queue.offer(l);
            }
        }

    }

    public static void DFS() {
        // Graph
        // 그래프는 java에서 지원 x, 직접 구현해야 함.
        List<Node> nodes = new LinkedList<>();
        Node a = (new Node("A"));
        Node b = (new Node("B"));
        Node c = (new Node("C"));
        Node d = (new Node("D"));
        Node e = (new Node("E"));

        // 그래프와 연결된 Node 연결
        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        // BFS : Queue 사용
        // 예약 노드들을 저장하는 큐 변수 생성 및 add(offer)
        Stack<Node> queue = new Stack<>();
        queue.push(a);

        while(queue.isEmpty()) {
            Node n = queue.pop();
            n.visited();
            if(n.equals(e)) {
                break;
            }
            // 해당하는 노드에 연결된 것들을 queue에 넣으며 예약한다.
            /*n.links.stream()
                    .filter(l -> queue.contains(l))
                    .forEach(queue::offer);*/

            for(Node l : n.links) {
                if(l.isVisited()) continue;
                if(queue.contains(l)) continue;
                queue.push(l);
            }
        }
    }
}
