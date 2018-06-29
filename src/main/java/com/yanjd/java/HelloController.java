package com.yanjd.java;

import com.yanjd.java.girl.Girl;
import com.yanjd.java.girl.GirlPropertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private GirlPropertise girlPropertise;

    // 获取请求擦书
    @RequestMapping(value = {"/hello", "hi"})
    public String say(@RequestParam("type") String type) {
        return type;
    }
    // 给参数配置默认值
    @RequestMapping(value = {"/api01"})
    public String api01(@RequestParam(value="type", required = false, defaultValue = "00") String type) {
        return type;
    }
    // 给参数配置默认值
    @GetMapping(value = "/api02")
    public String api02(@RequestParam(value="type", required = false, defaultValue = "00") String type) {
        return type;
    }
    @GetMapping(value = "/list")
    public List<Girl> api03() {
        List<Girl> list = new ArrayList<Girl>();
        list.add(new Girl(1, "test", "g"));
        return list;
    }
    @GetMapping(value = "/map")
    public Map<Integer, Girl> api04() {
        Map<Integer, Girl> map = new HashMap<Integer, Girl>();
        map.put(1, new Girl(1, "test", "f"));
        map.put(2, new Girl(1, "test1", "f"));
        return map;
    }
}
