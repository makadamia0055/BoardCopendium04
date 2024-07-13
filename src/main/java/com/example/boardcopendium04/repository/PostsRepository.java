package com.example.boardcopendium04.repository;

import com.example.boardcopendium04.domain.post.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
