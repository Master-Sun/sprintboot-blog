package com.kzzf.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")  // 设置多对多的关系，被维护的一方需要指定关联的字段
    private List<Blog> blogs = new ArrayList<>();
    public Tag() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
