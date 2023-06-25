package com.example.danik.spring.springFinalProject.services;

import com.example.danik.spring.springFinalProject.entities.Comments;
import com.example.danik.spring.springFinalProject.entities.Tasks;
import com.example.danik.spring.springFinalProject.repositories.CommentsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentsRepository commentsRepository;

    public List<Comments> allCommentsByFolderId(Long id){
        return commentsRepository.allCommentsByFolder(id);
    }

    public void addCommentToTask(Comments comment){
        commentsRepository.save(comment);
    }

    @Transactional
    public void deleteCommentsThatBelongsToTasks(List<Long> taskIds){
        commentsRepository.deleteByTaskIds(taskIds);
    }

    public List<Comments> allCommentsIdByTask(Tasks task){
        return commentsRepository.findAllByTaskIs(task);
    }

    @Transactional
    public void deleteCommentsThatBelongsToTask(Long taskId){
        commentsRepository.deleteByTaskId(taskId);
    }
}
