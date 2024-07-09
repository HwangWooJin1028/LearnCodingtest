package com.programers.java;
import java.util.*;
public class OneQnAnswer {

    // DFS 를 사용한 풀이
    public void DFSvisitAllConnectedComputers(int[][] computers, boolean[] visited, int c) {
        Stack<Integer> q = new Stack<>();
        // c 컴퓨터를 기준으로 시작.
        q.push(c);
        // q가 empty가 될때까지 while문 돌기
        while(!q.isEmpty()) {
            int i= q.pop();
            visited[i] = true;
            // 방문해야 하는 컴퓨터를 q에 offer
            for(int j=0; j<computers[i].length; j++) {
                if(visited[j]) continue;
                if(computers[i][j] == 1) q.push(j);
            }
        }
    }

    // BFS 를 이용하여 컴퓨터에 방문한다.
    public void visitAllConnectedComputers(int[][] computers, boolean[] visited, int c) {
        Queue<Integer> q = new LinkedList<>();
        // c 컴퓨터를 기준으로 시작.
        q.offer(c);
        // q가 empty가 될때까지 while문 돌기
        while(!q.isEmpty()) {
            int i= q.poll();
            visited[i] = true;
            // 방문해야 하는 컴퓨터를 q에 offer
            for(int j=0; j<computers[i].length; j++) {
                if(visited[j]) continue;
                if(computers[i][j] == 1) q.offer(j);
            }
        }
    }

    public int Tsolution(int[][] computer, int n) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            // 이미 방문 했으면 continue
            if(visited[i]) continue;
            answer++;

            // 연결되어 있는 모든 곳을 방문하여 visited에 true
            // 예를 들어, 1, 2, 3, 4가 있고 각각 1은 2,3에 연결되어 잇는 거라고 하면,
            // 1을 방문할때 방문하지 않았으므로 answer에 ++를 하고, 1에 연결되어 있는
            // 2,3은 다시 방문하지 않도록 visited에 true를 해놓는다.
            // 그래서 2,3은 continue가 되고, 4는 방문하지 않았으므로 answer++를 하고
            // 연결되어 있는 컴퓨터를 방문한것으로 한다.
            visitAllConnectedComputers(computer, visited, i);
        }
        return answer;
    }
    public int mySolution(int n, int[][] computers) {
        List<Integer> list = new LinkedList<>();

        // 1. 각 컴퓨터의 1의 개수 세기
        for(int i=0; i<n; i++) {
            int t = 0;
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    if(computers[i][j] == computers[j][i]) {
                        if(t == 0) t++;
                        continue;
                    }
                    list.add(1);
                }
            }
            if(t > 1) list.add(1);

        }

        return list.size()/2;
    }
}
