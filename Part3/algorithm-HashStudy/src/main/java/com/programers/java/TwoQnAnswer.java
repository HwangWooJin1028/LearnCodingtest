package com.programers.java;

import java.util.*;

public class TwoQnAnswer {
    // O(nlogn)
    public String Tsolution03(String[] participant, String[] completion) {
        // 참가자와 완주자 리스트를 sort를 한다.
        Arrays.sort(participant); // n명
        Arrays.sort(completion); // n-1명

        // 만약 완주자와 참가자의 요소가 일치하지 않으면 그 참가자는 완주하지 못했다는 의미이므로
        // 그 참가자 이름을 반환
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[participant.length-1];
    }
    // O(2n)
    public String Tsolution02(String[] participant, String[] completion) {
        Map<String, Integer> players = new HashMap<>();

        // 모든 player를 가진 map을 만든다. 이때, 만약 동명이인이 있으면 value는 2가 된다.
        for(String p : participant) {
            players.put(p, players.getOrDefault(p, 0) + 1);
        }

        // 만약 동명이인이 아니고 완주자일 경우는 n은 0이 된다.
        for(String c : completion) {
            int n = players.get(c) - 1;
            if(n == 0) players.remove(c);
            else players.put(c, n);
            // players.put(c, players.getOrDefault(c, 0) - 1);
        }

        // 단 한명밖에 안남은 player를 꺼냄.
        return players.keySet().iterator().next();
    }
    public String Tsolution01(String[] participant, String[] completion) {
        List<String> players = new LinkedList<>();
        String answer = "";

        // 모든 player가 담긴 list에서 완주자를 뺀다.
        for(String p : participant) players.add(p);
        for(String c : completion) players.remove(c); // <--- 이 부분이 오래걸림.

        return answer;
    }

    public String mySolution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Boolean> map = new HashMap<>();
        List<String> completionList = new ArrayList<String>(Arrays.asList(completion));
        List<String> participantList = new ArrayList<String>(
                Arrays.asList(participant));

        Collection<Boolean> values = map.values();

        for(int i=0; i<participantList.size(); i++) {
            if(completionList.contains(participantList.get(i))) {
                if(map.get(participantList.get(i)) != null) {
                    return participantList.get(i);
                }
                map.put(participantList.get(i), true);
            }
            else if(!completionList.contains(participantList.get(i))) {
                return participantList.get(i);
            }

        }

        return answer;
    }
}
