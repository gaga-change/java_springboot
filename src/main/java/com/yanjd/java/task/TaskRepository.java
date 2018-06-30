package com.yanjd.java.task;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {
    List<Task> findByClose(Boolean close);
    Page<Task> findByClose(Boolean close, Pageable pageable);
    List<Task> findByRemove(Boolean close);
    Page<Task> findByRemove(Boolean close, Pageable pageable);
}
