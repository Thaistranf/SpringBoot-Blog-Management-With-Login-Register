package com.example.springbootblogmanagement.controller;


import com.example.springbootblogmanagement.model.Blog;
import com.example.springbootblogmanagement.model.User;
import com.example.springbootblogmanagement.repository.BlogRepository;
import com.example.springbootblogmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class APIBlogController {
    @Autowired
    private BlogRepository blogRepository;

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAll(){
        List<Blog> blogList = blogRepository.findAll();
        if (blogList.isEmpty()){  //Neu list rong
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     //Tra ve KQ la ko co noi dung
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

//    @PostMapping
//    public Blog save(@RequestBody Blog blog) {
//        User user = userRepository.findById(blog.getUser().getId()).orElseThrow(
//                () -> new RuntimeException("User not found"));
//
//        Blog newBlog = new Blog();
//        newBlog.setContent(blog.getContent());
//        newBlog.setTitle(blog.getTitle());
//        newBlog.setTime(blog.getTime());
//        newBlog.setUser(user);
//
//        return blogRepository.save(newBlog);
//    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        return new ResponseEntity<>(blogRepository.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> edit(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (!blogOptional.isPresent()){  //Neu hien tai khong co doi tuong tim theo id trong bang CSDL
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  //Tra ve KQ la khong tim thay
        }
        blog.setId(blogOptional.get().getId());     //
        return new ResponseEntity<>(blogRepository.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id) {
//        Dung 1 trong 2 cai
//        Optional<Blog> blogOptional = blogRepository.findById(id);
//        if (!blogOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        blogRepository.deleteById(id);
//        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);

        blogRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
