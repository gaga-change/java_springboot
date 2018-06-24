package com.yanjd.girl;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    public GirlService girlService;

    @GetMapping(value = "/girls/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

    /**
     * 查询所有 girl
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls(
            @RequestParam(value = "age", required = false) Integer age
    ) {

        if (age == null) {
            return girlRepository.findAll();
        } else {
            return girlRepository.findByAge(age);
        }
    }

    // 查询指定 girl
    @GetMapping(value = "/girls/{id}")
    public Girl getGirl(
            @PathVariable("id") Integer id
    ) {
        return girlRepository.findById(id).orElse(null);
    }

    // 更新 girl
    @PutMapping(value = "/girls/{id}")
    public Girl setGirls(
            @PathVariable("id") Integer id,
            @RequestParam("age") Integer age,
            @RequestParam("name") String name,
            @RequestParam(value = "cupSize", required = false) String cupSize
    ) {
        Girl girl = new Girl(id, age, name, cupSize);
        return girlRepository.save(girl);
    }

    // 删除 girl
    @DeleteMapping(value = "/girls/{id}")
    public void delGirls(
            @PathVariable("id") Integer id
    ) {
        girlRepository.deleteById(id);
    }

    /**
     * 增加 girl
     *
     * @param age     年龄
     * @param name    姓名
     * @param cupSize ..
     * @return Girl
     */
    @PostMapping(value = "/girls")
    public Girl addGirl(
            @RequestParam("age") Integer age,
            @RequestParam("name") String name,
            @RequestParam("cupSize") String cupSize
    ) {
        Girl girl = new Girl(age, name, cupSize);
        return girlRepository.save(girl);
    }

}
