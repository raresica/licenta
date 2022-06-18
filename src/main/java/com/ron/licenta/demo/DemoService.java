package com.ron.licenta.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public List<Demo> saveAll(List<Demo> demos){
        return (List<Demo>) demoRepository.saveAll(demos);
    }

    public DemoDTO getDemos(Integer id){
        String resultSet = demoRepository.getDemos(id)[0];
        String[] tokens = resultSet.split(",");
        return new DemoDTO(
                Integer.parseInt(tokens[0]),
                tokens[1],
                Integer.parseInt(tokens[2])
        );
    }
}
