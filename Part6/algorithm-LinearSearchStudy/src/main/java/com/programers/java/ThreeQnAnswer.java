package com.programers.java;

import java.util.*;

public class ThreeQnAnswer {

    public static int Tsolution02(String skill, String[] skill_trees) {
        return (int)Arrays.stream(skill_trees)
                .map(s->s.replaceAll("[^" + skill + "]", ""))
                .filter(s -> skill.startsWith(s))
                .count();
    }

    public static int Tsolution01(String skill, String[] skill_trees) {
        int answer = 0;

        for(String sk : skill_trees) {
            // ** skill 이외의 글자는 전부 없앤다.
            sk.replace("[^" + skill + "]", "");
            if(sk.startsWith(skill)) answer++;
        }

        return answer;
    }

    public static int mySolution03(String skill, String[] skill_trees) {
        int answer = 0;

        Queue<Character> q = new LinkedList<>();

        for(String sk : skill_trees) {
            for(Character c : skill.toCharArray()) q.offer(c);

            for(int i=0; i<sk.length();i++) {
                if(q.isEmpty()) break;
                if(sk.charAt(i) == q.peek()) q.poll();
            }
            if(q.size() < skill.length()-1) answer++;
            q.clear();
        }

        return answer;
    }

    public static int mySolution02(String skill, String[] skill_trees) {
        int answer = 0;
        int skill_index = 0;
        List<String> skilltree = new LinkedList<>();
        for(String sk : skill_trees) {
            for(int i=0; i<sk.length();i++) {
                if(skill_index+1 == skill.length()) break;
                String s1 = Character.toString(skill.charAt(skill_index));
                String s2 = Character.toString(sk.charAt(i));
                if(s1.equals(s2)) {
                    skill_index++;
                    skilltree.add(s2);
                }
            }
            if(skilltree.toString().equals(skill)) answer++;
            skilltree.clear();
        }

        return answer;
    }

    public static int mySolution01(String skill, String[] skill_trees) {
        int answer = 0;
        int skill_index = 0;
        List<String> skilltree = new LinkedList<>();
        for(String sk : skill_trees) {
            for(int i=0; i<sk.length();i++) {
                if(skill_index+1 == skill.length()) break;
                String s1 = Character.toString(skill.charAt(skill_index));
                String s2 = Character.toString(sk.charAt(i));
                if(s1.equals(s2)) {
                    skill_index++;
                    skilltree.add(s2);
                }
            }
            if(skilltree.toString().equals(skill)) answer++;
            skilltree.clear();
        }

        return answer;
    }
    
}
