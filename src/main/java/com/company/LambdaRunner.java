package com.company;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaRunner {
    public  static <T, R> R run(Function<T,R> func, T arg) {
         return func.apply(arg);
    }
    public static <T,U> boolean run(BiPredicate<T, U> func, T arg1, U arg2){
        return func.test(arg1, arg2);
    }
}
