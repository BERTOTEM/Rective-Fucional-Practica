package com.programacion.reactiva.Sofkasemana2.models;

import com.mongodb.client.model.Collation;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Document(value = "Books")
public class Book {
    @Id
    private String    id   = new ObjectId().toString();;
    private String title;
    private String author;
    public Book(){}
    public Book (String title,String author) {
        this.author=author;
        this.title=title;
    }
    public Book (String id,String title,String author) {
        this.id=id;
        this.author=author;
        this.title=title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
