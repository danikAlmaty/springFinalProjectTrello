package com.example.danik.spring.springFinalProject.repositories;

import com.example.danik.spring.springFinalProject.entities.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategories, Long> {
}
