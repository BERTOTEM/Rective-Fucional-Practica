package com.programacion.reactiva.Sofkasemana2.repository;

import com.programacion.reactiva.Sofkasemana2.models.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveMongoRepository<Book,String> {


}
