package com.programers.java;

import java.util.*;

/*
Part 08. 4번째 문제

-- 문제 설명
ROR 게임은 두 팀으로 나누 어서 진행 하며, 상대 팀 진영을 먼저 파괴 하면 이기는 게임 입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.

게임 맵의 상태 maps 가 매개 변수로 주어질 때, 캐릭터 가 상대 팀 진영에 도착 하기 위해서 지나 가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주 세요.

-- 제한 사항
maps 는 n x m 크기의 게임 맵의 상태가 들어 있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수 입니다.
n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력 으로 주어 지지 않 습니다.
maps 는 0과 1로만 이루 어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타 냅니다.
처음에 캐릭터 는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.

-- 해설
DFS BFS 를 사용 하는 대표 적인 문제 이다.
1. 사용자 X는 동 서 남 북 으로 갈 수 있다.
2. 내가 지나온 길인지 구별을 할 필요가 있다.
3. 또한, 내가 지나간 하는 칸의 개수를 저장할 필요가 있으며, 최소값을 구해야 한다.

문제 풀이
1. BFS로 푼다고 가정을 한다면, while문을 돌았을 때,
   내가 필요한 것은 이제까지 걸은 수와 현재 있는 위치를 알 수 있는 클래스 변수가 필요
2. BFS 에서 두 장소가 같은 장소인지 비교하는 함수가 필요하다. --> 지나온 칸 수를 RETURN 하기 위해
3. BFS 에서 다음 장소를 정하기 위하여,
   현재 위치에서 각각 UP, DOWN, RIGHT, LEFT 로 한번씩 가는 Location class 내부 함수가 필요

*/
public class FourQnAnswer {

    class Location {
        int x,y;
        Location(int x, int y) { this.x = x; this.y = y; }

        public boolean equals(Location other) {
            return this.x == other.x && this.y == other.y;
        }

        // 이동 함수
        Location left() { return new Location(x-1, y); }
        Location right() { return new Location(x+1, y); }
        Location down() { return new Location(x, y-1); }
        Location up() { return new Location(x, y+1); }

    }

    class Position {
        Location location;
        int steps;

        public Position(Location location, int steps) {
            this.location = location;
            this.steps = steps;
        }
    }

    public int Tsolution(int[][] maps) {
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;

        // 맵 사이즈로 visited를 만들기
        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        // 최종목적지 (map 크기의 우측 하단)
        final Location target = new Location(mapSizeX - 1 , mapSizeY - 1);

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(new Location(0, 0), 1));

        while(!q.isEmpty()) {
            Position now = q.poll();

            // 현재 위치한 곳이 맵 밖인 경우
            if(now.location.x < 0) continue;
            if(now.location.y < 0) continue;
            if(now.location.x >= mapSizeX) continue;
            if(now.location.y >= mapSizeY) continue;

            // 방문한 곳인 경우 에는 continue, 방문한 곳이 아니라면 true로
            if(visited[now.location.x][now.location.y]) continue;
            visited[now.location.x][now.location.y] = true;

            // 현재 위치한 곳이 벽인 경우
            if(maps[now.location.x][now.location.y] == 0) continue;


            // now가 목적지에 도착하였는지 확인
            // if(최종->위치) return 결과값 -> 걸음수;
            if(now.location.equals(target)) return now.steps;

            // 다음 가야할 곳을 offer 하기
            q.offer(new Position(now.location.left(), now.steps + 1));
            q.offer(new Position(now.location.right(), now.steps + 1));
            q.offer(new Position(now.location.up(), now.steps + 1));
            q.offer(new Position(now.location.down(), now.steps + 1));
        }
        return -1;
    }

}
