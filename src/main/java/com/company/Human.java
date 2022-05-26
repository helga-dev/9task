package com.company;

import java.util.Objects;

/**
 * 1. Напишите класс com.company.Human с полями фамилия, имя, отчество, возраст и пол (перечисление). В
 * классе должны быть конструкторы, геттеры и сеттеры, методы equals и hashCode.
 */
public class Human {
    private String name, surname, patronymic;
    private int age;
    private Gender gender;


    public Human() {
        this.name = "name";
        this.surname = "surname";
        this.patronymic = "patronymic";
        this.age = 21;
        this.gender = Gender.NOT_STATED;

    }

    public Human(String name, String surname, String patronymic, int age, Gender gender) {
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setAge(age);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name is null");
        if (name.isEmpty()) throw new IllegalArgumentException("name is empty");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("surname is null");
        if (surname.isEmpty()) throw new IllegalArgumentException("surname is empty");
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic == null) throw new IllegalArgumentException("patronymic is null");
        if (patronymic.isEmpty()) throw new IllegalArgumentException("patronymic is empty");
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 && age > 150) throw new IllegalArgumentException("age can't be < 0 or > 150");
        this.age = age;

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name) && Objects.equals(surname, human.surname)
                && Objects.equals(patronymic, human.patronymic) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, age, gender);
    }

    @Override
    public String toString() {
        return "com.company.Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", sex=" + gender +
                '}';
    }
}
