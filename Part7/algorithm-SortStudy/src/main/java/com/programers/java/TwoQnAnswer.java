package com.programers.java;
import java.util.*;
public class TwoQnAnswer {

    public String[] Tsolution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }

    public String[] mySolution02(String[] strings, int n) {

        for(int i=1; i<strings.length; i++) {
            char c = strings[i].charAt(n);
            String temp;
            for (int j = 0; j < i; j++) {
                if (c < strings[j].charAt(n) || (c == strings[j].charAt(n) && strings[j].compareTo(strings[i]) > 0)) {
                    temp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = temp;
                }
            }
        }

        return strings;
    }

    public String[] sort(int i, String[] strings, int n) {

        char c = strings[i].charAt(n);
        String temp;
        for (int j = 0; j < i; j++) {
            if (c < strings[j].charAt(n)) {
                temp = strings[j];
                strings[j] = strings[i];
                strings[i] = temp;
            } else if (c == strings[j].charAt(n)) {
                strings = sort(i, strings, n + 1);
            }
        }
        return strings;
    }
    public String[] mySolution01(String[] strings, int n) {

        for(int i=1; i<strings.length; i++) {
            strings = sort(i, strings, n);
        }

        return strings;
    }


}
