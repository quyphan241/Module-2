package com.codegym.cms.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name= "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Date createDay;
    private String description;
    @OneToMany(targetEntity = Image.class)
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(targetEntity = Comment.class)
    private Set<Comment> comments;

    private int count;


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post() {
    }


    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Category getCategory() {
        return category;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int increment() {
        return this.count++;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", tittle='" + title + '\'' +
                ", content='" + content + '\'' +
                ", images=" + images +
                ", category=" + category +
                ", comments=" + comments +
                '}';
    }
}
