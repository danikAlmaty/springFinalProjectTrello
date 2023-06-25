package com.example.danik.spring.springFinalProject.repositories;

import com.example.danik.spring.springFinalProject.entities.Folders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoldersRepository extends JpaRepository<Folders, Long> {
}
