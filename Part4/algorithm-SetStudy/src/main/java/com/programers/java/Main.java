package com.programers.java;

import java.util.Objects;

class MyData {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "" +  v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    // 자신이 만든 클래스의 순서를 보장하기 위해서는 hashCode의 구현이 필수이다.
    @Override
    public int hashCode() {
        return Objects.hashCode(v);
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // LecturePractice.Ex01();
    }
}