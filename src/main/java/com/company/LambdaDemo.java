package com.company;

import javax.lang.model.type.NullType;
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
    public static final Function<String, int> getLength = String::length;
    public static final Function<String, Character> getFirstSymbol = str -> {
        Character res = null;
        if(str.isEmpty()) {
        } else res = str.charAt(0);
        return res;
    };
    //просто второй вариант реализации 2)
    public static final Function<String, Character> getFirstSymbol2 = str -> (str == null || str.isEmpty()) ? null:str.charAt(0);
}
