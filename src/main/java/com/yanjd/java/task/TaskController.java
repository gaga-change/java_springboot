package com.yanjd.java.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 查询所有任务
     *
     * @return
     */
    @GetMapping(value = "/task")
    public List<Task> findAll() {
        return taskRepository.findAll();
    }


    /**
     * 获取任务详情
     * @param id
     * @return
     */
    @GetMapping(value = "/task/{id}")
    public Task getTaskOne(
            @PathVariable("id") Integer id
    ) {
        return taskRepository.findById(id).orElse(null);
    }


    /**
     * 添加任务
     *
     * @param content
     * @return
     */
    @PostMapping(value = "/task")
    public Task saveTask(
            @RequestParam("content") String content
    ) {
        Task task = new Task();
        task.setContent(content);
        return taskRepository.save(task);
    }

    /**
     * 删除任务
     *
     * @param id
     */
    @DeleteMapping(value = "/task/{id}")
    public void deleteTask(
            @PathVariable("id") Integer id
    ) {
        taskRepository.deleteById(id);
    }

    /**
     * 修改任务
     *
     * @param id
     * @param content
     * @return
     */
    @PutMapping(value = "/task/{id}")
    public Task modifyTask(
            @PathVariable("id") Integer id,
            @RequestParam("content") String content
    ) {
        Task task = taskRepository.findById(id).orElse(null);
        task.setContent(content);
        return taskRepository.save(task);
    }
}
