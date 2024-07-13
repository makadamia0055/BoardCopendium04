package com.example.boardcopendium04.repository;


import com.example.boardcopendium04.domain.post.Posts;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @BeforeEach
    public void setUp() {
        IntStream.rangeClosed(0, 100).forEach(i-> {
            Posts build = Posts.builder()
                    .title("title.. " + i)
                    .content("content.. " + i)
                    .author("author" + i)
                    .build();
            postsRepository.save(build);
        });
    }

    @AfterEach
    public void clearAll(){
        postsRepository.deleteAll();
    }

    @Test
    public void testPostsSave() throws Exception{
        //given

        //when
        List<Posts> all = postsRepository.findAll();
        Posts posts = postsRepository.findById(101L).orElseThrow(() -> new Exception());
        //then
        Assertions.assertThat(all.size()).isEqualTo(101);
        log.info(posts.getId() + " " + posts.getTitle() + " " + posts.getContent() + " " + posts.getAuthor());

    }

    @Test
    public void testPostsUpdate() throws Exception{
        //given

        List<Posts> all = postsRepository.findAll();
        Posts posts = all.get(0);

        Long id = posts.getId();

        //when
        posts.change("changedTitle", "changedContent");

        postsRepository.save(posts);

        //then
        Posts posts1 = postsRepository.findById(id).orElseThrow(() -> new Exception());
        Assertions.assertThat(posts1.getTitle()).isEqualTo("changedTitle");
        Assertions.assertThat(posts1.getContent()).isEqualTo("changedContent");


    }
}