package com.example.springbootblogmanagement.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;     //Noi dung
    private String title;       //Tieu de
    @CreationTimestamp      //Tự động thêm thời gian hiện tại của hệ thống vào bảng CSDL mà không cần tạo trường time cho create.html
    private Date time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Blog() {
    }

    public Blog(Long id, String content, String title, Date time) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.time = time;
    }

    public Blog(Long id, String content, String title, Date time, User user) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.time = time;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
