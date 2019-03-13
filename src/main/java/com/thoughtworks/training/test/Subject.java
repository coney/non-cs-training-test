package com.thoughtworks.training.test;

import com.thoughtworks.training.test.task5.Score;

import java.util.List;

public class Subject {

    /**
     * 两整数相加(环境验证)
     *
     * @param number1 整数1
     * @param number2 整数2
     * @return 输入的整数和
     */
    public static int solveTask0(int number1, int number2) {
        return number1 + number2;
    }

    /**
     * 数组过滤及累加
     *
     * @param numbers 整数列表
     * @return 过滤累加结果
     */
    public static int solveTask1(int[] numbers) {
        throw new UnsupportedOperationException();
    }

    /**
     * 根据输入的成绩单列表过滤及格的(60分及格线)成绩, 并输出成绩最高的成绩单姓名
     *
     * @param scores 成绩单列表
     * @return 成绩最高的成绩单姓名
     * @throws RuntimeException 如果没有及格的成绩单则抛出
     */
    public static String solveTask4(List<Score> scores) throws RuntimeException {
        throw new UnsupportedOperationException();
    }
}
