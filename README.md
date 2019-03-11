非计测试题目-后端
----

``` java
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
     * task 2: 数字字符串拆分及累加
     * 输入字符串包含若干以逗号分隔的整数, 请解析输入并将所有数字累加以字符串形式返回
     */
    @Test
    public void task_2() {
        final String input1 = "1,1,1,1";
        assertThat(Subject.solveTask2(input1), is("4"));

        final String input2 = "1,2,3,4";
        assertThat(Subject.solveTask2(input2), is("10"));

        final String input3 = "1,1,2,3,5,8,13,21,34,55,89,144";
        assertThat(Subject.solveTask2(input3), is("376"));
    }

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
     * task 4: 根据输入的成绩单列表过滤及格的(60分及格线)成绩, 并输出成绩最高的成绩单姓名
     * 1. 过滤掉所有不及格成绩
     * 2. 从及格成绩中找出得分最高的成绩单并以字符串返回姓名
     * 3. 如果没有及格成绩则跑出RuntimeException
     * 请优先使用Java Stream API及Lambda
     */
    @Test
    public void task_4() {
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

    /**
     * task 5: 从Json中读取成绩单并按照要求格式以字符串输出
     * <p>
     * 输入Json内容如下:
     * input1:
     * {
     * "name": "alice",
     * "gender": "female",
     * "score": 87.5
     * }
     * input2:
     * {
     * "name": "bob",
     * "gender": "male",
     * "score": 91
     * }
     * <p>
     * 输出: 以冒号(:)拼接的字符串, 包含名字, 性别及成绩
     */
    @Test
    public void task_5() throws Exception {
        String input1 = "" +
                "{" +
                "  \"name\": \"alice\"," +
                "  \"gender\": \"female\"," +
                "  \"score\": 87" +
                "}";
        assertThat(Subject.solveTask5(input1), is("alice:female:87"));

        String input2 = "" +
                "{" +
                "  \"name\": \"bob\"," +
                "  \"gender\": \"male\"," +
                "  \"score\": 91" +
                "}";
        assertThat(Subject.solveTask5(input2), is("bob:male:91"));
    }
```

考察点:
- Task 1 基本操作, for循环, if语句
- Task 2 字符串拆分, 解析, 构建
- Task 3 继承, 封装, 多态
- Task 4 Java Stream API, Lambda, Optional, Exception 
- Task 5 Json 反序列化
