package com.ron.licenta.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("demo")
@Transactional(readOnly = true)
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Transactional
    @GetMapping("{id}")
    public DemoDTO getDemos(@PathVariable("id") Integer id){
        return demoService.getDemos(id);
    }
}
