package com.example.danik.spring.springFinalProject.services;

import com.example.danik.spring.springFinalProject.entities.TaskCategories;
import com.example.danik.spring.springFinalProject.repositories.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCategoryService {
    private final TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategories> getCategories(){
        return taskCategoryRepository.findAll();
    }

    public TaskCategories getCategory(Long categoryId){
        return taskCategoryRepository.findById(categoryId).orElseThrow();
    }
}
