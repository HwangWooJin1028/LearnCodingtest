package com.programers.java;

// import java.util.* 를 하여 util 전체를 import한다.

import java.util.List;
import java.util.Vector;

public class ThreeQnAnswer {

    public int[] Tsoultion01(long n) {
        List<Integer> list = new Vector<Integer>();

        while(n>0)  {
            int a = Math.toIntExact(n) % 10; // 맨 마지막 5라는 숫자만 떼어짐
            list.add(a);
            n = n / 10; // 1234만..
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] mySolution01(long n) {
        // 자릿수 찾기
        String nStr = Long.toString(n);
        int intN = Integer.parseInt(Character.toString(nStr.charAt(nStr.length()-1)));

        // 배열 제작하기
        List<Integer> answerList = new Vector<Integer>(intN);
        int index=0;
        for(int i=intN; i>=1; i--) {
            answerList.add(i);
            index++;
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}