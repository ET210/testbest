package com.cyy.controller;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        // 定义一个整数列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("numbers = " + numbers);
        // 使用Stream流进行操作
        int sumOfEvenDoubledNumbers = numbers.stream()
                // 过滤出偶数
                .filter(num -> num % 2 == 0)
                // 将每个元素都乘以2
                .map(num -> num * 2)
                // 将所有结果求和
                .reduce(0, (a, b) -> a + b);

        // 输出结果
        System.out.println("过滤出偶数，每个数乘以2，然后求和的结果为：" + sumOfEvenDoubledNumbers);
    }
}
