package com.yanjd.java.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 查询所有任务
     * @return
     */
    @GetMapping(value = "/task")
    public List<Task> findAll () {
        return taskRepository.findAll();
    }

    /**
     * 添加任务
     * @param content
     * @return
     */
    @PostMapping(value = "/task")
    public Task saveTask (
            @RequestParam("content") String content
    ) {
        Task task = new Task();
        task.setContent(content);
        return taskRepository.save(task);
    }
}
