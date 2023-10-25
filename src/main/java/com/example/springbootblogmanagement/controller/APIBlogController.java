package com.example.springbootblogmanagement.controller;


import com.example.springbootblogmanagement.model.Blog;
import com.example.springbootblogmanagement.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIBlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public ResponseEntity findAll(){
        return new ResponseEntity(blogRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity save(@RequestBody Blog blog) {
        blogRepository.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Blog blog) {
        blogRepository.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
