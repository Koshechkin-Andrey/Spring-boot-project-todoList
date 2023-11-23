package com.example.todolist.predicate;

import com.example.todolist.entity.QTask;
import com.example.todolist.entity.Task;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.todolist.entity.QTask.task;
@RequiredArgsConstructor
public class TaskFilterRepositoryImpl implements TaskFilterRepository {

    private final EntityManager entityManager;

    @Override
    public List<Task> findAllByTaskFilter(TaskFilter filter) {
        Predicate predicate = PredicateExample.create()
                .add(filter.Status(), task.status.stringValue()::equalsIgnoreCase)
                .whereOr();
        return new JPAQuery<Task>(entityManager)
                .select(task)
                .from(task)
               .where(predicate)
                .fetch();
    }
}
