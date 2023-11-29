package com.example.backend.responsitory;


import com.example.backend.modules.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostComponentResponsitory extends JpaRepository<PostComment,Long> {
}
