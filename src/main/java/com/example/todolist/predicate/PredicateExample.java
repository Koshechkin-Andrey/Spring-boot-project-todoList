package com.example.todolist.predicate;


import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PredicateExample {

    List<Predicate> predicates = new ArrayList<>();

    public static PredicateExample create() {
        return new PredicateExample();
    }

    public <T> PredicateExample add(T obj, Function<T, Predicate> function) {
        if (obj != null) {
            predicates.add(function.apply(obj));
        }
        return this;
    }

    public Predicate whereAnd(){
        return ExpressionUtils.anyOf(predicates);
    }

    public Predicate whereOr(){
        return ExpressionUtils.allOf(predicates);
    }
}
