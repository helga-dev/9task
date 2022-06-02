package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.company.LambdaDemo.*;

public class LamdaDemoTest {

    @Test
    public void test1() {
        String str = "string";
        int expected = str.length();
        Assertions.assertEquals(expected, LambdaDemo.getLength.apply(str));
    }

    @Test
    public void test2_1() {
        String str = "string";
        char firstChar = 's';
        Assertions.assertEquals(firstChar, LambdaDemo.getFirstSymbol.apply(str));

    }

    @Test
    public void test2_2() {
        String str = "";
        Assertions.assertNull(LambdaDemo.getFirstSymbol.apply(str));
    }

    @Test
    public void test3_1() {
        String str = "string";
        Assertions.assertTrue(LambdaDemo.doesNotHaveSpaces.apply(str));
    }

    @Test
    public void test3_2() {
        String str = "s t r i n g";
        Assertions.assertFalse(LambdaDemo.doesNotHaveSpaces.apply(str));
    }

    @Test
    public void test4_1() {
        String str = "It,is,string";
        int expected = 3;
        Assertions.assertEquals(expected, LambdaDemo.countWords.apply(str));
    }

    @Test
    public void test4_2() {
        String str = "string";
        int expected = 1;
        Assertions.assertEquals(expected, LambdaDemo.countWords.apply(str));
    }

    @Test
    public void test5_1() {
        Human human = new Human();
        int exp = human.getAge();
        int act = LambdaDemo.getHumanAge.apply(human);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void test5_2() {
        Student student = new Student();
        int exp = student.getAge();
        int act = LambdaDemo.getHumanAge.apply(student);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void test6_1() {
        Human h1 = new Human();
        Human h2 = new Human();
        Assertions.assertTrue(LambdaDemo.isSurnameEqual.test(h1, h2));
    }

    @Test
    public void test6_2() {
        Human h1 = new Human("aa", "aa", "aa", 20, Gender.NOT_STATED);
        Human h2 = new Human();
        Assertions.assertFalse(LambdaDemo.isSurnameEqual.test(h1, h2));
    }

    @Test
    public void test6_3() {
        Human h1 = new Student();
        Human h2 = new Student();
        Assertions.assertTrue(LambdaDemo.isSurnameEqual.test(h1, h2));
    }

    @Test
    public void test6_4() {
        Human h1 = new Student("aa", "aa", "aa", 20, Gender.NOT_STATED,
                "university", "faculty", "major");
        Human h2 = new Student();
        Assertions.assertFalse(LambdaDemo.isSurnameEqual.test(h1, h2));
    }

    @Test
    public void test7() {
        Human human = new Human();
        String expected = human.getSurname() + " " + human.getName() + " " + human.getPatronymic();
        Assertions.assertEquals(expected, LambdaDemo.getFullName.apply(human));
    }

    @Test
    public void test8() {
        Human expected = new Human();
        Human human = new Human();
        int humanAge = expected.getAge();
        expected.setAge(humanAge + 1);
        Assertions.assertEquals(expected, LambdaDemo.gettingOlder.apply(human));
    }

    @Test
    public void test9_1() {
        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human();
        int maxAge = h1.getAge() + 100;
        Assertions.assertTrue(LambdaDemo.areHumansYounger.test(h1, h2, h3, maxAge));
    }

    @Test
    public void test9_2() {
        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human();
        int maxAge = h1.getAge() - 100;
        Assertions.assertFalse(LambdaDemo.areHumansYounger.test(h1, h2, h3, maxAge));
    }
}
