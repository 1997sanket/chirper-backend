package com.chirper.post;

import com.chirper.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{userId}/post")
    public void post(@PathVariable String userId, @RequestBody Post post) {

        System.out.println(post);

        post.setUser(userRepository.findById(Integer.parseInt(userId)).get());

        postRepository.save(post);

    }

    @GetMapping("/{userId}/post")
    public List<Post> getPosts(@PathVariable String userId) {

        System.out.println(userId);

        return postRepository.findByUserId(Integer.parseInt(userId));
    }
}
