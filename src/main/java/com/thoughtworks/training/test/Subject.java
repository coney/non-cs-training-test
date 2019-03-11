package com.thoughtworks.training.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.test.task4.Score;
import com.thoughtworks.training.test.task5.ScoreItem;

import java.io.IOException;
import java.util.Comparator;
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
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * 数字字符串拆分及累加
     *
     * @param input 以逗号(,)分隔的整数列表
     * @return 所有数字的累加结果
     */
    public static String solveTask2(String input) {
        int sum = 0;
        final String[] values = input.split(",");
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return String.valueOf(sum);
    }

    /**
     * 根据输入的成绩单列表过滤及格的(60分及格线)成绩, 并输出成绩最高的成绩单姓名
     *
     * @param scores 成绩单列表
     * @return 成绩最高的成绩单姓名
     * @throws RuntimeException 如果没有及格的成绩单则抛出
     */
    public static String solveTask4(List<Score> scores) throws RuntimeException {
        return scores.stream()
                .filter(score -> score.getScore() >= 60)
                .max(Comparator.comparingInt(Score::getScore))
                .map(Score::getName)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 从Json中读取成绩单并按照要求格式以字符串输出
     *
     * @param input 输入的成绩单Json字符串
     * @return 以冒号(:)拼接的字符串, 包含名字, 性别及成绩
     */
    public static String solveTask5(String input) throws IOException {
        final ScoreItem scoreItem = new ObjectMapper().readValue(input, ScoreItem.class);
        return String.format("%s:%s:%s", scoreItem.getName(), scoreItem.getGender(), scoreItem.getScore());
    }
}
