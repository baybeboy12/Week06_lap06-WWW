package com.example.backend.responsitory;


import com.example.backend.modules.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostResponsitory extends JpaRepository<Post,Long> {
}
