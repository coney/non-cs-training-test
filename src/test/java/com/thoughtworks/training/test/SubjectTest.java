package com.thoughtworks.training.test;

import com.thoughtworks.training.test.task3.Person;
import com.thoughtworks.training.test.task3.Student;
import com.thoughtworks.training.test.task3.Teacher;
import com.thoughtworks.training.test.task5.Score;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubjectTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * task 0: 两整数相加(环境验证)
     * 将参数传入的两个整数相加, 返回相加结果
     * task 0用于验证测试环境可用, 运行该测试用例, 确保用例执行通过. 若不通过则请在答题前解决编译或运行问题
     */
    @Test
    public void task_0() {
        assertThat(Subject.solveTask0(1, 2), is(3));
    }

    /**
     * task 1: 数组过滤及累加
     * 从输入的数据中过滤掉所有奇数, 将剩余的偶数累加并返回
     */
    @Test
    public void task_1() {
        final int[] inputs1 = new int[]{1, 2, 3, 4};
        assertThat(Subject.solveTask1(inputs1), is(6));

        final int[] inputs2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(Subject.solveTask1(inputs2), is(20));

        final int[] inputs3 = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        assertThat(Subject.solveTask1(inputs3), is(188));
    }

    /**
     * task 2: 简答
     * Java中的重写（Overriding）和重载（Overloading）是什么意思
     */


    /**
     * task 3: 学生与老师类的抽象与继承
     * 分别构造Student和Teacher对象, 构造函数参数为他们所属班级号, 他们的共同父类是Person类.
     * 当调用父类中声明的report方法时, 两个对象分别以字符串方式返回自己的角色和所属班级
     */
    @Test
    public void task_3() {
        final Person studentFromClass1 = new Student(1);
        assertThat(studentFromClass1.report(), is("I am a student from Class 1"));

        final Person teacherFromClass2 = new Teacher(2);
        assertThat(teacherFromClass2.report(), is("I am a teacher from Class 2"));
    }

    /**
     * task 4: 简答
     * 电器是指以电能来进行驱动的用具，冰箱、烤箱、蒸箱、微波炉都是电器，
     * 现在市面上出现了一种集成度更高的产品，同时具备蒸、烤、微波的一体机。
     * 请根据你对这些电器的理解来设计类/接口
     */

    /**
     * task 5: 根据输入的成绩单列表过滤及格的(60分及格线)成绩, 并输出成绩最高的成绩单姓名
     * 1. 过滤掉所有不及格成绩
     * 2. 从及格成绩中找出得分最高的成绩单并以字符串返回姓名
     * 3. 如果没有及格成绩则跑出RuntimeException
     * 请优先使用Java Stream API及Lambda
     */
    @Test
    public void task_5() {
        final Score alice = new Score("alice", 87);
        final Score bob = new Score("bob", 45);
        final Score charlie = new Score("charlie", 59);
        final Score david = new Score("david", 91);

        // 过滤出及格的成绩单, 返回姓名
        final List<Score> scoreList1 = Arrays.asList(alice, bob, charlie);
        assertThat(Subject.solveTask4(scoreList1), is("alice"));

        // 当有多个成绩及格时, 返回成绩最高的姓名
        final List<Score> scoreList2 = Arrays.asList(alice, bob, charlie, david);
        assertThat(Subject.solveTask4(scoreList2), is("david"));

        // 当没有成绩及格时, 抛出RuntimeException
        final List<Score> scoreList3 = Arrays.asList(bob, charlie);
        exceptionRule.expect(RuntimeException.class);
        Subject.solveTask4(scoreList3);
    }
}