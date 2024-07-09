package com.programers.java;

public class TwoQnAnswer {

    public int Tsolution(int[] numbers, int target) {
        return sumCount(numbers, target, 0, 0);
    }

    public int sumCount(final int[] numbers, final int target
            , int index , int sum) {

        // 끝까지 다 돈 경우, 만약 targer과 같으면 1, 아니면 0.
        if(index == numbers.length) {
            if(sum == target) return 1;
            return 0;
        }

        // 이 함수의 return 값 1이 쌓이고 쌓여 결국 target 의 값이 나오는 수식의 개수가 + 되어 return 될 것 이다.
        return sumCount(numbers, target, index+1, sum+numbers[index]) +
                sumCount(numbers, target, index+1, sum-numbers[index]);



        // 재귀 호출 : + 하는 경우
        // sumCount(numbers, target, index+1, sum+numbers[index])
        // 재귀 호출 : - 하는 경우
        // sumCount(numbers, target, index+1, sum-numbers[index]);
    }
}
