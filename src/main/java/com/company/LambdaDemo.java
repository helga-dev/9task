package com.company;

import javax.lang.model.type.NullType;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * 3. Напишите класс LambdaDemo с набором открытых статических неизменяемых полей,
 * которым в качестве значений присвоены следующие лямбда-выражения (можно  использовать ссылки на методы).
 * При необходимости напишите нужные интерфейсы.
 * 1) для строки символов получить ее длину,
 * 2) для строки символов получить ее первый символ, если он существует, или null иначе,
 * 3) для строки проверить, что она не содержит пробелов,
 * 4) слова в строке разделены запятыми, по строке получить количество слов в ней,
 * 5) по человеку получить его возраст,
 * 6) по двум людям проверить, что у них одинаковая фамилия,
 * 7) получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел),
 * 8) сделать человека старше на один год (по объекту Human создать новый объект),
 * 9) по трем людям и заданному возрасту maxAge проверить, что все три человека моложе  maxAge.
 */
public class LambdaDemo {
    public static final Function<String, Integer> getLength = String::length;
    public static final Function<String, Character> getFirstSymbol = str -> {
        Character res = null;
        if (str.isEmpty()) {
        } else res = str.charAt(0);
        return res;
    };
    //просто второй вариант реализации 2)
    public static final Function<String, Character> getFirstSymbol2 = str ->
            (str == null || str.isEmpty()) ? null : str.charAt(0);

    public static final Function<String, Boolean> doesNotHaveSpaces = str ->
            str != null && str.equals(str.replace(" ", ""));

    public static final Function<String, Integer> countWords = str -> {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException("str is null or empty");
        int count = 1;
        for (char elem : str.toCharArray()) {
            if (elem == ',') count++;
        }
//        str.split(",")
        return count;
    };
    public static final Function<Human, Integer> getHumanAge = Human::getAge;
    public static final BiPredicate<Human, Human> isSurnameEqual = (h1, h2) -> {
        if (h1 == null) throw new IllegalArgumentException("h1 is null");
        if (h2 == null) throw new IllegalArgumentException("h2 is null");
        return (h1.getSurname().equals(h2.getSurname()));
    };
    public static final Function<Human, String> getFullName = h1 -> {
        if (h1 == null) throw new IllegalArgumentException("h1 is null");
        String res;
        res = h1.getSurname() + " " + h1.getName() + " " + h1.getPatronymic();
        return res;
    };
    public static final Function<Human, Human> gettingOlder = h1 -> {
        if (h1 == null) throw new IllegalArgumentException("h1 is null");
        Human h2 = new Human(h1.getName(), h1.getSurname(), h1.getPatronymic(), h1.getAge() + 1, h1.getGender());
        return h2;
    };


    public static final BiPredicate<Human, Integer> isHumanYounger = (h1, maxAge) -> {
        if (h1 == null) throw new IllegalArgumentException("h1 is null");
        return h1.getAge() < maxAge;
    };

 public static final IHumansYounger<Human, Human, Human,Integer, Boolean> areHumansYounger = (h1,h2,h3,maxAge) ->
         isHumanYounger.test(h1,maxAge) && isHumanYounger.test(h2, maxAge) && isHumanYounger.test(h3, maxAge);


interface IHumansYounger<A, B, C, D, E> {
    E test(A h1, B h2, C h3, D maxAge);
}



}
