package com.yanjd.java.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 查询任务
     *
     * @param page     页码
     * @param pageSize 一页的长度
     * @param sortType 排序方式：level、id(默认)
     * @param close    筛选，是否关闭
     * @param remove   筛选，是否移除
     * @return Page
     */
    @GetMapping(value = "/tasks")
    public Page<Task> findAll(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "sort", defaultValue = "id") String sortType,
            @RequestParam(value = "close", defaultValue = "") String close,
            @RequestParam(value = "remove", defaultValue = "") String remove
    ) {
        // 配置排序方式
        Sort sort;
        if (sortType.equals("level")) {
            sort = new Sort(Sort.Direction.DESC, "level");
        } else {
            sort = new Sort(Sort.Direction.DESC, "id");
        }
        // 分页配置
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);
        // 查询
        Page<Task> datas;
        if (!close.isEmpty()) { // 搜索已关闭的
            datas = taskRepository.findByClose(!close.equals("0"), pageable);
        } else if (!remove.isEmpty()) { // 搜素已移除的
            datas = taskRepository.findByRemove(!remove.equals("0"), pageable);
        } else { // 全部
            datas = taskRepository.findAll(pageable);
        }
        return datas;
    }

    /**
     * 获取任务详情
     *
     * @param id 任务ID
     * @return Task
     */
    @GetMapping(value = "/tasks/{id}")
    public Task getTaskOne(
            @PathVariable("id") Integer id
    ) {
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * 添加任务
     *
     * @param content 内容
     * @param level   优先级
     * @return Task
     */
    @PostMapping(value = "/tasks")
    public Task saveTask(
            @RequestBody Task taskParams
    ) {
        Task task = new Task();
        task.setLevel(taskParams.getLevel());
        task.setContent(taskParams.getContent());
        Task task1 = taskRepository.save(task);
        return task1;
    }

    /**
     * 删除任务
     *
     * @param id
     */
    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask(
            @PathVariable("id") Integer id
    ) {
        taskRepository.deleteById(id);
    }

    /**
     * 修改任务
     *
     * @param id      任务ID
     * @param content 内容
     * @param level   优先级
     * @param close   是否关闭
     * @param remove  是否移除
     * @return Task
     */
    @PutMapping(value = "/tasks/{id}")
    public Task modifyTask(
            @PathVariable("id") Integer id,
            @RequestBody Task taskParams
    ) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) return null;
        task.setContent(taskParams.getContent());
        task.setLevel(taskParams.getLevel());
        task.setClose(taskParams.getClose());
        task.setRemove(taskParams.getRemove());
        task.setModifyTime(new Date());
        return taskRepository.save(task);
    }
}
