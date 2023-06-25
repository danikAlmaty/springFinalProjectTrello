package com.example.danik.spring.springFinalProject.controllers;

import com.example.danik.spring.springFinalProject.entities.Folders;
import com.example.danik.spring.springFinalProject.entities.TaskCategories;
import com.example.danik.spring.springFinalProject.services.CommentService;
import com.example.danik.spring.springFinalProject.services.FolderService;
import com.example.danik.spring.springFinalProject.services.TaskCategoryService;
import com.example.danik.spring.springFinalProject.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final FolderService folderService;
    private final CommentService commentService;
    private final TaskCategoryService taskCategoryService;
    private final TaskService taskService;
    @GetMapping(value = "/")
    public String homePage(Model model){
        model.addAttribute("folders", folderService.getFolders());
        return "index";
    }

    @GetMapping(value = "/details/{folderId}")
    public String folderDetails(
            @PathVariable(name = "folderId") Long id, Model model
    ){
        Folders folder = folderService.getFolder(id);
        model.addAttribute("folder", folder);

        List<TaskCategories> categories = taskCategoryService.getCategories();
        categories.removeAll(folder.getCategories());
        model.addAttribute("categories", categories);
        return "details";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folders folder){
        folderService.saveFolder(folder);
        return "redirect:/";
    }

    @PostMapping(value = "/assign-category")
    public String assignCategory(
        @RequestParam(name = "folder_id") Long folderId,
        @RequestParam(name = "category") Long categoryId
    ){
        folderService.assignCategory(folderId, categoryId);
        return "redirect:/details/" + folderId;
    }

    @PostMapping(value = "/unAssign-category")
    public String deleteCategory(
        @RequestParam(name = "folder_id") Long folderId,
        @RequestParam(name = "category") Long categoryId
    ){
        folderService.unAssignCategory(folderId, categoryId);
        return "redirect:/details/" + folderId;
    }
}
