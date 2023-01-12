package com.programacion.reactiva.Sofkasemana2.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Books")
public class Book {
    @Id
    private long    id;
    private String title;
    private String author;
    public Book(){}
    public Book (String title,String author) {
        this.author=author;
        this.title=title;
    }
    public Book (Long id,String title,String author) {
        this.id=id;
        this.author=author;
        this.title=title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
